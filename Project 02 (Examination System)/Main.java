import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Quiz> quizzes = new ArrayList<>();
        HashMap<String, Result> resultMap = new HashMap<>();
        HashMap<String, Analytics> analyticsMap = new HashMap<>();

        while (true) {
            System.out.println("\n1. Login as Teacher");
            System.out.println("2. Login as Student");
            System.out.println("3. Exit");
            System.out.print("Select option: ");
            int choice = safeInt(sc);

            if (choice == 1) {
                System.out.print("Enter teacher name: ");
                String tName = sc.nextLine();
                System.out.print("Enter ID: ");
                String tID = sc.nextLine();
                System.out.print("Enter password: ");
                String tPass = sc.nextLine();

                if (!(tName.equalsIgnoreCase("Abdul Salam") && tID.equals("AI24") && tPass.equals("12345"))) {
                    System.out.println("Access Denied. Only Abdul Salam is allowed.");
                    continue;
                }

                Teacher teacher = new Teacher(tName, tID, tPass);
                teacher.showAssignedCourses();

                System.out.println("1. Create Quiz");
                System.out.println("2. View Quiz Results");
                System.out.println("3. View Student Result by ID");
                System.out.print("Choose: ");
                int teacherOption = safeInt(sc);

                if (teacherOption == 1) {
                    System.out.print("Enter quiz ID: ");
                    String quizID = sc.nextLine();

                    int duration;
                    while (true) {
                        System.out.print("Set quiz duration (minutes): ");
                        duration = safeInt(sc);
                        System.out.print("You entered " + duration + " minutes. Confirm? (Y/N): ");
                        if (sc.nextLine().trim().equalsIgnoreCase("y")) break;
                    }

                    Quiz quiz = new Quiz(quizID, "", LocalDateTime.now(), duration);

                    System.out.print("Add how many MCQs? ");
                    int mcqCount = safeInt(sc);
                    for (int i = 0; i < mcqCount; i++) {
                        System.out.print("Question text: ");
                        String qText = sc.nextLine();
                        ArrayList<String> opts = new ArrayList<>();
                        for (char c = 'A'; c <= 'D'; c++) {
                            System.out.print(c + ") ");
                            opts.add(sc.nextLine());
                        }
                        System.out.print("Correct option (A/B/C/D): ");
                        String correct = sc.nextLine();
                        quiz.addQuestion(new MCQ(qText, 5, correct, opts));
                    }

                    System.out.print("Add how many True/False questions? ");
                    int tfCount = safeInt(sc);
                    for (int i = 0; i < tfCount; i++) {
                        System.out.print("Question text: ");
                        String qText = sc.nextLine();
                        System.out.print("Correct answer (True/False): ");
                        String correct = sc.nextLine();
                        quiz.addQuestion(new TrueFalse(qText, 2, correct));
                    }

                    quizzes.add(quiz);
                    resultMap.put(quizID, new Result(quizID));
                    analyticsMap.put(quizID, new Analytics(quizID, quiz.getQuestions()));
                    System.out.println("Quiz created.");

                } else if (teacherOption == 2) {
                    if (resultMap.isEmpty()) {
                        System.out.println("No results available.");
                    } else {
                        for (String quizId : resultMap.keySet()) {
                            Result result = resultMap.get(quizId);
                            Analytics analytics = analyticsMap.get(quizId);

                            System.out.println("\nResult for Quiz: " + quizId);
                            HashMap<String, Integer> scores = result.getAllScores();

                            if (scores.isEmpty()) {
                                System.out.println("No students have attempted this quiz.");
                            } else {
                                System.out.println("Total Students Attempted: " + scores.size());

                                int count = 1;
                                for (Map.Entry<String, Integer> entry : scores.entrySet()) {
                                    String studentID = entry.getKey();
                                    int score = entry.getValue();
                                    String studentName = findStudentNameById(students, studentID);
                                    System.out.println(count + ". " + studentName + " (ID: " + studentID + ") → Score: " + score);
                                    count++;
                                }
                            }

                            System.out.println("\n--- Analytics ---");
                            analytics.generateReport();
                            System.out.println();
                        }
                    }
                } else if (teacherOption == 3) {
                    System.out.print("Enter student ID to search: ");
                    String searchID = sc.nextLine();
                    boolean found = false;
                    for (String quizId : resultMap.keySet()) {
                        int score = resultMap.get(quizId).getScore(searchID);
                        if (score != -1) {
                            System.out.println("Quiz: " + quizId + " → Score: " + score);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("No records found for student ID: " + searchID);
                    }
                } else {
                    System.out.println("Invalid option.");
                }

            } else if (choice == 2) {
                System.out.print("Enter student name: ");
                String sName = sc.nextLine();
                System.out.print("Enter ID: ");
                String sID = sc.nextLine();
                System.out.print("Enter password: ");
                String sPass = sc.nextLine();

                Student student = new Student(sName, sID, sPass);
                students.add(student);

                if (quizzes.isEmpty()) {
                    System.out.println("No quiz available.");
                    continue;
                }

                for (int i = 0; i < quizzes.size(); i++) {
                    System.out.println((i + 1) + ". " + quizzes.get(i).getQuizID());
                }
                System.out.print("Select quiz number to attempt: ");
                int idx = safeInt(sc) - 1;
                if (idx < 0 || idx >= quizzes.size()) {
                    System.out.println("Invalid selection.");
                    continue;
                }

                Quiz qz = quizzes.get(idx);
                Result res = resultMap.get(qz.getQuizID());
                Analytics an = analyticsMap.get(qz.getQuizID());

                int score = 0;
                ArrayList<Question> shuffledQuestions = new ArrayList<>(qz.getQuestions());
                Collections.shuffle(shuffledQuestions);

                System.out.println("----- Starting Quiz: " + qz.getQuizID() + " -----");
                System.out.println("=============================================== ");
                for (Question q : shuffledQuestions) {
                    q.displayQuestion();
                    System.out.print("Your answer: ");
                    String ans = sc.nextLine().trim();
                    if (q.checkAnswer(ans)) {
                        score += q.getMarks();
                        int originalIndex = qz.getQuestions().indexOf(q);
                        if (originalIndex != -1) {
                            an.recordCorrectAnswer(originalIndex);
                        }
                        System.out.println("Correct!");
                    } else {
                        System.out.println("Wrong! Correct answer was: " + q.getCorrectAnswer());
                    }
                    System.out.println();
                }

                an.incrementTotalStudents();
                student.addAttemptedQuiz(qz.getQuizID(), score);
                res.addStudentScore(sID, score);
                System.out.println("Your Score: " + score);
                an.generateReport();

            } else if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
        sc.close();
    }

    private static int safeInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            sc.nextLine();
            System.out.print("Enter a valid number: ");
        }
        int n = sc.nextInt();
        sc.nextLine();
        return n;
    }

    private static String findStudentNameById(ArrayList<Student> students, String id) {
        for (Student s : students) {
            if (s.getUserID().equals(id)) {
                return s.getName();
            }
        }
        return "Unknown";
    }
}

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Quiz {
    private String quizID;
    private String courseCode;
    private LocalDateTime quizDateTime;
    private int durationMinutes;
    private ArrayList<Question> questions;

    public Quiz(String quizID, String courseCode, LocalDateTime quizDateTime, int durationMinutes) {
        this.quizID = quizID;
        this.courseCode = courseCode;
        this.quizDateTime = quizDateTime;
        this.durationMinutes = durationMinutes;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question q) {
        questions.add(q);
    }

    public void displayQuizInfo() {
        System.out.println("Quiz ID: " + quizID);
        System.out.println("Course: " + courseCode);
        System.out.println("Date/Time: " + quizDateTime.format(DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm")));
        System.out.println("Duration: " + durationMinutes + " minutes");
        System.out.println("Total Questions: " + questions.size());
    }

    public int conductQuiz(Student student) {
        System.out.println("----- Starting Quiz: " + quizID + " -----");
        int totalScore = 0;
        Scanner sc = new Scanner(System.in);

        for (Question q : questions) {
            q.displayQuestion();
            System.out.print("Your answer: ");
            String userAnswer = sc.nextLine().trim();

            if (q.checkAnswer(userAnswer)) {
                totalScore += q.getMarks();
                System.out.println("Correct!");
            } else {
                System.out.println("Wrong! Correct answer was: " + q.getCorrectAnswer());
            }

            System.out.println();
        }

        student.addAttemptedQuiz(quizID, totalScore);
        return totalScore;
    }

    public String getQuizID() {
        return quizID;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public LocalDateTime getQuizDateTime() {
        return quizDateTime;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }
}


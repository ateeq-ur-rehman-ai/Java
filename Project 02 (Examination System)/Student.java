import java.util.ArrayList;
import java.util.HashMap;


public class Student extends User {

    private ArrayList<String> attemptedQuizzes;
    private HashMap<String, Integer> quizScores;

    public Student(String name, String userID, String password) {
        super(name, userID, password);     
        attemptedQuizzes = new ArrayList<>();
        quizScores = new HashMap<>();
    }


    public void addAttemptedQuiz(String quizID, int score) {
        attemptedQuizzes.add(quizID);  
        quizScores.put(quizID, score);    
    }

    public void showAttemptedQuizzes() {
        System.out.println("Attempted Quizzes by " + name + ":");
        for (String quiz : attemptedQuizzes) {
            int score = quizScores.get(quiz);
            System.out.println("- " + quiz + " → Score: " + score);
        }
    }


    public int getScore(String quizID) {
        return quizScores.getOrDefault(quizID, -1);
    }
}

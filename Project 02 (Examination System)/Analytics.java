import java.util.ArrayList;
import java.util.HashMap;

public class Analytics {
    private String quizID;
    private ArrayList<Question> questions;
    private HashMap<Integer, Integer> correctCounts;
    private int totalStudents;

    public Analytics(String quizID, ArrayList<Question> questions) {
        this.quizID = quizID;
        this.questions = questions;
        this.correctCounts = new HashMap<>();
        for (int i = 0; i < questions.size(); i++) {
            correctCounts.put(i, 0);
        }
        this.totalStudents = 0;
    }

    public void incrementTotalStudents() {
        totalStudents++;
    }

    public void recordCorrectAnswer(int questionIndex) {
        correctCounts.put(questionIndex, correctCounts.get(questionIndex) + 1);
    }

    public void generateReport() {
        System.out.println("Quiz Analytics Report: " + quizID);
        for (int i = 0; i < questions.size(); i++) {
            int correct = correctCounts.get(i);
            double percentage = totalStudents == 0 ? 0 : (double) correct / totalStudents * 100;
            int barLength = (int) (percentage / 5);
            String type = getQuestionType(questions.get(i));
            System.out.print("Q" + (i + 1) + " [" + type + "]: ");
            for (int j = 0; j < barLength; j++) {
                System.out.print("█");
            }
            System.out.println(" (" + String.format("%.1f", percentage) + "% correct)");
        }
    }

    private String getQuestionType(Question q) {
        if (q instanceof MCQ) return "MCQ";
        if (q instanceof TrueFalse) return "True/False";
        return "Unknown";
    }
}

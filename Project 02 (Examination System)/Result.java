import java.util.HashMap;

public class Result {
    private String quizID;
    private HashMap<String, Integer> studentScores;

    public Result(String quizID) {
        this.quizID = quizID;
        this.studentScores = new HashMap<>();
    }

    public void addStudentScore(String studentID, int score) {
        studentScores.put(studentID, score);
    }

    public int getScore(String studentID) {
        return studentScores.getOrDefault(studentID, -1);
    }

    public void printResultSheet() {
        System.out.println("Result Sheet for " + quizID + ":");
        for (String studentID : studentScores.keySet()) {
         System.out.println("Student: " + studentID + " → Score: " + studentScores.get(studentID));
        }
    }

    public HashMap<String, Integer> getAllScores() {
    return studentScores;
    }
}

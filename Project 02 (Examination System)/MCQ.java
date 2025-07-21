import java.util.ArrayList;

public class MCQ extends Question {

    private ArrayList<String> options;

    public MCQ(String questionText, int marks, String correctAnswer, ArrayList<String> options) {
        super(questionText, marks, correctAnswer);
        this.options = options;
    }

    @Override
    public void displayQuestion() {
        System.out.println("Q: " + questionText + " (" + marks + " marks)");
        char optionLabel = 'A';
        for (String option : options) {
            System.out.println(optionLabel + ") " + option);
            optionLabel++;
        }
    }

    @Override
    public boolean checkAnswer(String userAnswer) {
        return userAnswer.equalsIgnoreCase(correctAnswer);
    }

    public ArrayList<String> getOptions() {
        return options;
    }
}
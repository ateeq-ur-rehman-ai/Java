public class TrueFalse extends Question {

    public TrueFalse(String questionText, int marks, String correctAnswer) {
        super(questionText, marks, correctAnswer);
    }

    @Override
    public void displayQuestion() {
        System.out.println("Q: " + questionText + " (" + marks + " marks)");
        System.out.println("A) True");
        System.out.println("B) False");
    }

    @Override
    public boolean checkAnswer(String userAnswer) {
        return userAnswer.equalsIgnoreCase(correctAnswer);
    }
}

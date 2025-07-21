public abstract class Question {
    protected String questionText;
    protected int marks;
    protected String correctAnswer;

    public Question(String questionText, int marks, String correctAnswer) {
        this.questionText = questionText;
        this.marks = marks;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public int getMarks() {
        return marks;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public abstract void displayQuestion();

    public abstract boolean checkAnswer(String userAnswer);
}


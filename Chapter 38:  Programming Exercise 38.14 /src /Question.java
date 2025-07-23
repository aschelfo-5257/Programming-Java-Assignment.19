public class Question {
    private String questionText;
    private List<String> options;
    private String correctAnswer;
    private String wrongAnswer;

    // Constructor, getters, setters
    public Question(String questionText, List<String> options, String correctAnswer, String wrongAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.wrongAnswer = wrongAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getWrongAnswer() {
        return wrongAnswer;
    }
}

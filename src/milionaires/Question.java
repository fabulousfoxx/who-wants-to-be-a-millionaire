package milionaires;

public class Question {
    private int id;
    private String content;
    private String[] answers = new String[4];
    private int correctAnswerNumber;

    public Question(int id, String content, String[] answers, int correctAnswerNumber) {
        this.id = id;
        this.content = content;
        System.arraycopy(answers, 0, this.answers, 0, 4);
        this.correctAnswerNumber = correctAnswerNumber;
    }

    public boolean isAnswerCorrect(int answerNumber) {
        return answerNumber == correctAnswerNumber;
    }

    @Override
    public String toString() {
        String output = "";

        output += "Question number " + id + "\n";
        output += content + "\n";
        for(int i = 0; i < 4; i++) {
            output += (i + 1) + ". " + answers[i] + "\n";
        }
        output += "Which answer is correct?";

        return output;
    }

    public int getCorrectAnswerNumber() {
        return correctAnswerNumber;
    }
}
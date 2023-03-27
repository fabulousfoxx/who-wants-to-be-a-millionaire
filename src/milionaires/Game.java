package milionaires;

import java.util.Scanner;

public class Game {
    private Scanner scanner;
    public Game() {
        scanner = new Scanner(System.in);
    }

    public void play(QuestionGroup qs) {
        for(int i = 0; i < qs.size(); i++) {
            Question q = qs.get(i);
            System.out.println(q.toString());

            int userAnswer = scanner.nextInt();
            if (q.isAnswerCorrect(userAnswer)) {
                System.out.println("Your answer is correct.\n");
            } else {
                System.out.println("Your answer is incorrect.");
                System.out.println("The correct answer is answer number " + q.getCorrectAnswerNumber() + ".\n");
            }
        }

        scanner.close();
    }
}

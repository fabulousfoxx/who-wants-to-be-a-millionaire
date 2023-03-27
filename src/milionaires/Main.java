package milionaires;

import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/milionerzy";
        String username = "root";
        String password = "";

        Database db = new Database(url, username, password);
        QuestionGroup qs = new QuestionGroup();

        db.connect();
        db.query("SELECT * FROM questions ORDER BY RAND() LIMIT 4");

        ResultSet resultSet = db.getResultSet();
        qs.insertQuestionsFromDB(resultSet);
        db.close();

        Game game = new Game();
        game.play(qs);
    }
}
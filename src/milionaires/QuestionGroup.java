package milionaires;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class QuestionGroup {
    private List<Question> qs;
    private int size;

    public QuestionGroup() {
        qs = new ArrayList<>();
        size = 0;
    }

    public Question get(int i) {
        if(i >= 0 && i < size && size != 0) {
            return qs.get(i);
        } else {
            return null;
        }
    }

    public void add(Question q) {
        qs.add(q);
        size++;
    }

    public int size() {
        return size;
    }

    public void insertQuestionsFromDB(ResultSet resultSet) {
        int id = 0;
        String content = "";
        String[] answers = new String[4];
        int correctAnswer = 0;

        try {
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                content = resultSet.getString("contents");
                for (int i = 0; i < 4; i++) {
                    answers[i] = resultSet.getString("answer" + (i + 1));
                }
                correctAnswer = resultSet.getInt("correct_answer");

                add(new Question(id, content, answers, correctAnswer));
            }
        } catch(SQLException e) {
            Database.printSQLException(e);
        }
    }
}

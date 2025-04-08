import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class User {
    private final int id;
    private final String name;
    private final String email;
    List<Comment> comments;
    List<Answer> answers;
    List<Question> questions;
    private int reputation;

    public User(String name, String email) {
        id = getRandomId();
        this.name = name;
        this.email = email;
        comments = new ArrayList<>();
        answers = new ArrayList<>();
        questions = new ArrayList<>();
    }

    public int getRandomId() {
        return (int) (System.currentTimeMillis()%Integer.MAX_VALUE);
    }

    public void updateReputation(int value) {
        reputation += value;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public int getReputation() {
        return reputation;
    }
}

import java.util.ArrayList;
import java.util.List;

public class User {
    int id;
    String name;
    String email;
    private int reputation;
    List<Question> questions;
    List<Answer> answers;
    List<Comment> comments;

    private static final int QUESTION_REPUTATION = 5;
    private static final int ANSWER_REPUTATION = 10;
    private static final int COMMENT_REPUTATION = 2;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.questions = new ArrayList<>();
        this.answers =  new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public Question askQuestion(String title, String description, List<String> tags) {
        Question question = new Question( title, description, this, tags);
        this.questions.add(question);
        reputation += QUESTION_REPUTATION;
        return question;
    }

    public Answer answerQuestion(String description, Question question) {
        Answer answer = new Answer(description, this, question);
        this.answers.add(answer);
        reputation+= ANSWER_REPUTATION;
        return answer;
    }

    public Comment addComment(Commentable commentable, String description) {
        Comment comment = new Comment(description, this);
        this.comments.add(comment);
        reputation += COMMENT_REPUTATION;
        return comment;
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

    public int getReputation() {
        return reputation;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }
}

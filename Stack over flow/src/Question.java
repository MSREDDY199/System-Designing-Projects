import java.util.ArrayList;
import java.util.List;

public class Question {
    private int id;
    private String content;
    private String title;
    private User author;
    List<Answer> answers;
    List<Tag> tags;
    List<Comment> comments;
    private int votes;

    public static final int QUESTION_UPVOTE_REWARD = 10;


    public Question(String title, String content, User author) {
        id = getRandom();
        this.title = title;
        this.content = content;
        this.author = author;
        answers = new ArrayList<>();
        tags = new ArrayList<>();
        comments = new ArrayList<>();
    }

    public int getRandom() {
        return (int) (System.currentTimeMillis()%Integer.MAX_VALUE);
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public synchronized void upVote() {
        votes++;
        author.updateReputation(QUESTION_UPVOTE_REWARD);
    }

    public synchronized void downVote() {
        votes--;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public User getAuthor() {
        return author;
    }

    public int getVotes() {
        return votes;
    }
}

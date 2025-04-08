import java.util.ArrayList;
import java.util.List;

public class Answer {
    private int id;
    private String content;
    private User author;
    List<Comment> comments;
    private int votes;

    public static final int DOWNVOTE_PENALTY = -2;
    public static final int ANSWER_UPVOTE_REWARD = 20;

    public Answer(String content, User author) {
        id = getRandom();
        this.content = content;
        this.author = author;
        comments = new ArrayList<>();
        votes = 0;
    }

    public int getRandom() {
        return (int) (System.currentTimeMillis()%Integer.MAX_VALUE);
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public synchronized void upVote() {
        votes++;
        author.updateReputation(ANSWER_UPVOTE_REWARD);
    }

    public synchronized void downVote() {
        votes--;
        author.updateReputation(DOWNVOTE_PENALTY);
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public int getVotes() {
        return votes;
    }
}

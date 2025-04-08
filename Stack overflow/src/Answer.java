import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Answer implements Votable, Commentable{
    int id;
    String desciption;
    User author;
    Question question;
    List<Comment> comments;
    List<Vote> votes;
    Date creationDate;
    boolean isAccepted;

    public Answer(String desciption, User author, Question question) {
        this.id = generateId();
        this.desciption = desciption;
        this.author = author;
        this.question = question;

        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();
        creationDate = new Date();
        isAccepted = false;
    }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    @Override
    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    @Override
    public void vote(User user, int value) {
        if (value != 1 && value != -1) {
            throw new IllegalArgumentException("Vote value must be either 1 or -1");
        }
        votes.removeIf(v -> v.getUser().equals(user));
        votes.add(new Vote(user, value));
        author.setReputation(value*10);
    }

    @Override
    public int getVoteCount() {
        return votes.stream().mapToInt(Vote::getValue).sum();
    }

    public void markAsAccepted() {
        if (isAccepted) {
            throw new IllegalStateException("This answer is already accepted");
        }
        isAccepted = true;
        author.setReputation(author.getReputation()+15);  // +15 reputation for accepted answer
    }

    public String getDesciption() {
        return desciption;
    }

    public User getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public Question getQuestion() {
        return question;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}

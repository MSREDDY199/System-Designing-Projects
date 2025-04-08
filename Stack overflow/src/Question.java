import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Question implements Votable, Commentable{
    int id;
    String title, description;
    List<Answer> answers;
    List<Comment> comments;
    List<Vote> votes;
    List<Tag> tags;
    User author;
    Date creationTime;

    public Question(String title, String description, User author, List<String> tagNames) {
        this.id = generateId();
        this.title = title;
        this.description = description;
        comments = new ArrayList<>();
        votes = new ArrayList<>();
        answers = new ArrayList<>();
        this.tags = new ArrayList<>();
        this.author = author;
        creationTime = new Date();
        for (String tagName : tagNames) {
            this.tags.add(new Tag(tagName));
        }
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
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
        author.setReputation(value*5);
    }

    @Override
    public int getVoteCount() {
        return votes.stream().mapToInt(Vote::getValue).sum();
    }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public User getAuthor() {
        return author;
    }

    public Date getCreationTime() {
        return creationTime;
    }
}

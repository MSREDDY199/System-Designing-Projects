import java.util.Date;

public class Comment {
    int id;
    String description;
    User author;
    Date creationsDate;

    public Comment(String description, User author) {
        this.id = generateId();
        this.description = description;
        this.author = author;
        creationsDate = new Date();
    }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public User getAuthor() {
        return author;
    }

    public Date getCreationsDate() {
        return creationsDate;
    }
}

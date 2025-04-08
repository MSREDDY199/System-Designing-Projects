public class Comment {
    int id;
    String content;
    User author;

    public Comment(String content, User author) {
        this.content = content;
        this.author = author;
        id = getRandom();
    }

    public int getRandom() {
        return (int) (System.currentTimeMillis()%Integer.MAX_VALUE);
    }
}

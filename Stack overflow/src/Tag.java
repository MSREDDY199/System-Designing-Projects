public class Tag {
    int id;
    String name;

    public Tag(String name) {
        this.id = generateId();
        this.name = name;
    }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

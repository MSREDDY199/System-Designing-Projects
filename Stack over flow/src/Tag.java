public class Tag {
    int id;
    String name;

    public Tag(String name) {
        this.name = name;
        id = generateRandom();
    }

    public int generateRandom() {
        return (int) (System.currentTimeMillis()%Integer.MAX_VALUE);
    }
}

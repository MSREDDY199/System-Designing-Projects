import java.util.Date;

public class File {
    // file name
    private String name;
    // file content
    private StringBuilder content;
    // creation time
    private String creation_time;

    public File(String name) {
        this.name = name;
        this.content = new StringBuilder();
        this.creation_time = new Date().toString();
    }

    // when user types, appending to file content
    public void type(String text) {
        content.append(text);
    }

    // deleting the content text
    public void deleteLast(int count) {
        int len = content.length();
        content.delete(Math.max(0, len - count), len);
    }

    // find and replace
    public void replace(String oldWord, String newWord) {
        String updated = content.toString().replace(oldWord, newWord);
        content = new StringBuilder(updated);
    }

    // get file content
    public String getContent() {
        return content.toString();
    }

    public void clear() {
        content.setLength(0);
    }

    public void setContent(String newContent) {
        content = new StringBuilder(newContent);
    }

    public String getName() {
        return name;
    }

    public String getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(String creation_time) {
        this.creation_time = creation_time;
    }
}

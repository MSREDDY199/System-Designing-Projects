import java.util.List;
import java.util.*;

public class TextEditor {
    private Map<String, File> files = new HashMap<>();
    private File currentFile;
    private CommandManager cmdManager = new CommandManager();
    private String clipboard = "";

    // create new file
    public void createFile(String name) {
        File file = new File(name);
        files.put(name, file);
        currentFile = file;
    }

    // delete file
    public void deleteFile(String name) {
        files.remove(name);
        if (currentFile != null && currentFile.getName().equals(name)) {
            currentFile = null;
        }
    }

    // open file
    public void openFile(String name) {
        currentFile = files.get(name);
    }

    // when user tries to type something
    public void type(String text) {
        cmdManager.executeCommand(new TypeCommand(currentFile, text));
    }

    // delete text
    public void deleteLast(int count) {
        cmdManager.executeCommand(new DeleteCommand(currentFile, count));
    }

    // find and replace
    public void findAndReplace(String oldWord, String newWord) {
        currentFile.replace(oldWord, newWord);
    }

    // copy text
    public void copy(String text) {
        clipboard = text;
    }

    // paste copied text
    public void paste() {
        type(clipboard);
    }

    // undo the change
    public void undo() {
        cmdManager.undo();
    }

    // redo the change
    public void redo() {
        cmdManager.redo();
    }

    // print content
    public void printContent() {
        System.out.println(currentFile.getContent());
    }
}


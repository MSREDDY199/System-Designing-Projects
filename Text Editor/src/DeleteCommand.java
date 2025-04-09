public class DeleteCommand implements Command {
    private File file;
    private String deletedText;

    // remove content
    public DeleteCommand(File file, int count) {
        String content = file.getContent();
        this.deletedText = content.substring(Math.max(0, content.length() - count));
        this.file = file;
    }

    public void execute() {
        file.deleteLast(deletedText.length());
    }

    public void undo() {
        file.type(deletedText);
    }
}


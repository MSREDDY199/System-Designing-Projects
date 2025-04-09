class TypeCommand implements Command {
    private File file;
    private String text;

    public TypeCommand(File file, String text) {
        this.file = file;
        this.text = text;
    }

    // typing
    public void execute() {
        file.type(text);
    }

    // deleting
    public void undo() {
        file.deleteLast(text.length());
    }
}

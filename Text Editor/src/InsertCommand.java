public class InsertCommand extends EditCommand {
    char c;
    int pos;
    TextBuffer buffer;

    public void execute() {
        buffer.insert(pos, c);
    }

    public void undo() {
        buffer.delete(pos);
    }
}
import java.util.Stack;

public class CommandManager {
    // we're using stacks to track the changes and perform undo redo changes
    Stack<Command> undoStack = new Stack<>();
    Stack<Command> redoStack = new Stack<>();

    public void executeCommand(Command cmd) {
        cmd.execute();
        undoStack.push(cmd);
        redoStack.clear();
    }

    // when user undo the changes, we're removing from undo stack and adding it to redo stack
    public void undo() {
        if (!undoStack.isEmpty()) {
            Command cmd = undoStack.pop();
            cmd.undo();
            redoStack.push(cmd);
        }
    }

    // when user redo the changes, we're removing from redo stack and adding it to undo stack
    public void redo() {
        if (!redoStack.isEmpty()) {
            Command cmd = redoStack.pop();
            cmd.execute();
            undoStack.push(cmd);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.createFile("notes.txt");
        editor.type("Hello ");
        editor.type("world!");
        editor.printContent(); // Hello world!

        editor.deleteLast(6);
        editor.printContent(); // Hello

        editor.undo();
        editor.printContent(); // Hello world!

        editor.findAndReplace("world", "Java");
        editor.printContent(); // Hello Java

        editor.copy(" Java");
        editor.paste();
        editor.printContent(); // Hello Java Java
    }
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Logger fileLogger = new FileLogger(LogLevel.INFO);
        Logger consoleLogger = new ConsoleLogger(LogLevel.DEBUG);
        Logger dbLogger = new DatabaseLogger(LogLevel.WARNING);

        fileLogger.setLogger(consoleLogger);
        consoleLogger.setLogger(dbLogger);

        fileLogger.log(LogLevel.DEBUG, "this is info log.");
    }
}
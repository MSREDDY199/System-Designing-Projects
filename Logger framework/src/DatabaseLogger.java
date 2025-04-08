public class DatabaseLogger extends Logger{
    public DatabaseLogger(LogLevel logLevel) {
        super(logLevel);
    }

    @Override
    public void write(String message) {
        System.out.println(logLevel+": "+message);
    }
}

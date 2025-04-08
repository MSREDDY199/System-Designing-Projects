public class FileLogger extends Logger{
    public FileLogger(LogLevel logLevel) {
        super(logLevel);
    }

    @Override
    public void write(String message) {
        System.out.println(logLevel+": "+message);
    }
}

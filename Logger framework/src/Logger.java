public abstract class Logger {
    protected Logger logger;
    LogLevel logLevel;

    public Logger(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public void log(LogLevel logLevel, String message) {
        if (this.logLevel.ordinal() <= logLevel.ordinal()) {
            logger.write(message);
        }

        if (logger != null) {
            logger.log(logLevel, message);
        }
    }

    public abstract void write(String message);
}

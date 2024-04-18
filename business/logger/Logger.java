package business.logger;

public class Logger {
    private String prefix;

    public Logger(String prefix) {
        this.prefix = prefix;
    }

    public void log(String message) {
        System.out.printf("%s: %s\n", this.prefix, message);
    }
}

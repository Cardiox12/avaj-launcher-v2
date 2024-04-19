package business.logger;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class NoLevelFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        String message = record.getMessage();
        return message + "\n";
    }
}

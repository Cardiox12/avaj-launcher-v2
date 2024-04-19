package business.logger;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AvajLogger {
    private static final Logger logger = Logger.getLogger("tower");

    static {
        
        Handler handler = new ConsoleHandler();
        handler.setFormatter(new NoLevelFormatter());
        logger.addHandler(handler);
        logger.setLevel(Level.ALL);
    }

    public AvajLogger() {}

    public void log(String message) {
        logger.info(message);
        System.out.println("===============");
    }
}

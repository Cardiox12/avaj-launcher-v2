package business.logger;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class AvajLogger {
    private static BufferedWriter fileWriter;
    private static AvajLogger instance;

    private AvajLogger() {}

    public static AvajLogger getInstance() throws Exception {
        if (instance == null) {
            instance = new AvajLogger();
            fileWriter = new BufferedWriter(new FileWriter("simulation.txt"));
        }
        return instance;
    }

    public void log(String message) throws Exception {
        fileWriter.write(String.format("%s\n", message));
    }

    public void close() throws Exception {
        fileWriter.close();
    }
}

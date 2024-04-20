import business.logger.AvajLogger;
import business.scenario.ScenarioInterpreter;

import java.nio.file.Path;

public class AvajLauncher {
  public static void main(String[] args) throws Exception {
    if (args.length != 1) {
      System.err.println("usage: ./avaj-launcher <scenario>");
      System.exit(1);
    }

    Path filePath = Path.of(args[0]);

    ScenarioInterpreter interpreter = new ScenarioInterpreter(filePath);
    
    try {
      interpreter.read();
      interpreter.execute();
    } catch (Exception e) {
      e.printStackTrace();
    }
    AvajLogger.getInstance().close();
  }
}

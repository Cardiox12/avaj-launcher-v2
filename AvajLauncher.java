import business.scenario.ScenarioInterpreter;

public class AvajLauncher {
  public static void main(String[] args) throws Exception {
    // TODO: Logger write in a file
    if (args.length != 1) {
      System.err.println("usage: ./avaj-launcher <scenario>");
      System.exit(1);
    }
    ScenarioInterpreter interpreter = new ScenarioInterpreter(args[0]);

    interpreter.read();
    interpreter.execute();
  }
}

package business.scenario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

import business.aircraft.AircraftFactory;
import business.flyable.Flyable;
import business.tower.WeatherTower;

public class ScenarioInterpreter {
  private final Path filePath;
  private final int iterations;
  private final List<ScenarioLine> lines;

  public ScenarioInterpreter(Path filePath) {
    verifValidFile(filePath);

    this.filePath = filePath;
    this.iterations = 0;
    this.lines = new LinkedList<>();
  }

  public void read() throws Exception {
    try (BufferedReader reader = new BufferedReader(new FileReader(this.filePath.toString()))) {

      String line;
      while ((line = reader.readLine()) != null) {
        this.lines.add(ScenarioLine.parseLine(line));
      }
    }
  }

  public void execute() throws Exception {
    WeatherTower weatherTower = new WeatherTower();
    AircraftFactory aircraftFactory = AircraftFactory.getInstance();

    for (ScenarioLine sl : this.lines) {
      Flyable flyable = aircraftFactory.newAircraft(sl);

      weatherTower.register(flyable);
    }

    for (int i = 0; i < this.iterations; i++) {
      weatherTower.changeWeather();
    }
  }

  private void verifValidFile(Path filePath) {
    if (Files.notExists(filePath)) {
      throw new IllegalArgumentException("ScenarioInterpreter: invalid scenario file: file does not exist");
    }

    if (filePath.toFile().length() == 0) {
      throw new IllegalArgumentException("ScenarioInterpreter: invalid scenario file: empty file");
    }
  }
}

package business.aircraft;

import java.util.UUID;

import business.Coordinates;
import business.flyable.Flyable;
import business.scenario.ScenarioLine;

public class AircraftFactory {
  private static AircraftFactory aircraftFactory;

  private AircraftFactory() {
  }

  public static AircraftFactory getInstance() {
    if (aircraftFactory == null) {
      aircraftFactory = new AircraftFactory();
    }
    return aircraftFactory;
  }

  public Flyable newAircraft(ScenarioLine sl) throws Exception {
    // Generate a random unique ID with a length 5.
    long uuid = Math.abs(UUID.randomUUID().getLeastSignificantBits()) % 100;
    String name = sl.name;
    Coordinates coordinates = sl.coordinates;
    String type = sl.type;

    return switch (type) {
      case "BALOON" -> new Baloon(uuid, name, coordinates);
      case "HELICOPTER" -> new Helicopter(uuid, name, coordinates);
      case "JETPLANE" -> new JetPlane(uuid, name, coordinates);
      default ->
        // TODO: Throw a custom exception
              throw new Exception(String.format("AircraftFactory: unknown aircraft %s", type));
    };
  }
}

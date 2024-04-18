package business.aircraft;

import java.util.UUID;

import business.Coordinates;
import business.flyable.Flyable;

public class AircraftFactory {
    private static AircraftFactory aircraftFactory;

    private AircraftFactory() {}

    public static AircraftFactory getInstance() {
        if (aircraftFactory == null) {
            aircraftFactory = new AircraftFactory();
        }
        return aircraftFactory;
    }

    public Flyable newAircraft(String type, String name, Coordinates coordinates) throws Exception {
        // Generate a random unique ID with a length 5.
        long uuid = Math.abs(UUID.randomUUID().getLeastSignificantBits()) % 100;

        switch (type) {
            case "BALOON":
                return new Baloon(uuid, name, coordinates);
            case "HELICOPTER":
                return new Helicopter(uuid, name, coordinates);
            case "JETPLANE":
                return new JetPlane(uuid, name, coordinates);
        }
        // TODO: Throw a custom exception
        throw new Exception(String.format("AircraftFactory: unknown aircraft %s", type));
    }
}

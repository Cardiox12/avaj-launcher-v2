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

    Flyable newAircraft(String type, String name, Coordinates coordinates) {
        // Generate a random unique ID with a length 5.
        String uuidString = UUID.randomUUID()
            .toString()
            .substring(0, 5);
        long uuid = Long.parseLong(uuidString);

        switch (type) {
            case "BALOON":
                return new Baloon(uuid, name, coordinates);
            case "HELICOPTER":
                return new Helicopter(uuid, name, coordinates);
            case "JETPLANE":
                return new JetPlane(uuid, name, coordinates);
        }
        // TODO: Throw a custom exception
        throw new Exception("Unknown entity");
    }
}

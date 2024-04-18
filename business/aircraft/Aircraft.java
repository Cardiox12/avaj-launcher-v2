package business.aircraft;

import business.Coordinates;
import business.flyable.Flyable;

public class Aircraft extends Flyable {
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    protected Aircraft(long id, String name, Coordinates coordinates) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
    }

    public void updateConditions() throws Exception {}

    public String toString() { 
        return ""; 
    }

    public boolean hasLanded() {
        return this.coordinates.getHeight() == 0;
    }
}

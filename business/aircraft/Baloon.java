package business.aircraft;

import business.Coordinates;

public class Baloon extends Aircraft {
    public Baloon(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    public void updateConditions() {
        String weather = this.weatherTower.getWeather(this.coordinates);

        switch (weather) {
            case "SUN":
                this.coordinates.increaseLongitude(2);
                this.coordinates.increaseHeight(4);
                break;
            case "RAIN":
                this.coordinates.decreaseHeight(5);
                break;
            case "FOG":
                this.coordinates.decreaseHeight(3);
                break;
            case "SNOW":
                this.coordinates.decreaseHeight(15);
                break;
        }
    }
}

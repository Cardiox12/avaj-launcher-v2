package business.aircraft;

import business.Coordinates;

public class Helicopter extends Aircraft {
    public Helicopter(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    public void updateConditions() {
        String weather = this.weatherTower.getWeather(this.coordinates);

        switch (weather) {
            case "SUN":
                this.coordinates.increaseLongitude(10);
                this.coordinates.increaseHeight(2);
                break;
            case "RAIN":
                this.coordinates.increaseLongitude(5);
                break;
            case "FOG":
                this.coordinates.increaseLongitude(1);
                break;
            case "SNOW":
                this.coordinates.decreaseHeight(15);
                break;
        }
    }
}

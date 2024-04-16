package business.aircraft;

import business.Coordinates;

public class JetPlane extends Aircraft {
    public JetPlane(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    public void updateConditions() {
        String weather = this.weatherTower.getWeather(this.coordinates);

        switch (weather) {
            case "SUN":
                this.coordinates.increaseLatitude(10);
                this.coordinates.increaseHeight(2);
                break;
            case "RAIN":
                this.coordinates.increaseLatitude(5);
                break;
            case "FOG":
                this.coordinates.increaseLatitude(1);
                break;
            case "SNOW":
                this.coordinates.increaseHeight(7);
                break;
        }
    }
}

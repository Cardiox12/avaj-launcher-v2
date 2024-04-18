package business.weather;

import business.Coordinates;
import business.flyable.Flyable;
import business.logger.Logger;

public class WeatherUpdaterBuilder {
    private Coordinates coordinates;
    private int increasedHeight;
    private int increasedLatitude;
    private int increasedLongitude;
    Logger logger;
    private String message;

    public WeatherUpdaterBuilder(Flyable flyable, Coordinates coordinates) {
        this.coordinates = coordinates;
        this.increasedHeight = 0;
        this.increasedLatitude = 0;
        this.increasedLongitude = 0;
        this.logger = new Logger(flyable.toString());
        this.message = "";
    }

    public WeatherUpdaterBuilder setMessage(String message) {
        this.message = message;
        return this;
    }

    public WeatherUpdaterBuilder increaseHeight(int n) {
        this.increasedHeight = n;
        return this;
    }

    public WeatherUpdaterBuilder increaseLongitude(int n) {
        this.increasedLongitude = n;
        return this;
    }

    public WeatherUpdaterBuilder increaseLatitude(int n) {
        this.increasedLatitude = n;
        return this;
    }

    public WeatherUpdaterBuilder decreaseHeight(int n) {
        this.increasedHeight = -n;
        return this;
    }

    public WeatherUpdaterBuilder decreaseLongitude(int n) {
        this.increasedLongitude = -n;
        return this;
    }

    public WeatherUpdaterBuilder decreaseLatitude(int n) {
        this.increasedLatitude = -n;
        return this;
    }

    public void update() {
        this.logger.log(this.message);
        this.coordinates.setHeight(this.coordinates.getHeight() + this.increasedHeight);
        this.coordinates.setLatitude(this.coordinates.getLatitude() + increasedLatitude);
        this.coordinates.setLongitude(this.coordinates.getLongitude() + increasedLongitude);
    }
}

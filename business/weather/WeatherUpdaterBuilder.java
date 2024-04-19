package business.weather;

import business.Coordinates;
import business.flyable.Flyable;
import business.logger.AvajLogger;

public class WeatherUpdaterBuilder {
    private Coordinates coordinates;
    private int increasedHeight;
    private int increasedLatitude;
    private int increasedLongitude;
    private AvajLogger logger;
    private String message;
    private Flyable flyable;

    public WeatherUpdaterBuilder(Flyable flyable, Coordinates coordinates) {
        this.coordinates = coordinates;
        this.increasedHeight = 0;
        this.increasedLatitude = 0;
        this.increasedLongitude = 0;
        this.message = "";
        this.flyable = flyable;
        this.logger = new AvajLogger();
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
        String message = String.format("%s %s", this.flyable, this.message);
        AvajLogger.log(message);
        this.coordinates.setHeight(this.coordinates.getHeight() + this.increasedHeight);
        this.coordinates.setLatitude(this.coordinates.getLatitude() + this.increasedLatitude);
        this.coordinates.setLongitude(this.coordinates.getLongitude() + this.increasedLongitude);
    }
}

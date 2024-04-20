package business.weather;
import business.Coordinates;

public class WeatherProvider {
    private String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};
    private static WeatherProvider weatherProvider;

    private WeatherProvider() {}

    public static WeatherProvider getInstance() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int total = coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude();
        return this.weather[total % this.weather.length];
    }
}

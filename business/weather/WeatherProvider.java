package business.weather;

// import java.util.Random;

// import business.Bounds;
import business.Coordinates;

public class WeatherProvider {
    private String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};
    // private String[][][] map;
    private static WeatherProvider weatherProvider;

    private WeatherProvider() {
        // map = new String[Bounds.MAX_HEIGHT][Bounds.MAX_LONGITUDE][Bounds.MAX_LATITUDE];

        // this.changeWeatherConditions();
    }

    public static WeatherProvider getInstance() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int total = coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude();
        return this.weather[total % this.weather.length];
        // return this.map
        //     [coordinates.getHeight()]
        //     [coordinates.getLongitude()]
        //     [coordinates.getLatitude()];
    }

    // private String generateRandomWeather() {
    //     Random r = new Random();

    //     int latRand = r.nextInt(Bounds.MAX_LATITUDE - 1);
    //     int lngRand = r.nextInt(Bounds.MAX_LONGITUDE - 1);
    //     int heightRand = r.nextInt(Bounds.MAX_HEIGHT - 1);

    //     int totalRands = latRand + lngRand + heightRand;

    //     return this.weather[totalRands % weather.length];
    // }

    // public void changeWeatherConditions() {
    //     for (int h = 0 ; h < Bounds.MAX_HEIGHT ; h++) {
    //         for (int y = 0 ; y < Bounds.MAX_LONGITUDE ; y++) {
    //             for (int x = 0 ; x < Bounds.MAX_LATITUDE ; x++) {
    //                 this.map[h][y][x] = generateRandomWeather();
    //             }
    //         }
    //     }
    // }
}

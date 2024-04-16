package business.weather;

import java.util.Random;

import business.Bounds;
import business.Coordinates;

public class WeatherProvider {
    private String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};
    private String[][][] map;
    private static WeatherProvider weatherProvider;

    private WeatherProvider() {
        map = new String[Bounds.MAX_HEIGHT][Bounds.MAX_LONGITUDE][Bounds.MAX_LATITUDE];

        for (int h = 0 ; h < Bounds.MAX_HEIGHT ; h++) {
            for (int y = 0 ; y < Bounds.MAX_LONGITUDE ; y++) {
                for (int x = 0 ; x < Bounds.MAX_LATITUDE ; x++) {
                    map[h][y][x] = generateRandomWeather(new Coordinates(y, x, h));
                }
            }
        }
    }

    public static WeatherProvider getInstance() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return this.map
            [coordinates.getHeight()]
            [coordinates.getLongitude()]
            [coordinates.getLatitude()];
    }

    private String generateRandomWeather(Coordinates coordinates) {
        Random r = new Random();

        int latRand = r.nextInt(coordinates.getLatitude());
        int lngRand = r.nextInt(coordinates.getLongitude());
        int heightRand = r.nextInt(coordinates.getHeight());
        int totalRands = latRand + lngRand + heightRand;

        return this.weather[totalRands % weather.length];
    }
}

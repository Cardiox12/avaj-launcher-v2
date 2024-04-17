package business.aircraft;

import business.Coordinates;
import business.weather.WeatherUpdater;

public class Baloon extends Aircraft {
    public Baloon(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    public void updateConditions() {
        String weather = this.weatherTower.getWeather(this.coordinates);
        WeatherUpdater weatherUpdater = new WeatherUpdater(coordinates);


        weatherUpdater.build("SUN")
            .increaseLongitude(2)
            .increaseHeight(4);
        weatherUpdater.build("RAIN")
            .decreaseHeight(5);
        weatherUpdater.build("FOG")
            .decreaseHeight(3);
        weatherUpdater.build("SNOW")
            .decreaseHeight(15);
        
        weatherUpdater.update(weather);
    }
}

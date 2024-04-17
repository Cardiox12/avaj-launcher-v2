package business.aircraft;

import business.Coordinates;
import business.weather.WeatherUpdater;

public class Helicopter extends Aircraft {
    public Helicopter(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    public void updateConditions() {
        String weather = this.weatherTower.getWeather(this.coordinates);
        WeatherUpdater weatherUpdater = new WeatherUpdater(coordinates);


        weatherUpdater.build("SUN")
            .increaseLongitude(10)
            .increaseHeight(2);
        weatherUpdater.build("RAIN")
            .increaseLongitude(5);
        weatherUpdater.build("FOG")
            .increaseLongitude(1);
        weatherUpdater.build("SNOW")
            .decreaseHeight(15);
        
        weatherUpdater.update(weather);
    }
}

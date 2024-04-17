package business.aircraft;

import business.Coordinates;
import business.weather.WeatherUpdater;

public class JetPlane extends Aircraft {
    public JetPlane(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    public void updateConditions() {
        String weather = this.weatherTower.getWeather(this.coordinates);
        WeatherUpdater weatherUpdater = new WeatherUpdater(coordinates);


        weatherUpdater.build("SUN")
            .increaseLatitude(10)
            .increaseHeight(2);
        weatherUpdater.build("RAIN")
            .increaseLatitude(5);
        weatherUpdater.build("FOG")
            .increaseLatitude(1);
        weatherUpdater.build("SNOW")
            .decreaseHeight(7);
        
        weatherUpdater.update(weather);
    }
}

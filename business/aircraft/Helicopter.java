package business.aircraft;

import business.Coordinates;
import business.weather.WeatherUpdater;

public class Helicopter extends Aircraft {
    public Helicopter(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    public void updateConditions() throws Exception {
        String weather = this.weatherTower.getWeather(this.coordinates);
        WeatherUpdater weatherUpdater = new WeatherUpdater(this, coordinates);


        weatherUpdater.build("SUN")
            .increaseLongitude(10)
            .increaseHeight(2)
            .setMessage("Woow, it's hot");
        weatherUpdater.build("RAIN")
            .increaseLongitude(5)
            .setMessage("Rain man, woop woop!");
        weatherUpdater.build("FOG")
            .increaseLongitude(1)
            .setMessage("I don't see anything");
        weatherUpdater.build("SNOW")
            .decreaseHeight(15)
            .setMessage("My turbine is freezing");
        
        weatherUpdater.update(weather);
    }

    public String toString() {
        return String.format("Helicopter#%s(%d)", this.name, this.id);
    }
}

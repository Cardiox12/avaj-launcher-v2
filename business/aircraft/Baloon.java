package business.aircraft;

import business.Coordinates;
import business.weather.WeatherUpdater;

public class Baloon extends Aircraft {
    public Baloon(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    public void updateConditions() throws Exception {
        String weather = this.weatherTower.getWeather(this.coordinates);
        WeatherUpdater weatherUpdater = new WeatherUpdater(this, coordinates);


        weatherUpdater.build("SUN")
            .increaseLongitude(2)
            .increaseHeight(4)
            .setMessage("The hot air is going to make us fly high");
        weatherUpdater.build("RAIN")
            .decreaseHeight(5)
            .setMessage("This baloon can't fly on rainy day, but let's go");
        weatherUpdater.build("FOG")
            .decreaseHeight(3)
            .setMessage("We don't see anything with this shitty baloon");
        weatherUpdater.build("SNOW")
            .decreaseHeight(15)
            .setMessage("Snow ? Nah, it ain't gonna stop us from flying this f.king baloon");
        
        weatherUpdater.update(weather);
    }

    public String toString() {
        return String.format("Baloon#%s(%d)", this.name, this.id);
    }
}

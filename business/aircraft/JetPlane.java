package business.aircraft;

import business.Coordinates;
import business.weather.WeatherUpdater;

public class JetPlane extends Aircraft {
    public JetPlane(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
    }

    public void updateConditions() throws Exception {
        String weather = this.weatherTower.getWeather(this.coordinates);
        WeatherUpdater weatherUpdater = new WeatherUpdater(this, coordinates);

        weatherUpdater.build("SUN")
            .increaseLatitude(10)
            .increaseHeight(2)
            .setMessage("Good day to fly this jet plane, VFR today!");
        weatherUpdater.build("RAIN")
            .increaseLatitude(5)
            .setMessage("Rainy day, but IFR is the way");
        weatherUpdater.build("FOG")
            .increaseLatitude(1)
            .setMessage("This rain ain't gonna stop my jetplane");
        weatherUpdater.build("SNOW")
            .decreaseHeight(7)
            .setMessage("Courchevelle on my way");
        
        weatherUpdater.update(weather);
    }

    public String toString() {
        return String.format("JetPlane#%s(%d)", this.name, this.id);
    }
}

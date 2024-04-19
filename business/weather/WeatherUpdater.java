package business.weather;

import business.Coordinates;
import business.flyable.Flyable;

public class WeatherUpdater {
    private WeatherUpdaterBuilder sun;
    private WeatherUpdaterBuilder rain;
    private WeatherUpdaterBuilder fog;
    private WeatherUpdaterBuilder snow;

    public WeatherUpdater(Flyable flyable, Coordinates coordinates) throws Exception {
        this.sun = new WeatherUpdaterBuilder(flyable, coordinates);
        this.rain = new WeatherUpdaterBuilder(flyable, coordinates);
        this.fog = new WeatherUpdaterBuilder(flyable, coordinates);
        this.snow = new WeatherUpdaterBuilder(flyable, coordinates);
    }

    public WeatherUpdaterBuilder build(String weather) throws Exception {
        switch (weather) {
            case "SUN": return this.sun;
            case "RAIN": return this.rain;
            case "FOG": return this.fog;
            case "SNOW": return this.snow;
        }
        throw new Exception(String.format("WeatherUpdater: unknown weather %s", weather));
    }

    public void update(String weather) throws Exception {
        switch (weather) {
            case "SUN":
                this.sun.update();
                break;
            case "RAIN":
                this.rain.update();
                break;
            case "FOG":
                this.fog.update();
                break;
            case "SNOW":
                this.snow.update();
                break;
            default:
                throw new Exception(String.format("WeatherUpdater: unknown weather %s", weather));
        }
    }
}

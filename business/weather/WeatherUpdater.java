package business.weather;

import business.Coordinates;

public class WeatherUpdater {
    private WeatherUpdaterBuilder sun;
    private WeatherUpdaterBuilder rain;
    private WeatherUpdaterBuilder fog;
    private WeatherUpdaterBuilder snow;

    public WeatherUpdater(Coordinates coordinates) {
        this.sun = new WeatherUpdaterBuilder(coordinates);
        this.rain = new WeatherUpdaterBuilder(coordinates);
        this.fog = new WeatherUpdaterBuilder(coordinates);
        this.snow = new WeatherUpdaterBuilder(coordinates);
    }

    public WeatherUpdaterBuilder build(String weather) {
        switch (weather) {
            case "SUN": return this.sun;
            case "RAIN": return this.rain;
            case "FOG": return this.fog;
            case "SNOW": return this.snow;
        }
        throw new Exception(String.format("WeatherUpdater: unknown weather %s", weather));
    }

    public void update(String weather) {
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
        }
        throw new Exception(String.format("WeatherUpdater: unknown weather %s", weather));
    }
}

package business.tower;

import business.Coordinates;
import business.flyable.Flyable;
import business.logger.Logger;
import business.weather.WeatherProvider;

public class WeatherTower extends Tower {
    private Logger logger;

    public WeatherTower() {
        super();
        this.logger = new Logger("Tower says");
    }

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getInstance().getCurrentWeather(coordinates);
    }

    public void changeWeather() throws Exception {
        WeatherProvider.getInstance().changeWeatherConditions();
        super.conditionsChanged();
        this.landFlyables();
    }

    public void register(Flyable flyable) {
        super.register(flyable);
        flyable.registerTower(this);
        logger.log(String.format("%s registered to weather tower", flyable));
    }

    public void unregister(Flyable flyable) {
        super.unregister(flyable);
        logger.log(String.format("%s unregistered from weather tower", flyable));
    }

    private void landFlyables() {
        for (Flyable flyable : this.landings) {
            this.unregister(flyable);
        }
        this.landings.clear();
    }
}

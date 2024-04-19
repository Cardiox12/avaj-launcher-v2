package business.tower;

import business.Coordinates;
import business.flyable.Flyable;
import business.logger.AvajLogger;
import business.weather.WeatherProvider;

public class WeatherTower extends Tower {
    private AvajLogger logger;

    public WeatherTower() {
        super();
        this.logger = new AvajLogger();
    }

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getInstance().getCurrentWeather(coordinates);
    }

    public void changeWeather() throws Exception {
        super.conditionsChanged();
        this.landFlyables();
    }

    public void register(Flyable flyable) {
        super.register(flyable);
        flyable.registerTower(this);
        this.logger.log(String.format("Tower says: %s registered to weather tower", flyable));
    }

    public void unregister(Flyable flyable) {
        super.unregister(flyable);
        this.logger.log(String.format("Tower says: %s unregistered from weather tower", flyable));
    }

    private void landFlyables() {
        for (Flyable flyable : this.landings) {
            this.unregister(flyable);
        }
        this.landings.clear();
    }
}

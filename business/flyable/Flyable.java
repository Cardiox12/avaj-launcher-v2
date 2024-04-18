package business.flyable;

import business.tower.WeatherTower;

public abstract class Flyable {
    protected WeatherTower weatherTower;
    
    public abstract void updateConditions() throws Exception;
    
    public void registerTower(WeatherTower tower) {
        this.weatherTower = tower;
    }

    public abstract boolean hasLanded();
}

import business.Coordinates;
import business.aircraft.AircraftFactory;
import business.flyable.Flyable;
import business.tower.WeatherTower;

public class AvajLauncher {
  public static void main(String[] args) throws Exception {
    WeatherTower weatherTower = new WeatherTower();
    AircraftFactory aircraftFactory = AircraftFactory.getInstance();


    Flyable b1 = aircraftFactory.newAircraft("BALOON",  "B1", Coordinates.random());
    Flyable b2 = aircraftFactory.newAircraft("BALOON",  "B2", Coordinates.random());
    Flyable j1 = aircraftFactory.newAircraft("JETPLANE",  "J1", Coordinates.random());

    weatherTower.register(b1);
    weatherTower.register(b2);
    weatherTower.register(j1);

    for (int i = 0 ; i < 20 ; i++) {
      weatherTower.changeWeather();
      System.out.println("============================");
    }
  }
}

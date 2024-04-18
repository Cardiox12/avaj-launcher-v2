package business.scenario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import business.Coordinates;
import business.aircraft.AircraftFactory;
import business.flyable.Flyable;
import business.tower.WeatherTower;

public class ScenarioInterpreter {
    private String filename;
    private int iterations;
    private List<ScenarioLine> lines;

    static class ScenarioLine {
        public String type;
        public String name;
        public Coordinates coordinates;
        static private Pattern lineRegex = Pattern.compile("^(?<type>Baloon|JetPlane|Helicopter)\\s*(?<name>\\w*)\\s*(?<longitude>\\d*)\\s*(?<latitude>\\d*)\\s*(?<height>\\d*)$");

        ScenarioLine(String type, String name, Coordinates coordinates) {
            this.type = type;
            this.name = name;
            this.coordinates = coordinates;
        }

        public static ScenarioLine parseLine(String line) throws Exception {
            Matcher matcher = lineRegex.matcher(line);
            if (!matcher.find()) {
                throw new Exception("ScenarioLine: invalid line");
            }
            String name = matcher.group("name");
            String type = matcher.group("type").toUpperCase();
            int longitude = Integer.parseInt(matcher.group("longitude"));
            int latitude = Integer.parseInt(matcher.group("latitude"));
            int height = Integer.parseInt(matcher.group("height"));

            return new ScenarioLine(type, name, new Coordinates(longitude, latitude, height));
        }
    }

    public ScenarioInterpreter(String filename) {
        this.filename = filename;
        this.iterations = 0;
        this.lines = new LinkedList<>();
    }

    public void read() throws Exception {
        BufferedReader reader;

        reader = new BufferedReader(new FileReader(this.filename));
        String line;

        // Parse iterations
        line = reader.readLine();
        if (line == null) {
            reader.close();
            throw new Exception("ScenarioInterpreter: invalid scenario file: empty file");
        }

        this.iterations = Integer.parseInt(line);

        while ((line = reader.readLine()) != null) {
            this.lines.add(ScenarioLine.parseLine(line));
        }
        reader.close();
    }

    public void execute() throws Exception {
        WeatherTower weatherTower = new WeatherTower();
        AircraftFactory aircraftFactory = AircraftFactory.getInstance();

        for (ScenarioLine sl : this.lines) {
            Flyable flyable = aircraftFactory.newAircraft(sl.type, sl.name, sl.coordinates);

            weatherTower.register(flyable);
        }

        for (int i = 0 ; i < this.iterations ; i++) {
            weatherTower.changeWeather();
        }
    }
}

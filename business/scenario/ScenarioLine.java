package business.scenario;

import business.Coordinates;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScenarioLine {
    public String type;
    public String name;
    public Coordinates coordinates;

    private ScenarioLine(String type, String name, Coordinates coordinates) {
      this.type = type;
      this.name = name;
      this.coordinates = coordinates;
    }

    public static ScenarioLine parseLine(String line) throws Exception {
      Pattern lineRegex = Pattern.compile("^(?<type>Baloon|JetPlane|Helicopter)\\s*(?<name>\\w*)\\s*(?<longitude>\\d*)\\s*(?<latitude>\\d*)\\s*(?<height>\\d*)$");
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

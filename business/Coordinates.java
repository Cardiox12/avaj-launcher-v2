package business;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    // TODO: Redo following the rules
    public void increaseHeight(int n) {
        if (this.height + n > Bounds.MAX_HEIGHT) {
            throw new Exception(String.format("cannot increase height above %d", Bounds.MAX_HEIGHT));
        }
        this.height += n;
    }

    public void increaseLatitude(int n) {
        if (this.latitude + n > Bounds.MAX_LATITUDE) {
            throw new Exception(String.format("cannot increase latitude above %d", Bounds.MAX_LATITUDE));
        }
        this.latitude += n;
    }

    public void increaseLongitude(int n) {
        if (this.longitude + n > Bounds.MAX_LONGITUDE) {
            throw new Exception(String.format("cannot increase longitude above %d", Bounds.MAX_LONGITUDE));
        }
        this.longitude += n;
    }

    public void decreaseHeight(int n) {
        if (this.height - n < 0) {
            throw new Exception("cannot decrease height below 0");
        }
        this.height -= n;
    }

    public void decreaseLatitude(int n) {
        if (this.latitude - n < 0) {
            throw new Exception("cannot decrease latitude below 0");
        }
        this.latitude -= n;
    }

    public void decreaseLongitude(int n) {
        if (this.longitude - n < 0) {
            throw new Exception("cannot decrease longitude below 0");
        }
        this.longitude -= n;
    }
}

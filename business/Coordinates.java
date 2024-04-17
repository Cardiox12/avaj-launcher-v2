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


    public void setLongitude(int longitude) {
        if (longitude < 0) {
            this.longitude = 0;
        } else if (longitude > Bounds.MAX_LONGITUDE) {
            this.longitude = Bounds.MAX_LONGITUDE;
        } else {
            this.longitude = longitude;
        }
    }

    public void setLatitude(int latitude) {
        if (latitude < 0) {
            this.latitude = 0;
        } else if (latitude > Bounds.MAX_LATITUDE) {
            this.latitude = Bounds.MAX_LATITUDE;
        } else {
            this.latitude = latitude;
        }
    }

    public void setHeight(int height) {
        if (height < 0) {
            this.height = 0;
        } else if (height > Bounds.MAX_HEIGHT) {
            this.height = Bounds.MAX_HEIGHT;
        } else {
            this.height = height;
        }
    }
}

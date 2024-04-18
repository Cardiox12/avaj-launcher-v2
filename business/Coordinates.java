package business;

import java.util.Random;

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
        } else if (longitude >= Bounds.MAX_LONGITUDE) {
            this.longitude = Bounds.MAX_LONGITUDE - 1;
        } else {
            this.longitude = longitude;
        }
    }

    public void setLatitude(int latitude) {
        if (latitude < 0) {
            this.latitude = 0;
        } else if (latitude >= Bounds.MAX_LATITUDE) {
            this.latitude = Bounds.MAX_LATITUDE - 1;
        } else {
            this.latitude = latitude;
        }
    }

    public void setHeight(int height) {
        if (height < 0) {
            this.height = 0;
        } else if (height >= Bounds.MAX_HEIGHT) {
            this.height = Bounds.MAX_HEIGHT - 1;
        } else {
            this.height = height;
        }
    }

    public String toString() {
        return String.format("(lat=%d, lng=%d, height=%d)", this.latitude, this.longitude, this.height);
    }

    public static Coordinates random() {
        Random r = new Random();

        int latRand = r.nextInt(Bounds.MAX_LATITUDE - 1);
        int lngRand = r.nextInt(Bounds.MAX_LONGITUDE - 1);
        int heightRand = r.nextInt(Bounds.MAX_HEIGHT - 1);

        return new Coordinates(lngRand, latRand, heightRand);
    }
}

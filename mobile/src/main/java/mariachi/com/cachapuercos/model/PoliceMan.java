package mariachi.com.cachapuercos.model;

import java.io.Serializable;

/**
 * Created by ederpadilla on 29/01/17.
 */

public class PoliceMan implements Serializable{

    private String name;
    private double latitude;
    private double longitude;
    private String imageUrl;
    private float rate;
    private String description;

    public PoliceMan() {
    }

    public PoliceMan(String name, double latitude, double longitude, String imageUrl, float rate,
        String description) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.imageUrl = imageUrl;
        this.rate = rate;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "PoliceMan{" +
                "name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", rate=" + rate +
                ", description=" + description +
                '}';
    }
}

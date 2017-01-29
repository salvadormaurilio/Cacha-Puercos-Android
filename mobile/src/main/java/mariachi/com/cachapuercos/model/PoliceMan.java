package mariachi.com.cachapuercos.model;

import java.io.Serializable;

/**
 * Created by ederpadilla on 29/01/17.
 */

public class PoliceMan implements Serializable{
    private String name;
    private String imageUrl;
    private float rate;
    private String description;

    public PoliceMan() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public PoliceMan(String name, String imageUrl, float rate, String description) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.rate = rate;
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

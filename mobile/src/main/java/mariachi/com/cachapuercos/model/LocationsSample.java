package mariachi.com.cachapuercos.model;

/**
 * Created by ederpadilla on 05/11/16.
 */

public class LocationsSample {
    private float longitude;
    private float latitud;
    private String locationAddress;
    private String locationTitle;
    private String locationImgUrl;

    public LocationsSample() {
    }

    public LocationsSample(float longitude, float latitud, String locationTitle, String locationAddress, String locationImgUrl) {
        this.longitude = longitude;
        this.latitud = latitud;
        this.locationTitle=locationTitle;
        this.locationAddress = locationAddress;
        this.locationImgUrl = locationImgUrl;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public String getLocationTitle() {
        return locationTitle;
    }

    public void setLocationTitle(String locationTitle) {
        this.locationTitle = locationTitle;
    }

    public String getLocationImgUrl() {
        return locationImgUrl;
    }

    public void setLocationImgUrl(String locationImgUrl) {
        this.locationImgUrl = locationImgUrl;
    }
}

package weather.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherEntity {

    @SerializedName("location")
    private LocationEntity location;

    @SerializedName("title")
    private String title;

    @SerializedName("link")
    private String link;

    @SerializedName("publicTime")
    private String publicTime;

    @SerializedName("description")
    private DescriptionEntity description;

    @SerializedName("forecasts")
    private List<ForecastEntity> forecasts;

    @SerializedName("pinpointLocations")
    private List<LinkEntity> pinpointLocations;

    @SerializedName("copyright")
    private CopyrightEntity copyright;

    public LocationEntity getLocation() {
        return location;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getPublicTime() {
        return publicTime;
    }

    public DescriptionEntity getDescription() {
        return description;
    }

    public List<ForecastEntity> getForecasts() {
        return forecasts;
    }

    public List<LinkEntity> getPinpointLocations() {
        return pinpointLocations;
    }

    public CopyrightEntity getCopyright() {
        return copyright;
    }

    @Override
    public String toString() {
        return "WeatherEntity{" +
                "location=" + location +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", publicTime='" + publicTime + '\'' +
                ", description=" + description +
                ", forecasts=" + forecasts +
                ", pinpointLocations=" + pinpointLocations +
                ", copyright=" + copyright +
                '}';
    }
}

package webapi.entity;

import com.google.gson.annotations.SerializedName;

/**
 * 府県天気予報
 */
public class ForecastEntity {

    @SerializedName("date")
    private String date;

    @SerializedName("dateLabel")
    private String dateLabel;

    @SerializedName("telop")
    private String telop;

    @SerializedName("image")
    private ImageEntity image;

    @SerializedName("temperature")
    private TemperatureEntity temperature;

    public String getDate() {
        return date;
    }

    public String getDateLabel() {
        return dateLabel;
    }

    public String getTelop() {
        return telop;
    }

    public ImageEntity getImage() {
        return image;
    }

    public TemperatureEntity getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "ForecastEntity{" +
                "date='" + date + '\'' +
                ", dateLabel='" + dateLabel + '\'' +
                ", telop='" + telop + '\'' +
                ", image=" + image +
                ", temperature=" + temperature +
                '}' + "\n";
    }
}

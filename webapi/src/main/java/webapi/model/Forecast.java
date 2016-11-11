package webapi.model;

import util.StringUtil;
import webapi.entity.ForecastEntity;
import webapi.entity.ImageEntity;
import webapi.entity.TemperatureEntity;
import webapi.entity.TemperatureItemEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Forecast {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private Date date;

    private String dateLabel;

    private String telop;

    private String imageUrl;

    private String imageWidth;

    private String imageHeight;

    private float maxCelsius;

    private float minCelsius;

    private float maxFahrenheit;

    private float minFahrenheit;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDateLabel() {
        return dateLabel;
    }

    public void setDateLabel(String dateLabel) {
        this.dateLabel = dateLabel;
    }

    public String getTelop() {
        return telop;
    }

    public void setTelop(String telop) {
        this.telop = telop;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(String imageWidth) {
        this.imageWidth = imageWidth;
    }

    public String getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(String imageHeight) {
        this.imageHeight = imageHeight;
    }

    public float getMaxCelsius() {
        return maxCelsius;
    }

    public void setMaxCelsius(float maxCelsius) {
        this.maxCelsius = maxCelsius;
    }

    public float getMinCelsius() {
        return minCelsius;
    }

    public void setMinCelsius(float minCelsius) {
        this.minCelsius = minCelsius;
    }

    public float getMaxFahrenheit() {
        return maxFahrenheit;
    }

    public void setMaxFahrenheit(float maxFahrenheit) {
        this.maxFahrenheit = maxFahrenheit;
    }

    public float getMinFahrenheit() {
        return minFahrenheit;
    }

    public void setMinFahrenheit(float minFahrenheit) {
        this.minFahrenheit = minFahrenheit;
    }

    public static Forecast entityToModel(ForecastEntity entity) {
        Forecast forecast = new Forecast();

        String dateText = entity.getDate();
        if (dateText != null && !dateText.isEmpty()) {
            try {
                forecast.setDate(sdf.parse(dateText));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        forecast.setDateLabel(StringUtil.setText(entity.getDateLabel()));

        forecast.setTelop(StringUtil.setText(entity.getTelop()));

        ImageEntity image = entity.getImage();
        if (image != null) {
            forecast.setImageUrl(StringUtil.setText(image.getUrl()));
            forecast.setImageWidth(StringUtil.setText(image.getWidth()));
            forecast.setImageHeight(StringUtil.setText(image.getHeight()));
        }

        TemperatureEntity temperatureEntity = entity.getTemperature();
        if (temperatureEntity != null) {

            TemperatureItemEntity maxEntity = temperatureEntity.getMax();
            if (maxEntity != null) {
                forecast.setMaxCelsius(maxEntity.getCelsius());
                forecast.setMaxFahrenheit(maxEntity.getFahrenheit());
            }

            TemperatureItemEntity minEntity = temperatureEntity.getMin();
            if (minEntity != null) {
                forecast.setMinCelsius(minEntity.getCelsius());
                forecast.setMinFahrenheit(minEntity.getFahrenheit());
            }
        }

        return forecast;
    }

    public static List<Forecast> entityToModel(List<ForecastEntity> entityList) {
        return entityList.stream().map(Forecast::entityToModel).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "date=" + date + '\'' +
                ", dateLabel='" + dateLabel + '\'' +
                ", telop='" + telop + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", imageWidth='" + imageWidth + '\'' +
                ", imageHeight='" + imageHeight + '\'' +
                ", maxCelsius=" + maxCelsius +
                ", minCelsius=" + minCelsius +
                ", maxFahrenheit=" + maxFahrenheit +
                ", minFahrenheit=" + minFahrenheit +
                '}';
    }
}

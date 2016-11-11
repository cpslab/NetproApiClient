package webapi.model;

import util.StringUtil;
import webapi.entity.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Weather {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

    private String title;

    private String link;

    private String area;

    private String pref;

    private String city;

    private Date publicTime;

    private String description;

    private List<Forecast> forecastList;

    private List<PinpointLocation> pinpointLocationList;

    private String providerName;

    private String providerUrl;

    private String copyrightName;

    private String copyrightUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPref() {
        return pref;
    }

    public void setPref(String pref) {
        this.pref = pref;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getPublicTime() {
        return publicTime;
    }

    public void setPublicTime(Date publicTime) {
        this.publicTime = publicTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Forecast> getForecastList() {
        return forecastList;
    }

    public void setForecastList(List<Forecast> forecastList) {
        this.forecastList = forecastList;
    }

    public List<PinpointLocation> getPinpointLocationList() {
        return pinpointLocationList;
    }

    public void setPinpointLocationList(List<PinpointLocation> pinpointLocationList) {
        this.pinpointLocationList = pinpointLocationList;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderUrl() {
        return providerUrl;
    }

    public void setProviderUrl(String providerUrl) {
        this.providerUrl = providerUrl;
    }

    public String getCopyrightName() {
        return copyrightName;
    }

    public void setCopyrightName(String copyrightName) {
        this.copyrightName = copyrightName;
    }

    public String getCopyrightUrl() {
        return copyrightUrl;
    }

    public void setCopyrightUrl(String copyrightUrl) {
        this.copyrightUrl = copyrightUrl;
    }

    public static Weather entityToModel(WeatherEntity entity) {
        Weather weather = new Weather();

        weather.setTitle(StringUtil.setText(entity.getTitle()));

        weather.setLink(StringUtil.setText(entity.getLink()));

        LocationEntity location = entity.getLocation();
        if (location != null) {
            weather.setArea(StringUtil.setText(location.getArea()));
            weather.setPref(StringUtil.setText(location.getPref()));
            weather.setCity(StringUtil.setText(location.getCity()));
        }

        String dateText = entity.getPublicTime();
        if (dateText != null && !dateText.isEmpty()) {
            try {
                weather.setPublicTime(sdf.parse(dateText));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        DescriptionEntity description = entity.getDescription();
        if (description != null) {
            weather.setDescription(StringUtil.setText(description.getText()));
        }

        List<ForecastEntity> forecastEntityList = entity.getForecasts();
        if (forecastEntityList != null && !forecastEntityList.isEmpty()) {
            weather.setForecastList(Forecast.entityToModel(forecastEntityList));
        }

        List<LinkEntity> pinpointLocationEntityList = entity.getPinpointLocations();
        if (pinpointLocationEntityList != null && !pinpointLocationEntityList.isEmpty()) {
            weather.setPinpointLocationList(PinpointLocation.entityToModel(pinpointLocationEntityList));
        }

        CopyrightEntity copyright = entity.getCopyright();
        if (copyright != null) {

            List<LinkEntity> providerList = copyright.getProvider();
            if (providerList != null && !providerList.isEmpty()) {
                LinkEntity provider = providerList.get(0);

                weather.setProviderName(StringUtil.setText(provider.getName()));
                weather.setProviderUrl(StringUtil.setText(provider.getLink()));
            }

            weather.setCopyrightName(StringUtil.setText(copyright.getTitle()));
            weather.setCopyrightUrl(StringUtil.setText(copyright.getLink()));
        }

        return weather;
    }

    public static List<Weather> entityToModel(List<WeatherEntity> entityList) {
        return entityList.stream().map(Weather::entityToModel).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Weather{" + "\n" +
                "title='" + title + "\n" +
                ", link='" + link + "\n" +
                ", area='" + area + "\n" +
                ", pref='" + pref + "\n" +
                ", city='" + city + "\n" +
                ", publicTime=" + publicTime + "\n" +
                ", description='" + description + "\n" +
                ", forecastList=" + forecastList + "\n" +
                ", pinpointLocationList=" + pinpointLocationList + "\n" +
                ", providerName='" + providerName + "\n" +
                ", providerUrl='" + providerUrl + "\n" +
                ", copyrightName='" + copyrightName + "\n" +
                ", copyrightUrl='" + copyrightUrl + "\n" +
                '}';
    }
}

package entity;

import com.google.gson.annotations.SerializedName;

public class LocationEntity {

    @SerializedName("area")
    private String area;

    @SerializedName("pref")
    private String pref;

    @SerializedName("city")
    private String city;

    public String getArea() {
        return area;
    }

    public String getPref() {
        return pref;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "LocationEntity{" +
                "area='" + area + '\'' +
                ", pref='" + pref + '\'' +
                ", city='" + city + '\'' +
                '}' + "\n";
    }
}

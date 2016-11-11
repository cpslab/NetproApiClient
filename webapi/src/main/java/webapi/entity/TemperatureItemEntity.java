package webapi.entity;

import com.google.gson.annotations.SerializedName;

public class TemperatureItemEntity {

    @SerializedName("celsius")
    private float celsius;

    @SerializedName("fahrenheit")
    private float fahrenheit;

    public float getCelsius() {
        return celsius;
    }

    public float getFahrenheit() {
        return fahrenheit;
    }

    @Override
    public String toString() {
        return "TemperatureItemEntity{" +
                "celsius=" + celsius +
                ", fahrenheit=" + fahrenheit +
                '}' + "\n";
    }
}

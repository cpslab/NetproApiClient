package webapi.entity;

import com.google.gson.annotations.SerializedName;

public class TemperatureEntity {

    @SerializedName("max")
    private TemperatureItemEntity max;

    @SerializedName("min")
    private TemperatureItemEntity min;

    public TemperatureItemEntity getMax() {
        return max;
    }

    public TemperatureItemEntity getMin() {
        return min;
    }

    @Override
    public String toString() {
        return "TemperatureEntity{" +
                "max=" + max +
                ", min=" + min +
                '}' + "\n";
    }
}

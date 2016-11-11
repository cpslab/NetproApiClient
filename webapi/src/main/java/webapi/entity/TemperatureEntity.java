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
}

package corona.entity;

import com.google.gson.annotations.SerializedName;

import java.util.*;

public class CovidEntity {

    @SerializedName("area")
    public List<AreaEntity> areas;

    @Override
    public String toString() {
        return "TemperatureItemEntity: areas[" + areas.size() + "]" + "\n";
    }
}

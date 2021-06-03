package corona.entity;

import com.google.gson.annotations.SerializedName;

//      {
//              "name_jp": "北海道",
//              },

public class AreaEntity {

    @SerializedName("name_jp")
    private String nameJp;

    @Override
    public String toString() {
        return "AreaEntity: name= " + nameJp;
    }
}

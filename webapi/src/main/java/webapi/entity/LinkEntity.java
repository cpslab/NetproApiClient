package webapi.entity;

import com.google.gson.annotations.SerializedName;

public class LinkEntity {

    @SerializedName("link")
    private String link;

    @SerializedName("name")
    private String name;

    public String getLink() {
        return link;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "LinkEntity{" +
                "link='" + link + '\'' +
                ", name='" + name + '\'' +
                '}' + "\n";
    }
}

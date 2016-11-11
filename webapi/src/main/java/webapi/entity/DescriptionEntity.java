package webapi.entity;

import com.google.gson.annotations.SerializedName;

public class DescriptionEntity {

    @SerializedName("text")
    private String text;

    @SerializedName("publicTime")
    private String publicTime;

    public String getText() {
        return text;
    }

    public String getPublicTime() {
        return publicTime;
    }

    @Override
    public String toString() {
        return "DescriptionEntity{" +
                "text='" + text + '\'' +
                ", publicTime='" + publicTime + '\'' +
                '}' + "\n";
    }
}

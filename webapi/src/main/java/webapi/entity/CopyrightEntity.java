package webapi.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CopyrightEntity {

    @SerializedName("title")
    private String title;

    @SerializedName("link")
    private String link;

    @SerializedName("image")
    private ImageEntity image;

    @SerializedName("provider")
    private List<LinkEntity> provider;

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public ImageEntity getImage() {
        return image;
    }

    public List<LinkEntity> getProvider() {
        return provider;
    }
}

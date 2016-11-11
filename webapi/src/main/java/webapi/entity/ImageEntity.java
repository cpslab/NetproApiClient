package webapi.entity;

import com.google.gson.annotations.SerializedName;

/**
 * 天気アイコン画像
 */
public class ImageEntity {

    @SerializedName("title")
    private String title;

    @SerializedName("link")
    private String link;

    @SerializedName("url")
    private String url;

    @SerializedName("width")
    private String width;

    @SerializedName("height")
    private String height;

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getUrl() {
        return url;
    }

    public String getWidth() {
        return width;
    }

    public String getHeight() {
        return height;
    }
}

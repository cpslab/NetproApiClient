package webapi.model;

import util.StringUtil;
import webapi.entity.LinkEntity;

import java.util.List;
import java.util.stream.Collectors;

public class PinpointLocation {

    private String name;

    private String link;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public static PinpointLocation entityToModel(LinkEntity entity) {
        PinpointLocation location = new PinpointLocation();

        location.setName(StringUtil.setText(entity.getName()));

        location.setLink(StringUtil.setText(entity.getLink()));

        return location;
    }

    public static List<PinpointLocation> entityToModel(List<LinkEntity> entityList) {
        return entityList.stream().map(PinpointLocation::entityToModel).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "PinpointLocation{" + '\'' +
                "name='" + name + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}

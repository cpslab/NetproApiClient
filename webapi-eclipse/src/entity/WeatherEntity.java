package entity;

import java.util.List;

import com.google.gson.Gson;

public class WeatherEntity {
	public LocationEntity location;
	public String title;
	public String link;
	public String publicTime;
	public List<ForecastEntity> forecasts;

	@Override
	public String toString() {
		return "WeatherEntity{" + "\n" +
				"location=" + location + "\n" +
				", title='" + title + '\'' + "\n" +
				", link='" + link + '\'' + "\n" +
				", publicTime='" + publicTime + '\'' + "\n" +
				", forecasts=" + forecasts + "\n" +
				'}';
	}
}

package entity;

import java.util.List;

import com.google.gson.Gson;

public class WeatherEntity {
	public LocationEntity location;
	public String title;
	public String link;
	public String publicTime;
	public List<ForecastEntity> forecastList;
	
	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}

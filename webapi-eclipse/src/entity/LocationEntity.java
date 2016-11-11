package entity;

public class LocationEntity {
	public String area;
	public String pref;
	public String city;

	@Override
	public String toString() {
		return "LocationEntity{" +
				"area='" + area + '\'' +
				", pref='" + pref + '\'' +
				", city='" + city + '\'' +
				'}';
	}
}

package entity;

public class ForecastEntity {
	public String date;
	public String dateLabel;
	public String telop;

	@Override
	public String toString() {
		return "ForecastEntity{" +
				"date='" + date + '\'' +
				", dateLabel='" + dateLabel + '\'' +
				", telop='" + telop + '\''+
				'}' + "\n";
	}
}

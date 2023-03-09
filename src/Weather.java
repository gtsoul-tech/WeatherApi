import java.io.Serializable;

public class Weather implements Serializable {
	private static final long serialVersionUID = 1L;
	private String city;
	private String temperature;
	private String description;
	private String countrycode;
	private String iconsrc;
	private String tempmin;
	private String tempmax;
	private String humidity;
	public Weather(String city,
	 String temperature,String description,String countrycode,String iconsrc,String tempmin,String tempmax,String humidity) {
		this.city=city;
		this.temperature= temperature;
		this.description=description;
		this.countrycode=countrycode;
		this.iconsrc=iconsrc;
		this.tempmin=tempmin;
		this.tempmax=tempmax;
		this.humidity=humidity;
	}
	public Weather() {
		city="-";
		temperature="-";
		description="- -";
		countrycode="-";
		iconsrc="icons/unknown.png";
		tempmin="-";
		tempmax="-";
		humidity="-";
	}
	public void setTemperature(String temp) {
		this.temperature=temp;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setCity(String city) {
		this.city=city;
	}
	public String getCity() {
		return city;
	}
	public void setDescription(String description) {
		this.description=description;
	}
	public String getDescription() {
		return description;
	}
	public void setCountrycode(String countrycode) {
		this.countrycode=countrycode;
	}
	public String getCountrycode() {
		return countrycode;
	}
	public void setIconsrc(String iconsrc) {
		this.iconsrc=iconsrc;
	}
	public String getIconsrc() {
		return iconsrc;
	}

	public void setHumidity(String humidity) {
		this.humidity=humidity;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setTempmin(String tempmin) {
		this.tempmin=tempmin;
	}
	public String getTempmin() {
		return tempmin;
	}
	public void setTempmax(String tempmax) {
		this.tempmax=tempmax;
	}
	public String getTempmax() {
		return tempmax;
	}
	
}

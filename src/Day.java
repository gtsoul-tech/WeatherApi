import java.io.Serializable;
public class Day implements Serializable{
	private static final long serialVersionUID = 1L;
	private String date;
	private String realday;
	private String tempmax;
	private String tempmin;
	private String iconsrc8;
	private String iconsrc14;
	private String iconsrc20;
	private String temp8;
	private String temp14;
	private String temp20;
	public Day() {
		date="";
		realday="";

		tempmax="";
		tempmin="";
		iconsrc8="icons/unknown.png";
		iconsrc14="icons/unknown.png";
		iconsrc20="icons/unknown.png";
		temp8="";
		temp14="";
		temp20="";
	}
	public Day(String date,String realday,String tempmax,String tempmin,String iconsrc8,String iconsrc14,String iconsrc20,String temp8,String temp14,String temp20) {
		this.date=date;
		this.realday=realday;
		this.tempmax=tempmax;
		this.tempmin=tempmin;
		this.iconsrc8=iconsrc8;
		this.iconsrc14=iconsrc14;
		this.iconsrc20=iconsrc20;
		this.temp8=temp8;
		this.temp14=temp14;
		this.temp20=temp20;
	}
	public Day(Day newDay) {
		this.date=newDay.date;
		this.realday=newDay.realday;
		this.tempmax=newDay.tempmax;
		this.tempmin=newDay.tempmin;
		this.iconsrc8=newDay.iconsrc8;
		this.iconsrc14=newDay.iconsrc14;
		this.iconsrc20=newDay.iconsrc20;
		this.temp8=newDay.temp8;
		this.temp14=newDay.temp14;
		this.temp20=newDay.temp20;
	}
	public void setRealday(String realday) {
		this.realday=realday;
	}
	public String getRealday() {
		return this.realday;
	}
	public void setDate(String date) {
		this.date=date;
	}
	public String getDate() {
		return this.date;
	}
	public void setTempmin(String tempmin) {
		this.tempmin=tempmin;
	}
	public String getTempmin() {
		return this.tempmin;
	}
	public void setTempmax(String tempmax) {
		this.tempmax=tempmax;
	}
	public String getTempmax() {
		return this.tempmax;
	}
	public void setIconsrc8(String iconsrc) {
		this.iconsrc8=iconsrc;
	}
	public String getIconsrc8() {
		return this.iconsrc8;
	}
	public void setIconsrc14(String iconsrc) {
		this.iconsrc14=iconsrc;
	}
	public String getIconsrc14() {
		return this.iconsrc14;
	}
	public void setIconsrc20(String iconsrc) {
		this.iconsrc20=iconsrc;
	}
	public String getIconsrc20() {
		return this.iconsrc20;
	}

	public void setTemp8(String temp) {
		this.temp8=temp;
	}
	public String getTemp8() {
		return this.temp8;
	}
	public void setTemp14(String temp) {
		this.temp14=temp;
	}
	public String getTemp14() {
		return this.temp14;
	}
	public void setTemp20(String temp) {
		this.temp20=temp;
	}
	public String getTemp20() {
		return this.temp20;
	}
	
}

import java.util.Date;

public class Time {
	private int hours;
	private int minutes;
	private int seconds;
	private static Time timeInstance;
	private String totalTime;
	private static Date date;

	private Time() {
		hours = date.getHours();
		minutes = date.getMinutes();
		seconds = date.getSeconds();
		System.out.println("初始化的时候" + seconds);
	}

	public static Time getInstance() {
		if (timeInstance == null && date == null) {
			date = new Date();
			timeInstance = new Time();
		}

		return timeInstance;
	}

	public String getTotalTime() {
		return totalTime;
	}

	public void addTime(Date date) {
		System.out.println(date.getSeconds());
		totalTime = "总共花费:" + (date.getHours() - hours) + "小时"
				+ (date.getMinutes() - minutes) + "分钟"
				+ (date.getSeconds() - seconds) + "秒";

		hours = date.getHours();
		minutes = date.getMinutes();
		seconds = date.getSeconds();
		System.out.println("增加的时候" + seconds);
	}
}

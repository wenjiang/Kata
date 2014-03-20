import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Time {
	private List<String> mDateList;
	private File mFile;

	public Time() {
		mDateList = new ArrayList<String>();
		mFile = new File("time.txt");
	}

	public String getTotalTime() throws IOException {
		readDate();
		String totalTime = calculateTime(mDateList);
		return totalTime;
	}

	private void readDate() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(mFile));
		String dateStr = reader.readLine();
		while (dateStr != null) {
			mDateList.add(dateStr);
			dateStr = reader.readLine();
		}
		reader.close();
	}

	private String calculateTime(List<String> dates) {
		Date date = new Date();
		int startHour = Integer.parseInt(dates.get(0));
		int startMinute = Integer.parseInt(dates.get(1));
		int startSecond = Integer.parseInt(dates.get(2));

		int startTotalTime = getTotalTime(startHour, startMinute, startSecond);
		int endTotalTime = getTotalTime(date.getHours(), date.getMinutes(),
				date.getSeconds());

		int totalTime = endTotalTime - startTotalTime;

		int totalHours = totalTime / 3600;
		int totalMinutes = totalTime % 3600 / 60;
		int totalSeconds = totalTime % 3600 % 60;
		String costTime = "总共花费" + totalHours + "小时" + totalMinutes + "分钟"
				+ totalSeconds + "秒";
		return costTime;
	}

	private int getTotalTime(int hour, int minute, int second) {
		return hour * 3600 + minute * 60 + second;
	}
}

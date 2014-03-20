import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class TimeLog {
	private static BufferedWriter mWriter;

	public static void main(String[] args) throws IOException {
		Date date = new Date();
		File file = new File("time.txt");
		mWriter = new BufferedWriter(new FileWriter(file));
		logTime(date.getHours() + "");
		logTime(date.getMinutes() + "");
		logTime(date.getSeconds() + "");
		mWriter.flush();
		mWriter.close();
	}

	private static void logTime(String timeStr) throws IOException {
		mWriter.write(timeStr);
		mWriter.newLine();
	}
}

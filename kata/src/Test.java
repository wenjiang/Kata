import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	private static String completeTime;

	public static void main(String[] args) throws IOException {
		KataTest test = new KataTest();
		Time time = new Time();
		try {
			test.test();
		} catch (junit.framework.AssertionFailedError e) {
			throw e;
		}
		completeTime = time.getTotalTime();
		System.out.println(completeTime);
		new Test().saveCodeIntoFile("Sort");
	}

	private void saveCodeIntoFile(String className) throws IOException {
		String code = readCodeFromFile(className);
		File file = new File(className + ".txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
		writer.write(completeTime);
		writer.newLine();
		List<String> codeContent = new ArrayList<String>();
		Pattern pattern = Pattern.compile("[\\S]+");
		Matcher matcher = pattern.matcher(code);
		while (matcher.find()) {
			String matchContent = matcher.group();

			if (matchContent.contains("{")) {
				if (hasSameWordIn(codeContent)) {
					codeContent.add(matchContent + "\n" + "        ");
					continue;
				}
				codeContent.add(matchContent + "\n" + "    ");
				continue;
			} else if (matchContent.contains(";")) {
				codeContent.add(matchContent + "\n");
				continue;
			} else if (matchContent.contains("}")) {
				codeContent.add(matchContent + "\n");
				continue;
			} else {
				codeContent.add(matchContent + " ");
			}
		}

		for (String codeText : codeContent) {
			System.out.print(codeText);
			if (codeText.contains("\n")) {
				writer.write(codeText);
				writer.newLine();
			} else {
				writer.write(codeText);
			}
		}
		writer.flush();
		writer.close();
	}

	private boolean hasSameWordIn(List<String> list) {
		boolean isSame = false;
		for (String code : list) {
			if (code.contains("{")) {
				isSame = true;
				break;
			}
		}
		return isSame;
	}

	private String readCodeFromFile(String className) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(
				"D:\\workspace\\Kata\\src\\" + className + ".java"));
		String codeStr = reader.readLine();
		String code = "";
		while (codeStr != null) {
			code += codeStr;
			codeStr = reader.readLine();
		}
		reader.close();
		return code;
	}
}

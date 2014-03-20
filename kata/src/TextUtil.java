import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextUtil {
	private static String readCodeFromFile(String className) throws IOException {
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

	public static List<String> getCodeContent() throws IOException {
		List<String> codeContent = new ArrayList<String>();
		String code = readCodeFromFile("Numerical");
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
		}
		return codeContent;
	}

	private static boolean hasSameWordIn(List<String> list) {
		boolean isSame = false;
		for (String code : list) {
			if (code.contains("{")) {
				isSame = true;
				break;
			}
		}
		return isSame;
	}
}

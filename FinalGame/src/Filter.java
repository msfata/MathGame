public class Filter {

	public static boolean allowNumbersOnly(String string) {
		String result = "";
		char[] ch = string.toCharArray();
		for (char c : ch) {
			if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8'
					|| c == '9' || c == '.') {
				result += c;
			}
		}
		if ((string.length() == result.length()) && (!result.isEmpty())) {
			return true;
		}
		return false;
	}
}

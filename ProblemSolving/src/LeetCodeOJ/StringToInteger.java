package LeetCodeOJ;

public class StringToInteger {
	public int myAtoi(String str) {
		if (str.length() == 0 || str.equals("+") || str.equals("-"))
			return 0;
		int sign = (str.contains("-") ? -1 : 1);
		str = str.replace("+", "");
		str = str.replace("-", "");
		str = str.replace(" ", "");
		return sign * Integer.parseInt(str);
	}
}

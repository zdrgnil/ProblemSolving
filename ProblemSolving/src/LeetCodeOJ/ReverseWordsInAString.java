package LeetCodeOJ;

public class ReverseWordsInAString {
	public void reverseWords2(char[] s) {
		if (s.length <= 1)
			return;
		String str = String.copyValueOf(s);
		String[] words = str.split(" ");
		String result = "";
		for (int i = words.length - 1; i >= 0; i--)
			result += " " + words[i];
		result = result.trim();
		char[] c = result.toCharArray();
		for (int i = 0; i < c.length; i++) {
			s[i] = c[i];
		}
	}

	public void reverseWords(char[] s) {
		int c = 0;
		char r[] = new char[s.length];
		for (int i = s.length - 1; i >= -1; i--) {
			if (s[i] == ' ' || i == -1) {
				for (int j = i + 1; j < s.length; j++) {
					if (s[j] == ' ')
						break;
					r[c] = s[j];
					c++;
				}
			}
		}
	}
}

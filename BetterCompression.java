import java.util.SortedMap;
import java.util.TreeMap;

public class BetterCompression {

	public static void main(final String[] args) {
		System.out.println(betterCompression("a12b56c1").equals("a12b56c1"));
		System.out.println(betterCompression("a12c56a1b5").equals("a13b5c56"));
	}

	public static String betterCompression(final String s) {
		final StringBuilder sb = new StringBuilder();

		getCharacterFrequency(s).forEach((c, n) -> {
			sb.append(c);
			sb.append(n);
		});

		return sb.toString();
	}

	private static SortedMap<Character, Integer> getCharacterFrequency(final String s) {
		final SortedMap<Character, Integer> map = new TreeMap<>();
		final char[] chars = s.toCharArray();
		final int n = chars.length;

		char currentChar = s.charAt(0);
		String currentFreq = "";
		for (int i = 1; i < n; i++) {
			final char c = chars[i];
			final boolean digit = Character.isDigit(c);

			if (digit) {
				currentFreq += c;
			}

			if (!digit || i == n - 1) {
				map.merge(currentChar, Integer.parseInt(currentFreq), Integer::sum);
				currentFreq = "";
				currentChar = c;
			}
		}

		return map;
	}

}

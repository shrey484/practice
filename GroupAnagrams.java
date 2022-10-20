import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public List<List<String>> groupAnagrams(final String[] strs) {
		final Map<String, List<String>> groupedAnagrams = new HashMap<>();

		for (final String str : strs) {
			final String key = sorted(str);
			final List<String> anagrams = groupedAnagrams.get(key);
			if (anagrams == null) {
				final List<String> grams = new LinkedList<>();
				grams.add(str);
				groupedAnagrams.put(key, grams);
			} else {
				anagrams.add(str);
			}
		}

		return new ArrayList<>(groupedAnagrams.values());
	}

	private String sorted(final String str) {
		final int n = str.length();
		final StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {
			final char c = str.charAt(i);
			int insertionPoint = 0;
			final int n2 = sb.length();
			while (insertionPoint < n2) {
				if (c > sb.charAt(insertionPoint))
					break;
				insertionPoint++;
			}
			sb.insert(insertionPoint, c);
		}

		return sb.toString();
	}

}

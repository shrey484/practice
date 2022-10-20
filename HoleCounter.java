import java.util.HashMap;
import java.util.Map;

public class HoleCounter {
	private static final Map<Integer, Integer> holesByNumber;

	public static int countHoles(final int num) {
		int holes = 0;

		for (int temp = num; temp > 0; temp /= 10) {
			holes += holesByNumber.get(temp % 10);
		}

		return holes;
	}

	static {
		holesByNumber = new HashMap<>();
		holesByNumber.put(1, 0);
		holesByNumber.put(2, 0);
		holesByNumber.put(3, 0);
		holesByNumber.put(5, 0);
		holesByNumber.put(7, 0);
		holesByNumber.put(0, 1);
		holesByNumber.put(4, 1);
		holesByNumber.put(6, 1);
		holesByNumber.put(9, 1);
		holesByNumber.put(8, 2);
	}

}

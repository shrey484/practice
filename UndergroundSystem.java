import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

	private final Map<Integer, Map.Entry<String, Integer>> passengers;
	private final Map<Map.Entry<String, String>, TravelTimes> timeByStationPair;

	public UndergroundSystem() {
		this.passengers = new HashMap<>();
		this.timeByStationPair = new HashMap<>();
	}

	public void checkIn(int id, String stationName, int t) {
		passengers.putIfAbsent(id, new AbstractMap.SimpleImmutableEntry<>(stationName, t));
	}

	public void checkOut(int id, String stationName, int t) {
		Map.Entry<String, Integer> info = passengers.remove(id);
		int delta = t - info.getValue();
		timeByStationPair.computeIfAbsent(new AbstractMap.SimpleImmutableEntry<>(info.getKey(), stationName), s -> new TravelTimes())
			.add(delta);
	}

	public double getAverageTime(String startStation, String endStation) {
		return timeByStationPair.get(new AbstractMap.SimpleImmutableEntry<>(startStation, endStation)).getAverage();
	}

	class TravelTimes {
		private int sum;
		private int count;

		public void add(int value) {
			this.sum += value;
			this.count++;
		}

		public double getAverage() {
			return 1.0 * sum / count;
		}
	}
}

import java.util.Comparator;

public class CustomComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		int i1 = ((Integer) o1).intValue();
		int i2 = ((Integer) o2).intValue();
		if (i1 < i2) {
			return -1;
		}
		if (i1 > i2) {
			return 1;
		}
		return 0;
	}
}

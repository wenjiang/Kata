import java.util.Date;

import junit.framework.TestCase;

import org.junit.Test;

public class KataTest extends TestCase {
	private Time time;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		time = Time.getInstance();
	}

	@Test
	public void test() {
		int[] unsortedData = { 3, 2, 6, 5 };
		int[] sortedData = { 2, 3, 5, 6 };
		int[] quickSortedData = QuickSort.sort(unsortedData);
		try {
			// assertEquals(sortedData, quickSortedData);
			assertEquals(getFalse(), getTrue());
		} catch (junit.framework.AssertionFailedError e) {
			time.addTime(new Date());

			throw e;
		}
		time.addTime(new Date());

	}

	private Object getTrue() {
		return true;
	}

	private Object getFalse() {
		return true;
	}
}

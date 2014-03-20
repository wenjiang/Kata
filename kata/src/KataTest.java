import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;

public class KataTest extends TestCase {
	@Test
	public void test() {
		int length = 100000;
		int[] array = new int[length];
		Random random = new Random();
		for (int i = 0; i < length; ++i) {
			array[i] = random.nextInt(length);
		}

		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < length; ++i) {
			list.add(array[i]);
		}

		long comparatorStartTime = System.currentTimeMillis();
		Collections.sort(list, new CustomComparator());
		long comparatorEndTime = System.currentTimeMillis();
		long comparatorTime = comparatorEndTime - comparatorStartTime;
		long customStartTime = System.currentTimeMillis();
		int[] sortedArray = Sort.sort(array);
		long customEndTime = System.currentTimeMillis();
		long customTime = customEndTime - customStartTime;

		try {
			assertEquals(true, (customTime <= comparatorTime));
		} catch (junit.framework.AssertionFailedError e) {
			throw e;
		}
	}
}

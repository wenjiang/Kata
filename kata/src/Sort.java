public class Sort {
	public static int[] sort(int[] unsortedArray) {
		int length = unsortedArray.length;
		for (int i = 0; i < length - 1; ++i) {
			int temp = unsortedArray[i];
			for (int j = i + 1; j < length; ++j) {
				if (temp >= unsortedArray[j]) {
					unsortedArray[i] = unsortedArray[j];
					unsortedArray[j] = temp;
					temp = unsortedArray[i];
				}
			}
		}
		return unsortedArray;
	}
}

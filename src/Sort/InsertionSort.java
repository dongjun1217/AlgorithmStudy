package Sort;

public class InsertionSort {

	int[] array = { 9, 8, 7, 4, 5, 2, 1, 6, 10, 3 };

	int[] insertionSort(int[] data) {
		int temp = 0;
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = i + 1; j > 0; j--) {
				if (data[j] < data[j - 1]) {
					temp = data[j];
					data[j] = data[j - 1];
					data[j - 1] = temp;
				} else
					break;
			}
		}
		return data;
	}

	public static void main(String[] args) {
		InsertionSort test = new InsertionSort();
		test.insertionSort(test.array);
		for (int i = 0; i < test.array.length; i++) {
			System.out.println(test.array[i]);
		}
	}

}

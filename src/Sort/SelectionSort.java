package Sort;

public class SelectionSort {
	int[] array = { 9, 8, 7, 4, 5, 2, 1, 6, 10, 3 };

	int[] selectionSort(int[] data) {

		int lowest = 0;

		for (int stand = 0; stand < data.length - 1; stand++) {
			int temp = 0;
			lowest = data[stand]; // 기준값을 잡는다
			
			for (int index = stand + 1; index < data.length; index++) {
				
				if (data[stand] > data[index]) { // 기준값과 루프값을 비교한다. 기준값보다 값이 작으면 스왑이 이루어진다.
					lowest = data[index];
					temp = data[index];
					data[index] = data[stand];
					data[stand] = temp;
				}
			}
		}

		return data;
	}

	public static void main(String[] args) {
		SelectionSort test = new SelectionSort();
		test.selectionSort(test.array);
		for (int i = 0; i < test.array.length; i++) {
			System.out.println(test.array[i]);
		}

	}

}

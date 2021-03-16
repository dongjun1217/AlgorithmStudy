package Sort;

public class SelectionSort {
	int[] array = { 9, 8, 7, 4, 5, 2, 1, 6, 10, 3 };

	int[] selectionSort(int[] data) {

		int lowest = 0;

		for (int stand = 0; stand < data.length - 1; stand++) {
			int temp = 0;
			lowest = data[stand]; // ���ذ��� ��´�
			
			for (int index = stand + 1; index < data.length; index++) {
				
				if (data[stand] > data[index]) { // ���ذ��� �������� ���Ѵ�. ���ذ����� ���� ������ ������ �̷������.
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

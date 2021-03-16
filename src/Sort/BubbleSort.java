package Sort;


public class BubbleSort {
	int[] array = { 9, 8, 7, 4, 5, 2, 1, 6, 10, 3 };

	int[] bubbleSort(int[] data) {
		
		for (int i = 0; i < data.length - 1; i++) {
			
			boolean swap = false; // ó������ ������ �Ǿ��� �迭�� ���� ���, �ٷ� break ���� �ð��� �ּ�ȭ �Ѵ�.
			int temp = 0; // ���� �ٲ� �� ����� �ӽ� ����.

			for (int j = 0; j < data.length - i - 1; j++) {
				if (data[j] > data[j + 1]) {
					temp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = temp;
					swap = true;
				}
			}
			if(swap == false)
				break;
		}

		return data;
	}

	public static void main(String[] args) {
		BubbleSort test = new BubbleSort();
		test.bubbleSort(test.array);
		for(int i=0;i<test.array.length;i++) {
			System.out.println(test.array[i]);
		}
	}

}

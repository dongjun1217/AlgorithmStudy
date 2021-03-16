package Sort;


public class BubbleSort {
	int[] array = { 9, 8, 7, 4, 5, 2, 1, 6, 10, 3 };

	int[] bubbleSort(int[] data) {
		
		for (int i = 0; i < data.length - 1; i++) {
			
			boolean swap = false; // 처음부터 정렬이 되어진 배열이 들어올 경우, 바로 break 시켜 시간을 최소화 한다.
			int temp = 0; // 값을 바꿀 때 사용할 임시 변수.

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

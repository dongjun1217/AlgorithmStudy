package Sort;

import java.util.Arrays;

public class MergeSort {

	static int[] mergeSort(int[] data) {
		if (data.length <= 1)
			return data;

		int medium = data.length / 2;
		int[] left = mergeSort(Arrays.copyOfRange(data, 0, medium));
		int[] right = mergeSort(Arrays.copyOfRange(data, medium, data.length));

		return merge(left, right);
	}

	static int[] merge(int[] left, int[] right) {

		int[] merged = new int[left.length + right.length];
		int leftPoint = 0, rightPoint = 0, count = 0;
		while (left.length > leftPoint && right.length > rightPoint) {
			if (left[leftPoint] > right[rightPoint]) {
				merged[count] = right[rightPoint];
				rightPoint++;
				count++;
			} else {
				merged[count] = left[leftPoint];
				leftPoint++;
				count++;
			}
		}

		while (left.length > leftPoint) {
			merged[count] = left[leftPoint];
			leftPoint++;
			count++;
		}

		while (right.length > rightPoint) {
			merged[count] = right[rightPoint];
			rightPoint++;
			count++;
		}

		return merged;
	}

	public static void main(String[] args) {
		int[] array = { 9, 8, 7, 4, 5, 2, 1, 6, 10, 3};
		int[] sortedArray = mergeSort(array);
		for (int i : sortedArray) {
			System.out.println(i);
		}
	}
}

package Search;

import java.util.Arrays;

public class BinarySearch {

	static boolean binarySearch(int[] data, int target) {

		if (data.length == 1 && target == data[0])
			return true;
		if (data.length == 1 && target != data[0])
			return false;
		if (data.length == 0)
			return false;

		int medium = data.length / 2;

		if (target == data[medium])
			return true;
		else {
			if (target < data[medium])
				return binarySearch(Arrays.copyOfRange(data, 0, medium), target);
			else
				return binarySearch(Arrays.copyOfRange(data, medium, data.length), target);

		}
	}

	public static void main(String[] args) {
		int[] arrays = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
				27, 28, 29, 30 };

		System.out.println(binarySearch(arrays, 1));
	}

}

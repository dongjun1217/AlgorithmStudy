package AlgorithmBaekJoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Level3 {

	static ArrayList stack() {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> result = new ArrayList<String>();
		int size = scan.nextInt();
		int[] stack = new int[size];
		int idx = 0;
		int start = 0;

		while (size-- > 0) {
			int value = scan.nextInt();

			if (value > start) {
				for (int i = start + 1; i <= value; i++) {
					stack[idx] = i;
					idx++;
					result.add("+");
				}
				start = value;
			}

			else if (stack[idx - 1] != value) {
				System.out.println("NO");
				System.exit(0);
			}

			idx--;
			result.add("-");

		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(stack());
	}
}

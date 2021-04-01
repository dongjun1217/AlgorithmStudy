package RecursiveCall;

public class RecursiveCall {

	static int factorial(int number) { // 팩토리얼

		if (number > 1) {
			return number * factorial(number - 1);
		} else {
			return number;
		}
	}

	static int sum(int n, int[] data) { // 배열의 합
		if (n <= 0) {
			return 0;
		} else {
			return sum(n - 1, data) + data[n - 1];
		}

	}

	static boolean palindrome(String text) { // 회문 ex : 토마토,level,오디오 등

		if (text.length() <= 1)
			return true;
		if (text.charAt(0) == text.charAt(text.length() - 1))
			return palindrome(text.substring(1, text.length() - 1));
		else
			return false;
	}

	static int numberOfCases(int num) { // 경우의수

		if (num == 1)
			return 1;
		else if (num == 2)
			return 2;
		else if (num == 3)
			return 4;

		return numberOfCases(num - 1) + numberOfCases(num - 2) + numberOfCases(num - 3);
	}

	static int fibonacci(int num) { // 피보나치 수열
		if (num <= 1) {
			return num;
		}
		return fibonacci(num - 1) + fibonacci(num - 2);
	}

	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		System.out.println("배열의합 : " + sum(numbers.length, numbers));
		System.out.println("팩토리얼 : " + factorial(10));
		System.out.println("회문 : " + palindrome("토마토"));
		System.out.println("경우의수 : " + numberOfCases(5));
		System.out.println("피보나치 수열 : " + fibonacci(10));
	}
}

package RecursiveCall;

public class RecursiveCall {

	static int factorial(int number) { // ���丮��

		if (number > 1) {
			return number * factorial(number - 1);
		} else {
			return number;
		}
	}

	static int sum(int n, int[] data) { // �迭�� ��
		if (n <= 0) {
			return 0;
		} else {
			return sum(n - 1, data) + data[n - 1];
		}

	}

	static boolean palindrome(String text) { // ȸ�� ex : �丶��,level,����� ��

		if (text.length() <= 1)
			return true;
		if (text.charAt(0) == text.charAt(text.length() - 1))
			return palindrome(text.substring(1, text.length() - 1));
		else
			return false;
	}

	static int numberOfCases(int num) { // ����Ǽ�

		if (num == 1)
			return 1;
		else if (num == 2)
			return 2;
		else if (num == 3)
			return 4;

		return numberOfCases(num - 1) + numberOfCases(num - 2) + numberOfCases(num - 3);
	}

	static int fibonacci(int num) { // �Ǻ���ġ ����
		if (num <= 1) {
			return num;
		}
		return fibonacci(num - 1) + fibonacci(num - 2);
	}

	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		System.out.println("�迭���� : " + sum(numbers.length, numbers));
		System.out.println("���丮�� : " + factorial(10));
		System.out.println("ȸ�� : " + palindrome("�丶��"));
		System.out.println("����Ǽ� : " + numberOfCases(5));
		System.out.println("�Ǻ���ġ ���� : " + fibonacci(10));
	}
}

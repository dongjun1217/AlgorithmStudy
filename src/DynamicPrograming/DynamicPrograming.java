package DynamicPrograming;

public class DynamicPrograming {

	static int fibonacci(int num) {
		int[] cashe = new int[num + 1];
		cashe[0] = 0;
		cashe[1] = 1;

		for (int i = 2; i < num + 1; i++) {
			cashe[i] = cashe[i - 1] + cashe[i - 2];
		}
		return cashe[num];
	}

	public static void main(String[] args) {
		System.out.println(fibonacci(10));
	}	

}

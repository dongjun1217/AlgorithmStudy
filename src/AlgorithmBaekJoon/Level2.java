package AlgorithmBaekJoon;

import java.util.Scanner;

public class Level2 {

	static int blackJack() {

		Scanner scan = new Scanner(System.in);
		int totalCard = scan.nextInt();
		int blackJack = scan.nextInt();
		int[] cards = new int[totalCard];
		for (int i = 0; i < totalCard; i++) {
			cards[i] = scan.nextInt();
		}
		for (int i = 0; i < cards.length; i++) {
			for (int j = i + 1; j < cards.length; j++) {
				for (int k = j + 1; k < cards.length; k++) {
					int sumValue = cards[i] + cards[j] + cards[k];
					if (sumValue <= blackJack) {
						blackJack = Math.max(blackJack, sumValue);
					}
				}
			}
		}
		return blackJack;
	}

	public static void main(String[] args) {
		System.out.println(blackJack());
	}

}

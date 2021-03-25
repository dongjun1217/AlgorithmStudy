package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Greedy {

	static String minCoinCount(int money, LinkedList<Integer> coinList) {

		int totalCoinCount = 0;
		LinkedList<Integer[]> details = new LinkedList<Integer[]>();
		coinList.sort(Comparator.reverseOrder());

		for (int i = 0; i < coinList.size(); i++) {
			int coinNum = money / coinList.get(i); // 순차적으로 500원 , 100원 , 50원 , 1원 순으로 나눈 값을 coinNum에 넣어준다.
			totalCoinCount += coinNum;
			money -= coinNum * coinList.get(i);
			details.add(new Integer[] { coinList.get(i), coinNum });
		}

		return "총 "+totalCoinCount+"개 동전이 사용되었습니다."+
		Arrays.toString(details.get(0))
		+Arrays.toString(details.get(1))
		+Arrays.toString(details.get(2))
		+Arrays.toString(details.get(3));
	}

	public static void main(String[] args) {
		LinkedList<Integer> coinList = new LinkedList<Integer>();
		coinList.add(100);
		coinList.add(50);
		coinList.add(1);
		coinList.add(500);

		System.out.println(minCoinCount(4720, coinList));

	}

}

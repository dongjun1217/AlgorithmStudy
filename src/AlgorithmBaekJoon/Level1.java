package AlgorithmBaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class Level1 {

	static String checkAscDesc() {
		Scanner scan = new Scanner(System.in);
		int [] arrays = new int[8];
		
		boolean ascending=true;
		boolean descending=true;
		
		for(int index=0;index<8;index++) {
			arrays[index]= scan.nextInt();
		}
		for(int i = 1 ; i < 8;i++) {
			if(arrays[i]> arrays[i-1])
				descending = false;
			else if(arrays[i]< arrays[i-1])
				ascending = false;
		}

		if(ascending)
			return "ascending";
		else if(descending)
			return "descending";
		else
			return "mixed";
	}

	public static void main(String[] args) {
		System.out.println(checkAscDesc());
	}

}

package Search;

public class SequencialSearch {

	static String sequencialSearch(int[] data,int target) {
		for(int index=0;index<data.length;index++) {
			if(data[index]== target) 
				return (index+1)+"회 만에 값을 찾았습니다.";
		}
		return "데이터가 없습니다";
	}
	
	
	public static void main(String[] args) {
		int[] arrays = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
				27, 28, 29, 30 };
		System.out.println(sequencialSearch(arrays, 31));
		
	}

}

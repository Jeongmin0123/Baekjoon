package Gold;

import java.util.Scanner;
// 생각해보기
public class Main1089 {
	public static String[][] arr;
	public static String[] result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new String[5][4*N-1];
		
	}
	
	public static double mean() {
		if(result[0] == "-1") {
			return -1;
		}
		double avg = 0;
		int all_sum = 0;
		for(int i = 0 ; i < result.length ; i++) {
			int sum = 0;
			for(int j = 0 ; j < result[0].length() ; j++) {
				sum = sum*10;
				sum += result[i].charAt(j);
			}
			all_sum += sum;
		}
		avg = (all_sum*100.0)/(100.0);
		return avg;
	}
	
	public static void check() {
		
	}
}

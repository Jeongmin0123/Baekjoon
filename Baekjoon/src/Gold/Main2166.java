package Gold;

import java.util.Scanner;

public class Main2166 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 좌표를 받아온다. 이때 N+1로 받아오는 이유는 추후에 신발끈 공식을 사용하기 위함이다.
		// 따라서 공식 사용을 위해 배열의 마지막 값은 배열의 첫 값을 넣어준다.
		long[][] coordi = new long[N+1][2];
		for(int i = 0 ; i < N ; i++) {
			coordi[i][0] = sc.nextLong();
			coordi[i][1] = sc.nextLong();			
		}
		// 배열의 맨 마지막 값에 배열의 맨 첫값을 넣어준다.
		coordi[N] = coordi[0].clone();
		area(coordi);
	}
	// 신발끈 공식을 이용하여 넓이를 구하는 메서드
	public static void area(long[][] coordi) {
		long sum1 = 0L;
		long sum2 = 0L;
		for(int i = 0 ; i < coordi.length - 1 ; i++) {
			sum1 += coordi[i][0]*coordi[i+1][1];
			sum2 += coordi[i+1][0]*coordi[i][1];
		}
		System.out.println(String.format("%.1f", Math.abs(sum1 - sum2) / 2D));
		
	}
}

package Silver;

import java.util.Scanner;

public class Main1094 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 0;
		while(N > 0) {
			// 막대기의 길이를 2로 나누었을 때 나머지가 존재한다면 결국 자르다 보면 맨 마지막에 나머지가 없을 때보다 1개의 막대기가 더 필요하므로
			// 나머지가 1일 때는 count를 증가시킨다.
			if(N%2 == 1) {
				count++;
			} 
			N = N/2;
		}
		System.out.println(count);
	}

}

package Gold;

import java.util.Scanner;

public class Main3020 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int H = sc.nextInt();
		// 각각의 길이에 대한 석순의 개수
		int[] bottom = new int[H+1];
		// 각각의 길이에 대한 종유석의 개수
		int[] top = new int[H+1];
		for(int i = 0 ; i < N/2 ; i++) {
			// 받아온 길이의 종유석과 석순 개수를 증가시킨다.
			bottom[sc.nextInt()]++;
			top[sc.nextInt()]++;			
		}
		// 길이가 i이하인 종유석과 석순의 개수 합을 저장하는 배열을 만든다.
		int[] bot_sum = new int[H+1];
		int[] top_sum = new int[H+1];
		for(int i = 0 ; i < H ; i++) {
			bot_sum[i+1] = bot_sum[i] + bottom[i+1];
			top_sum[i+1] = top_sum[i] + top[i+1];
		}
		int min = N;
		int count = 0;
		for(int i = 1 ; i < H+1 ; i++) {
			// 부딛히는 횟수
			int crush = 0;
			// i구간에서 석순과 부딛히는 횟수는 전체 석순의 개수에서 길이가 i-1이하인 석순의 개수를 뺀 것과 같다.
			crush += bot_sum[H] - bot_sum[i-1];
			// i구간에서 종유석과 부딛히는 횟수는 전체 종유석의 개수에서 길이가 H-i이하인 종유석의 개수를 뺀 것과 같다.
			crush += top_sum[H] - top_sum[H-i];
			// min값보다 충돌값이 크면 min값을 바꾸고 개수를 1로 지정한다.
			if(min > crush) {
				min = crush;
				count = 1;
				// min값과 충돌값이 같으면 개수를 증가시킨다.
			} else if (min == crush) {
				count++;
			}
		}
		System.out.println(min + " " + count);
	}
}

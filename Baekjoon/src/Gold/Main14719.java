package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14719 {
	
	public static int H,W;
	public static int[] block;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		block = new int[W];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < W ; i++) {
			block[i] = Integer.parseInt(st.nextToken());
		}
		int sum = 0;	// 결과값
		for(int i = 1 ; i < W - 1 ; i++) {	// 맨 왼쪽과 맨 오른쪽은 고려하지 않아도 된다.
			int left = 0;
			int right = 0;
			// 현재 위치에서 왼쪽에 있는 블럭들 중 높이가 가장 큰 값을 가져온다.
			for(int j = 0 ; j < i ; j ++) {
				left = Math.max(block[j], left);
			}
			// 현재 위치에서 오른쪽에 있는 블럭들 중 높이가 가장 큰 값을 가져온다.
			for(int j = i + 1 ; j < W ; j++) {
				right = Math.max(block[j], right);
			}
			// 현재 위치의 블럭의 높이
			int now = block[i];
			// 현재 위치의 블럭이 왼쪽 오른쪽의 블럭들 중 높이가 가장 큰 값보다 작으면 빗물이 고인다.
			if(now < left && now < right) {
				sum += Math.min(left, right) - now;
			}
		}
		System.out.println(sum);
	}
}

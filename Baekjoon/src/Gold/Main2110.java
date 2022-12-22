package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2110 {

	public static int N,C;
	public static int[] houses;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		houses = new int[N];
		for(int i = 0 ; i < N ; i++) {
			houses[i] = Integer.parseInt(br.readLine());
		}
		// 이분 탐색을 위해 정렬한다.
		Arrays.sort(houses);
		calc();
	}
	
	// 가장 인접한 두 공유기 사이의 최대 거리를 출력하는 메서드
	public static void calc() {
		// 이분 탐색시, 집의 좌표가 0부터 1000000000이고, 집의 좌표가 같은 것은 없으므로
		// 두 공유기 사이의 가능한 거리 1부터 1000000000이므로 이에 따른 L,R값을 지정한다.
		int L = 1;
		int R = 1000000000;
		int answer = 0;
		while(L <= R) {
			int mid = (L+R)/2;
			if(check(mid)) {
				answer = mid;
				L = mid + 1;
			} else {
				R = mid - 1;
			}
		}
		System.out.println(answer);
	}
	
	// distance 만큼의 거리 차이를 뒀을 때 C개 이상의 공유기를 설치할 수 있는지 확인하는 메서드
	public static boolean check(int distance) {
		// 제일 처음 공유기는 맨 앞집에 설치한다.
		int count = 1;
		int last = houses[0];
		for(int i = 1 ; i < N ; i++) {
			// 두 집 사이의 거리가 distance보다 크거나 같아진다면 뒤에 집에 공유기를 설치한다.
			if(houses[i] - last >= distance) {
				count++;
				last = houses[i];
			}
		}
		return count >= C;
	}
}

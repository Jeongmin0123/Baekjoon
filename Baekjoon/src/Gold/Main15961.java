package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15961 {

	public static int N,d,k,c;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		// 벨트에 회전초밥을 초기화한다.
		int[] belt = new int[N];
		int[] eated = new int[d+1];
		for(int i = 0 ; i < N ; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}
		int left = 0;
		int right = k;
		int max = 0;
		int sum = 0;
		
		// 만약 먹지 않은 초밥이라면 초밥가지수를 증가시키고 먹은 초밥의 번호로 그 초밥의 먹은 개수를 증가시키고
		// 이미 먹었던 초밥인 경우 그 초밥의 먹은 개수만 증가시킨다.
		for(int i = 0 ; i < right ; i++) {
			if(eated[belt[i]] == 0) {
				sum++;
			}
			eated[belt[i]]++;
		}
		// 보너스 번호를 먹지 않은 경우 +1을 하여 max 값을 초기화하고 아닌경우 현재 초밥가지수를 max로 초기화한다.
		if(eated[c] == 0) {
			sum++;
			max = sum;
			sum--;
		} else {
			max = sum;
		}
		while(left < N) {
			// 회전초밥의 특성때문에 right가 끝 지점에 도달하면 맨 처음 위치로 가도록 한다.
			if(right >= N) {
				right -= N;
			}
			// 새로 들어온 초밥이 만약 한번도 먹어보지 않은 초밥의 경우, 초밥 가지수를 증가시킨다.
			if(eated[belt[right]] == 0) {
				sum++;
			}
			// 먹은 초밥의 개수를 증가시키고 옆으로 한칸 이동한다.
			eated[belt[right]]++;
			right++;
			// 빠지는 초밥이 만약 한번 먹어본 초밥의 경우, 초밥 가지수를 감소시킨다.
			if(eated[belt[left]] == 1) {
				sum--;
			}
			// 빠진 초밥의 개수를 감소시키고 옆으로 한칸 이동한다.
			eated[belt[left]]--;
			left++;
			// 보너스 초밥을 먹은 경우, 안 먹은 경우로 나누어 문제를 푼다.
			if(eated[c] == 0) {
				sum++;
				if(sum > max) max = sum;
				sum--;
			} else {
				if(sum > max) max = sum;
			}
		}
		System.out.println(max);
	}

}

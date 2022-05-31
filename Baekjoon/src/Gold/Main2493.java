package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Stack<Integer> check = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		// 백준 17298번과 비슷한 풀이
		// 자신을 기준으로 왼쪽에 자신보다 큰 수가 나오는 경우 그 index값에 +1 한 값을 가진다.
		for(int i = N-1 ; i >= 0 ;i--) {
			while(!check.isEmpty() && num[check.peek()] < num[i]) {
				num[check.pop()] = i+1;
			}
			check.push(i);
		}
		while(!check.isEmpty()) {
			num[check.pop()] = 0;
		}
		// String에 for문을 통해서 계속 더해주는 방식으로 문제를 풀면 시간초과가 발생하므로 StringBuilder를 사용한다. 
		for(int i = 0 ; i < N ; i++) {
			sb.append(num[i]).append(' ');
		}
		System.out.println(sb);
		br.close();
	}

}

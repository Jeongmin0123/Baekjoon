package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2812 {

	public static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		String num = br.readLine();
		int[] nums = new int[N];
		// 받아온 숫자를 순서대로 저장한다.
		for (int i = 0; i < N; i++) {
			nums[i] = num.charAt(i) - '0';
		}
		int remove = 0;
		Stack<Integer> answer = new Stack<Integer>();
		// 받아온 숫자의 자리수 만큼 반복한다.
		for (int i = 0; i < N; i++) {
			// queue가 비어있지 않고 큐의 마지막 자리수가 들어올 숫자보다 작으며 지울 수 있는 숫자가 남은 경우 숫자를 지운다.
			while (!answer.isEmpty() && answer.peek() < nums[i] && remove < K) {
				answer.pop();
				remove++;
			}
			// 더이상 지울 숫자가 없는 경우 숫자를 넣어준다.
			answer.add(nums[i]);
		}
		// queue에 숫자배열을 넣어준 경우 순서대로 적립되므로 앞에서부터 빼준다.
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num.length() - K; i++) {
			sb.append(answer.get(i));
		}
		System.out.println(sb);
	}

}
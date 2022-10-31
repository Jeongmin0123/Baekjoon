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
		// �޾ƿ� ���ڸ� ������� �����Ѵ�.
		for (int i = 0; i < N; i++) {
			nums[i] = num.charAt(i) - '0';
		}
		int remove = 0;
		Stack<Integer> answer = new Stack<Integer>();
		// �޾ƿ� ������ �ڸ��� ��ŭ �ݺ��Ѵ�.
		for (int i = 0; i < N; i++) {
			// queue�� ������� �ʰ� ť�� ������ �ڸ����� ���� ���ں��� ������ ���� �� �ִ� ���ڰ� ���� ��� ���ڸ� �����.
			while (!answer.isEmpty() && answer.peek() < nums[i] && remove < K) {
				answer.pop();
				remove++;
			}
			// ���̻� ���� ���ڰ� ���� ��� ���ڸ� �־��ش�.
			answer.add(nums[i]);
		}
		// queue�� ���ڹ迭�� �־��� ��� ������� �����ǹǷ� �տ������� ���ش�.
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num.length() - K; i++) {
			sb.append(answer.get(i));
		}
		System.out.println(sb);
	}

}
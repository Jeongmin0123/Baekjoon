package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2230 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] numbers = new int[N];
		for(int i = 0 ; i < N ; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		
		// �迭�� �����Ѵ�.
		Arrays.sort(numbers);
		int left = 0;
		int right = 0;
		int answer = Integer.MAX_VALUE;
		// ���� ���� ������ �� ������ ���� M���� �۴ٸ� �������� �ε����� ��ĭ �̵��ϰ� �� �ݴ�� �ּҰ��� �������� �ڿ�  ������ �ε����� ��ĭ �̵��Ѵ�.
		while(left <= right && right < N) {
			if(numbers[right] - numbers[left] < M) {
				right++;
			} else {
				answer = Math.min(answer, numbers[right] - numbers[left]);
				left++;
			}
		}
		System.out.println(answer);
	}
}


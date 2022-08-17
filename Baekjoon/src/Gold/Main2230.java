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
		
		// 배열을 정렬한다.
		Arrays.sort(numbers);
		int left = 0;
		int right = 0;
		int answer = Integer.MAX_VALUE;
		// 만약 정한 구간의 양 끝값의 차가 M보다 작다면 오른쪽의 인덱스를 한칸 이동하고 그 반대면 최소값을 재지정한 뒤에  왼쪽의 인덱스를 한칸 이동한다.
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


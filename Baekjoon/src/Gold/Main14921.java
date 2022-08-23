package Gold;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main14921 {

	// 0에 가장 가까워야 하므로 max value를 저장해 놓는다
	public static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 배열을 정렬한다.
		Arrays.sort(arr);
		// 맨 왼쪽과 맨 오른쪽 인덱스를 각각 저장한다.
		int left = 0;
		int right = N-1;
		while(left < right) {
			// 만약 둘이 더한 값이 음수면 왼쪽 인덱스를 하나 증가 시킨다.
			if(arr[left] + arr[right] > 0) {
				// 절대값이 현재 답보다 작으면 현재 답을 교체한다.
				if(Math.abs(answer) > Math.abs(arr[left] + arr[right])) {
					answer = arr[left] + arr[right];
				}
				right--;
				// 만약 둘이 더한 값이 양수면 왼쪽 인덱스를 하나 증가 시킨다.
			} else if(arr[left] + arr[right] < 0) {
				// 절대값이 현재 답보다 작으면 현재 답을 교체한다.
				if(Math.abs(answer) > Math.abs(arr[left] + arr[right])) {
					answer = arr[left] + arr[right];
				}
				left++;
			} else {
				// 둘의 합이 0인 경우 0 출력후 연산을 종료한다.
				System.out.println(0);
				System.exit(0);
			}
		}
		System.out.println(answer);
	}

}


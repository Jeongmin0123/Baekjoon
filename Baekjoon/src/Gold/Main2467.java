package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2467 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 받아온 용액을 정렬한다.
		Arrays.sort(arr);
		int left = 0;
		int right = N - 1;
		// 답을 위한 두 용액의 위치를 저장하는 배열
		int[] location = new int[2];
		int sum = Integer.MAX_VALUE;
		while(left < right) {
			int temp = arr[left] + arr[right];
			// 새로 이동한 지점의 두 용액의 특성값이 이전 특성값보다 작다면 특성값이 0에 가장 가까운 용액을 바꿔준다.
			if(Math.min(Math.abs(temp), sum) == Math.abs(temp)) {
				location[0] = left;
				location[1] = right;
				sum = Math.min(Math.abs(temp), sum);
			}
			// 특성값이 0보다 크면 산성 용액의 값을 줄이고 특성값의 최소값을 재지정한다.
			if(temp > 0) {
				right--;
				// 특성값이 0보다 작으면 산성 용액의 값을 줄이고 특성값의 최소값을 재지정한다.
			} else if(temp < 0) {
				left++;
			// 특성값이 0이면 두 용액의 위치를 저장하고 연산을 종료한다.
			} else {
				location[0] = left;
				location[1] = right;
				break;
			}
		}
		System.out.println(arr[location[0]] + " " + arr[location[1]]);
	}
	
}

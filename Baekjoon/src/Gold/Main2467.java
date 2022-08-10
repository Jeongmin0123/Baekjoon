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
		Arrays.sort(arr);
		int left = 0;
		int right = N - 1;
		int[] location = new int[2];
		int sum = Integer.MAX_VALUE;
		while(left < right) {
			int temp = arr[left] + arr[right];
			if(Math.min(Math.abs(temp), sum) == Math.abs(temp)) {
				location[0] = left;
				location[1] = right;
			}
			if(temp > 0) {
				sum = Math.min(Math.abs(temp), sum);
				right--;
			} else if(temp < 0) {
				sum = Math.min(Math.abs(temp), sum);
				left++;
			} else {
				location[0] = left;
				location[1] = right;
				break;
			}
		}
		System.out.println(arr[location[0]] + " " + arr[location[1]]);
	}
	
}

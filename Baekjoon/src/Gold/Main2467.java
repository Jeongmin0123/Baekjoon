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
		// �޾ƿ� ����� �����Ѵ�.
		Arrays.sort(arr);
		int left = 0;
		int right = N - 1;
		// ���� ���� �� ����� ��ġ�� �����ϴ� �迭
		int[] location = new int[2];
		int sum = Integer.MAX_VALUE;
		while(left < right) {
			int temp = arr[left] + arr[right];
			// ���� �̵��� ������ �� ����� Ư������ ���� Ư�������� �۴ٸ� Ư������ 0�� ���� ����� ����� �ٲ��ش�.
			if(Math.min(Math.abs(temp), sum) == Math.abs(temp)) {
				location[0] = left;
				location[1] = right;
				sum = Math.min(Math.abs(temp), sum);
			}
			// Ư������ 0���� ũ�� �꼺 ����� ���� ���̰� Ư������ �ּҰ��� �������Ѵ�.
			if(temp > 0) {
				right--;
				// Ư������ 0���� ������ �꼺 ����� ���� ���̰� Ư������ �ּҰ��� �������Ѵ�.
			} else if(temp < 0) {
				left++;
			// Ư������ 0�̸� �� ����� ��ġ�� �����ϰ� ������ �����Ѵ�.
			} else {
				location[0] = left;
				location[1] = right;
				break;
			}
		}
		System.out.println(arr[location[0]] + " " + arr[location[1]]);
	}
	
}

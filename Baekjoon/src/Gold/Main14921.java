package Gold;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main14921 {

	// 0�� ���� ������� �ϹǷ� max value�� ������ ���´�
	public static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// �迭�� �����Ѵ�.
		Arrays.sort(arr);
		// �� ���ʰ� �� ������ �ε����� ���� �����Ѵ�.
		int left = 0;
		int right = N-1;
		while(left < right) {
			// ���� ���� ���� ���� ������ ���� �ε����� �ϳ� ���� ��Ų��.
			if(arr[left] + arr[right] > 0) {
				// ���밪�� ���� �亸�� ������ ���� ���� ��ü�Ѵ�.
				if(Math.abs(answer) > Math.abs(arr[left] + arr[right])) {
					answer = arr[left] + arr[right];
				}
				right--;
				// ���� ���� ���� ���� ����� ���� �ε����� �ϳ� ���� ��Ų��.
			} else if(arr[left] + arr[right] < 0) {
				// ���밪�� ���� �亸�� ������ ���� ���� ��ü�Ѵ�.
				if(Math.abs(answer) > Math.abs(arr[left] + arr[right])) {
					answer = arr[left] + arr[right];
				}
				left++;
			} else {
				// ���� ���� 0�� ��� 0 ����� ������ �����Ѵ�.
				System.out.println(0);
				System.exit(0);
			}
		}
		System.out.println(answer);
	}

}


package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11659 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// ���� ������ �����ؾ� �Ǵ� Ƚ��
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		
		// ������ �������� �迭�� �����Ѵ�.
		int[] arr = new int[N];
		arr[0] = Integer.parseInt(st.nextToken());
		for(int i = 1 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];
		}
		int[] result = new int[M];
		// �������� ���� ���� ������ ���� ���Ѵ�.
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if(start > 1) {
				result[i] = arr[end-1] - arr[start-2];
			} else {
				result[i] = arr[end-1] - arr[start-1] + arr[0];
			}
		}
		for(int i = 0 ; i < M ; i++) {
			System.out.println(result[i]);
		}
	}

}

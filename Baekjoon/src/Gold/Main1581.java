package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1581 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[4];
		for(int i = 0 ; i < 4 ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int answer = 0;
		// ������ �����ϴ� �뷡�� ���� ���(== FF, FS�� ���� ���)
		if(arr[0] == 0 && arr[1] == 0) {
			answer = arr[3] + Math.min(arr[2], 1);
		}
		// FS�� ����, FF�� �ִ� ���(�� ��쿡�� FF�� �����ؾ� �Ѵ�.)
		else if(arr[1] == 0) {
			answer = arr[0];
		}
		// FF,FS�� �Ѵ� �����ϴ� ���
		else {
			// FS�� SF���� ���� ���
			if(arr[1] > arr[2]) {
				answer = arr[0] + arr[3] + arr[2]*2 + 1;
			} else {
				answer = arr[0] + arr[3] + arr[1]*2;
			}
		}
		System.out.println(answer);
	}

}

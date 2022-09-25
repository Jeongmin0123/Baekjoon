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
		// 빠르게 시작하는 노래가 없는 경우(== FF, FS가 없는 경우)
		if(arr[0] == 0 && arr[1] == 0) {
			answer = arr[3] + Math.min(arr[2], 1);
		}
		// FS만 없고, FF는 있는 경우(이 경우에는 FF로 시작해야 한다.)
		else if(arr[1] == 0) {
			answer = arr[0];
		}
		// FF,FS가 둘다 존재하는 경우
		else {
			// FS가 SF보다 많은 경우
			if(arr[1] > arr[2]) {
				answer = arr[0] + arr[3] + arr[2]*2 + 1;
			} else {
				answer = arr[0] + arr[3] + arr[1]*2;
			}
		}
		System.out.println(answer);
	}

}

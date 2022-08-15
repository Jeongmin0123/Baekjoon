package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2877 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		// 10진수를 2진수로 바꿀 때와 유사한 방법으로 연산을 진행한다.
		
		while(N != 0) {
			// 끝자리 수부터 앞으로 가면서 2로 나누었을 때를 기준으로 4와 7중 선택한다.
			if(N%2 == 0) {
				sb.append("7");
			} else {
				sb.append("4");
			}
			// 2진수는 010 == 10 인 거와 다르게 474 != 74 이므로 이를 해결하기 위해 1을 빼준뒤에 2로 나누어준다
			N = (N-1)/2;
		}
		// 위 연산으로 숫자가 뒤부터 나오므로 이를 뒤집어준다.
		StringBuilder result = new StringBuilder();
		for(int i = sb.length() - 1 ; i >= 0 ; i--) {
			result.append(sb.charAt(i));
		}
		System.out.println(result);
	}
}
package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1790 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		// 1자리 수, 2자리 수, 3자리 수의 개수를 저장
		long count = 9;
		// 1자리 수, 2자리 수, 3자리 수 등 자리수를 저장
		long length = 1;
		// 찾을 숫자를 포함하는 숫자
		long containNumber = 0;
		while(K > count * length) {
			// i번째 자리수를 가지는 숫자의 개수와 그 숫자의 자리수를 곱해 빼준다
			K -= count * length;
			containNumber += count;
			// 자리수를 한자리 올려준다.
			count *= 10;
			length++;
		}
		
		containNumber += (K - 1)/length + 1;
		// 포함하고 있는 숫자가 N을 넘으면 불가능하므로 -1 출력
		if(containNumber > N) {
			System.out.println(-1);
		} else {
			// 포함하고 있는 숫자에서의 자리수를 구해서 값을 return한다.
			int index = (int) ((K-1)%length);
			System.out.println(String.valueOf(containNumber).charAt(index));
		}
	}

}

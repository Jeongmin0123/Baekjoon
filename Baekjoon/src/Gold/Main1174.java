package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main1174 {
	
	public static int[] nums = {9,8,7,6,5,4,3,2,1,0};
	public static ArrayList<Long> result = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		subset(0,0);
		// result set을 정렬한다.
		Collections.sort(result);
		// 0~9까지 총 10개의 숫자를 사용하거나 사용하지 않는 경우는 2^10=1024이다. 이때, 모두 사용하지 않는 경우는 빼야 하므로 1023가지의 숫자 배열을 만들 수 있다.
		if(N > 1023) {
			System.out.println(-1);
		} else {
			System.out.println(result.get(N-1));
		}
	}
	
	// 역순으로 정렬되어 있는 숫자들을 부분집합을 이용하여 사용하거나 사용하지 않는 방식으로 감소하는 숫자들을 만들어 준다.
	public static void subset(long sum, int idx) {
		// result set에 없는 감소하는 수열인 경우 result set에 더해준다.
		if(!result.contains(sum)) result.add(sum);
		// 모든 숫자를 다 고려한 경우, 연산을 종료한다.
		if(idx >= 10) return;
		// idx번째 숫자를 사용하여 감소하는 숫자를 만드는 경우
		subset(sum*10 + nums[idx], idx+1);
		// idx번째 숫자를 사용하지 않고 감소하는 숫자를 만드는 경우
		subset(sum, idx+1);
	}
}

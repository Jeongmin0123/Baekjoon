package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main17609 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String s = "";
		int result = 0;
		for(int i = 0 ; i < T ; i++) {
			s = br.readLine();
			result = check(s);
			
			// 36번 라인에서 +1을 해주었으므로 출력시 -1을 해준다.
			if(result >= 2) {
				System.out.println(result-1);
			} else {
				System.out.println(result);
			}
		}
	}
	public static int check(String s) {
		// 맨 앞자리와 끝자리의 값을 받아온다.
		int min = 0;
		int max = s.length() - 1;
		int result = 0;
		
		while(min <= max) {
			// 왼쪽 오른쪽 값이 같으면 왼쪽 오른쪽에 해당하는 index 값을 각각 1증가, 1감소 시킨다.
			if(s.charAt(min) == s.charAt(max)) {
				min++;
				max--;
			// 다른 경우 왼쪽만 +1, 또는 오른쪽만 -1 해준뒤에 다시 값을 비교해준다.
			} else {
				result++;
				int min2 = min;
				int max2 = max;
				min2++;
				while(min2 <= max2) {
					if(s.charAt(min2) == s.charAt(max2)) {
						min2++;
						max2--;
					} else {
						result++;
						break;
					}
				}
				min2 = min;
				max2 = max;
				max2--;
				while(min2 <= max2) {
					if(s.charAt(min2) == s.charAt(max2)) {
						min2++;
						max2--;
					} else {
						result++;
						break;
					}
				}
				return result;
			}
		}
		return result;
	}

}

package Gold;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1107 {
	public static void main(String[] args) {
		// 고장난 버튼들을 저장하는 ArrayList를 만든다.
		ArrayList<Integer> broken = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int T = sc.nextInt();
		for(int i = 0 ; i < T ; i++) {
			int k = sc.nextInt();
			broken.add(k);
		}
		// +,- 버튼으로 움직이는 경우
		int ans = Math.abs(N-100);
		// N이 500000까지이므로 6자리까지 가능하므로 가장 큰 6자리 숫자를 min로 설정한다.
		int min = 999999;
		// 숫자를 입력한 후 +,-로 움직였을 때 버튼을 누른 횟수
		int count = 0;
		for(int i = 0 ; i < 999999 ; i++) {
			boolean check = true;
			String temp = String.valueOf(i);
			for(int j = 0 ; j < temp.length() ; j++) {
				// temp.charAt은 char형태로 반환하므로 0을 빼준다
				if(broken.contains(temp.charAt(j)-'0')) {
					check = false;
					break;
				}
			}
			if(check == false) continue;
			// 숫자 누른횟수 + 누른 숫자에서 목적지까지 +,-로 갈 때 횟수
			count = temp.length() + Math.abs(i-N);
			if(count < min) {
				min = count;
			}
		}
		if(min < ans) {
			ans = min;
		}
		System.out.println(ans);
		sc.close();
	}
}

package Silver;

import java.util.Scanner;

public class Main1436 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 문장 안에 들어가 있어야 할 숫자가 666 이므로 answer 변수에 666을 저장한다.
		int answer = 666;
		int count = 0;
		// 입력받은 숫자까지  count가 올라갈 때까지 진행한다.
		while(count != N) {
			// 숫자 안에 666이 들어간 경우 count를 증가시킨다.
			if(check_666(answer)) {
				count++;
			}
			answer++;
		}
		System.out.println(answer-1);
		sc.close();
	}
	// 숫자에 666이 들어갔는지 안들어갔는지 판단하는 메서드
	public static boolean check_666(int n) {
		int count=0;
		// 6이 3개 들어가야지 while문을 종료한다.
		while(count != 3) {
			// 10으로 나눴을 때 나머지가 6인 경우 count를 증가시킨다.
			if(n%10 == 6) {
				count++;
			} else {
				count = 0;
			}
			// 밑 문장을 통해 연속으로 6이 3개인 경우만 true를 반환하게 한다.
			n = n/10;
			if(n==0) break;
		}
		if(count == 3) {
			return true;
		} else {
			return false;
		}
	}
}

package Silver;

import java.util.Scanner;

public class Main1065 {
	
	// 어떠한 숫자의 각 자리가 등차수열을 이루는 한수인지를 판별하기 위한 함수
	// 어떤 숫자가 한수일 경우 true를 아닐 경우 false를 반환한다.
	public static boolean func(int n) {
		if(n < 100) {
			// 100보다 작은 수는 무조건 한수이다.
			return true;
		}
		else {
			while((n/100) != 0) {
				/* (n/100) == 0 이 되면 n은 두 자리수가 된다.
				 * 하지만 각 자리수가 등차수열임을 계산을 통하여 판단하려면  최소 3자리수가 되어야 하므로 
				 * 더 이상 연산을 진행할 수 없으므로 while문을 종료한다.
				 */
				int result1 = (n/10)%10 - (n%10);	
				// n의 맨 뒤 두자리의 차를 구한다.
				n = (n/10);
				int result2 = (n/10)%10 - (n%10);
				// n의 뒤에서 2,3번째 자리의 차를 구한다.
				if((result1 != result2)) return false;
				// 만약 result1 과 result가 다르면 등차수열이 아니므로 false를 리턴값으로 가진다.
			}
			return true;
			// while문 내에서 return문을 만나지 않으면 그 수의 모든 자릿수는 등차수열이므로 한수이다.
			// 따라서 true 값을 반환한다.
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[] check = new boolean[N];
		// 1부터 N까지의 숫자에 대한 한수 판별여부를 저장하기 위한 배열을 만든다.
		int count = 0;
		for(int i = 0 ; i < check.length ; i++) {
			check[i] = func(i+1);
			// func을 통해 배열에 한수인지 아닌지의 여부를 저장한다.
			// 이때 배열의 자리에 대한 숫자는 0부터 시작하므로 더하기 1을 해준 뒤에 함수를 실행한다.
			if(check[i]) count++;
			// 만약 배열의 i번째 수가 한수라면 한수의 개수(count)를 증가시킨다.
		}
		System.out.println(count);
		sc.close();
	}
}























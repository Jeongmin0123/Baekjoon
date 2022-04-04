package Gold;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2023 {
	// 결과값을 저장하는 ArrayList를 만든다.
	public static ArrayList<Integer> results = new ArrayList<Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
     	prime_check(N,0,0);
     	for(int i : results) {
     		System.out.println(i);
     	}
     	sc.close();
	}
	// 입력받은 숫자가 소수인지 아닌지 판단하는 메서드
	public static boolean prime(int N) {
		if(N == 1) return false;
		if(N == 0) return false;
  	 	 	int sqrt = (int) Math.sqrt(N);
  	 	 	// 에라토스테네스의 체에 의해서 sqrt까지만 연산을 진행한다.
  	 	 	for(int i = 2 ; i <= sqrt ; i++) {
  	 	 		if((N % i) == 0) {
  	 	 		return false;
  	 	 		}
  	 	 	}
  	 	 	return true;
	}
	// N자리의 신기한 소수를 ArrayList에 저장하는 함수
	// 맨 앞자리부터 그 숫자가 소수이면 뒤에 숫자를 붙여나가는 방식으로 소수인지 아닌지
	// 계속 판단해준다. 이때 depth는 판단하고자 하는 숫자의 자리수, N은 우리가 원하는
	// 소수의 자리수이고, result는 판단을 할 때 그 숫자이다.
	public static void prime_check(int N, int depth, int result) {
		// 1자리 소수는 2,3,5,7이므로 그 숫자들을 ArrayList에 넣어준다.
		if(N == 1) {
			results.add(2);
			results.add(3);
			results.add(5);
			results.add(7);
			return;
		}
		// 구한 result가 N자리 자연수면서 소수인 경우 ArrayList에 추가하고 연산을 종료한다.
		if(N == depth) {
			results.add(result);
			return;
		}
		// 두 자리 이상의 자연수부터 0이 맨 뒷자리에 들어가면 소수가 될 수 없으므로 1부터 9까지
		// 연산을 진행한다.
		for(int i = 1 ; i <= 9 ; i++ ) {
			// result*10+i 가 소수인 경우, 원래 자리수인 depth에서 자리수를 하나 추가해주고
			// result*10 + i가 소수이거나 우리가 원하는 자릿수인지 판단하기 위하여 재귀함수를 불러준다.
			if(prime(result*10+i)) {
				prime_check(N, depth + 1, result*10 + i);
			}
		}
	}
}
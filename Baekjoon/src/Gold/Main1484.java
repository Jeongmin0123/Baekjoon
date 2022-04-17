package Gold;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main1484 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// a^2 - b^2 이 int의 범위를 벗어날 수 있으므로 Long 타입으로 선언한다.
		Long G = sc.nextLong();
		ArrayList<Long> divisor = div(G);
		ArrayList<Long> answer = new ArrayList<Long>();
		// 몸무게가 오름차순으로 출력되도록 약수들을 내림차순 정렬한다.
		Collections.sort(divisor, Collections.reverseOrder());
		
		// 현재 몸무게를 a, 기억하고 있는 몸무게를 b라고 두었을 때,
		// a^2 - b^2 = G 라는 식은 (a-b)(a+b) = G라고 둘 수 있으며, ----(1)
		// 이 때, 앞의 두 괄호에 대한 식 중에 하나를 k1, 나머지 하나를 k2라고 가정한다.
		for(int i = 0 ; i < divisor.size() ; i++) {
			Long k1 = divisor.get(i);
			Long k2 = G/k1;
			// (1)번 식을 정리하면 2a = k2+k1이라는 식을 얻을 수 있으므로 a가 존재하려면
			// (k2+k1)%2 == 0이여야 한다. 또한 G라는 숫자가 제곱수여서 k1과 k2가 같을 경우
			// b = 0이 되므로 그 경우도 제외해준다.
			if((k2+k1)%2 == 0 && k1 != k2) {
				answer.add((k1+k2)/2);
			}
		}
		if(answer.size() == 0) {
			System.out.println(-1);
		} else {
			for(int i = 0 ; i < answer.size() ; i++) {
				System.out.println(answer.get(i));
			}
		}
		sc.close();
	}
	// 숫자 G에 대한 약수들 중에 제곱근 G보다 작은 숫자들을 구한다.
	public static ArrayList<Long> div(Long G) {
		ArrayList<Long> result = new ArrayList<Long>();
		for(long i = 1 ; i <= Math.sqrt(G) ; i++) {
			if(G%i == 0) result.add(i);
		}
		return result;
	}
}
package Gold;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main1484 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// a^2 - b^2 �� int�� ������ ��� �� �����Ƿ� Long Ÿ������ �����Ѵ�.
		Long G = sc.nextLong();
		ArrayList<Long> divisor = div(G);
		ArrayList<Long> answer = new ArrayList<Long>();
		// �����԰� ������������ ��µǵ��� ������� �������� �����Ѵ�.
		Collections.sort(divisor, Collections.reverseOrder());
		
		// ���� �����Ը� a, ����ϰ� �ִ� �����Ը� b��� �ξ��� ��,
		// a^2 - b^2 = G ��� ���� (a-b)(a+b) = G��� �� �� ������, ----(1)
		// �� ��, ���� �� ��ȣ�� ���� �� �߿� �ϳ��� k1, ������ �ϳ��� k2��� �����Ѵ�.
		for(int i = 0 ; i < divisor.size() ; i++) {
			Long k1 = divisor.get(i);
			Long k2 = G/k1;
			// (1)�� ���� �����ϸ� 2a = k2+k1�̶�� ���� ���� �� �����Ƿ� a�� �����Ϸ���
			// (k2+k1)%2 == 0�̿��� �Ѵ�. ���� G��� ���ڰ� ���������� k1�� k2�� ���� ���
			// b = 0�� �ǹǷ� �� ��쵵 �������ش�.
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
	// ���� G�� ���� ����� �߿� ������ G���� ���� ���ڵ��� ���Ѵ�.
	public static ArrayList<Long> div(Long G) {
		ArrayList<Long> result = new ArrayList<Long>();
		for(long i = 1 ; i <= Math.sqrt(G) ; i++) {
			if(G%i == 0) result.add(i);
		}
		return result;
	}
}
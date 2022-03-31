package Silver;

import java.util.Scanner;

public class Main6588 {
	// ���ڰ� 1000000�����̹Ƿ� �Ʒ��� ���� boolean Ÿ���� �迭�� ������ش�.
	public static boolean[] prime = new boolean[1000001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// �迭�� ��� ���� ���Ͽ� �Ҽ����� �ƴ����� ���� ������� �־��ش�
		prime_check();
		while(true) {
			int a = sc.nextInt();
			if(a == 0) break;
			boolean result = false;
			// ���� �������� ������ �´ٸ�, ��� ������ �߰��� �������� �� ����
			// �߰������� ũ�� �� ���� �߰������� �����Ƿ� for���� ������ a/2������ �Ѵ�.
			for(int i = 3 ; i <= a/2 ; i+=2) {
				// i �� a-i�� ���� a �̹Ƿ� �� ���� prime�� ��� ������� ����ϰ�
				// �� �̻��� ������ �ʿ� �����Ƿ� for���� �����Ѵ�.
				if(!prime[i] && !prime[a-i]) {
					System.out.println(a+ " = "+ i +" + " + (a-i));
					result = true;
					break;
				}
			}
			if(!result) {
				System.out.println("Goldbach's conjecture is wrong.");
			}
		}
	}
	// �迭�� ������ �Ҽ����� �ƴ��� �Ǵ��Ͽ� ���� �־��ִ� �Խ�
	public static void prime_check() {
		prime[0] = prime[1] = true;
		// �����佺�׳׽��� ü�� �̿��Ѵ�.
		for(int i = 2 ; i <= Math.sqrt(1000000) ; i++) {
			if(!prime[i]) {
				for(int j = i*i ; j <= 1000000 ; j+= i) {
					prime[j] = true;
				}
			}         
		}
	}

}
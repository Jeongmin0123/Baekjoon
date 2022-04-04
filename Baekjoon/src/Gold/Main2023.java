package Gold;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2023 {
	// ������� �����ϴ� ArrayList�� �����.
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
	// �Է¹��� ���ڰ� �Ҽ����� �ƴ��� �Ǵ��ϴ� �޼���
	public static boolean prime(int N) {
		if(N == 1) return false;
		if(N == 0) return false;
  	 	 	int sqrt = (int) Math.sqrt(N);
  	 	 	// �����佺�׳׽��� ü�� ���ؼ� sqrt������ ������ �����Ѵ�.
  	 	 	for(int i = 2 ; i <= sqrt ; i++) {
  	 	 		if((N % i) == 0) {
  	 	 		return false;
  	 	 		}
  	 	 	}
  	 	 	return true;
	}
	// N�ڸ��� �ű��� �Ҽ��� ArrayList�� �����ϴ� �Լ�
	// �� ���ڸ����� �� ���ڰ� �Ҽ��̸� �ڿ� ���ڸ� �ٿ������� ������� �Ҽ����� �ƴ���
	// ��� �Ǵ����ش�. �̶� depth�� �Ǵ��ϰ��� �ϴ� ������ �ڸ���, N�� �츮�� ���ϴ�
	// �Ҽ��� �ڸ����̰�, result�� �Ǵ��� �� �� �� �����̴�.
	public static void prime_check(int N, int depth, int result) {
		// 1�ڸ� �Ҽ��� 2,3,5,7�̹Ƿ� �� ���ڵ��� ArrayList�� �־��ش�.
		if(N == 1) {
			results.add(2);
			results.add(3);
			results.add(5);
			results.add(7);
			return;
		}
		// ���� result�� N�ڸ� �ڿ����鼭 �Ҽ��� ��� ArrayList�� �߰��ϰ� ������ �����Ѵ�.
		if(N == depth) {
			results.add(result);
			return;
		}
		// �� �ڸ� �̻��� �ڿ������� 0�� �� ���ڸ��� ���� �Ҽ��� �� �� �����Ƿ� 1���� 9����
		// ������ �����Ѵ�.
		for(int i = 1 ; i <= 9 ; i++ ) {
			// result*10+i �� �Ҽ��� ���, ���� �ڸ����� depth���� �ڸ����� �ϳ� �߰����ְ�
			// result*10 + i�� �Ҽ��̰ų� �츮�� ���ϴ� �ڸ������� �Ǵ��ϱ� ���Ͽ� ����Լ��� �ҷ��ش�.
			if(prime(result*10+i)) {
				prime_check(N, depth + 1, result*10 + i);
			}
		}
	}
}
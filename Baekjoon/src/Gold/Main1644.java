package Gold;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1644 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// N���� ���� �Ҽ����� �޴´�.
		ArrayList<Integer> prime = prime(N);
		int result = check(N ,prime);
		System.out.println(result);
		sc.close();
		}
	
	// ���ӵ� �Ҽ��� ������ ��Ÿ�� �� �ִ� ����� ���� ���ϴ� �޼���
	public static int check(int N, ArrayList<Integer> prime) {
		int count = 0;
		// �Ҽ����� ù ��° ���ڸ� ArrayList�� i��° ���ڷ� �����Ѵ�.
		// ���� i�� 0���� ArrayList.size() - 1������ ������ �����Ѵ�.
		for(int i = 0 ; i < prime.size() ; i++) {
			// i��° ���ڰ� �Ҽ����� ù ��° ������ ������ ��쿡 ���ؼ�
			// ���ӵ� �Ҽ��� ������ ��Ÿ�� �� �ִ��� ������ �Ǵ��Ѵ�.
			int sum = 0;
			for(int j = i ; j < prime.size() ; j++) {
				sum += prime.get(j);
				// sum == N�̸� �Ҽ����� �����ϹǷ� count�� ������Ų��.
				if(sum == N) {
					count++;
					break;
				}
				// ���� sum > N�̸� ���̻� ����ϴ� ���� �ǹ̰� �����Ƿ� ������ �����Ѵ�.
				if(sum > N) {
					break;
				}
			}
		}
		return count;
	}
	// int N�� �־����� ��, N���� �۰ų� ���� �Ҽ����� ArrayList�� ��ȯ�ϴ� �޼���
	public static ArrayList<Integer> prime(int N) {
		ArrayList<Integer> list = new ArrayList<Integer>();		
		// 1�� �Ҽ��� �ƴϹǷ� 2���� �����Ѵ�.
		for(int i = 2 ; i <= N ; i++) {
			// i�� �Ҽ��� ��� list�� �߰��Ѵ�.
			boolean check = isPrime(i);
			if(check) {
				list.add(i);
			}
		}
		return list;
	}
	// ��� ���ڰ� �Ҽ����� �ƴ����� �Ǵ��ϴ� �޼���
	public static boolean isPrime(int num) {
		boolean result = true;
		// �����佺�׳׽��� ü�� ���Ͽ� Math.sqrt(num)������ �������� �ȴ�.
	    	for(int i = 2; i <= Math.sqrt(num); i++) {
	    		if(num%i == 0) {
	                result = false;
	                break; 	           
	            } else {
	                result = true;
	            }
	        }        
	    	return result;
	}
	
}

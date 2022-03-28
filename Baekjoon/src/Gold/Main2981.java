package Gold;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main2981 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] number = new long[N];
		for(int i = 0 ; i < N ; i++) {
			number[i] = sc.nextLong();
		}
		ArrayList<Long> result = list(number);
		// M�� �����ϴ� �����̾�� �ϹǷ� �������ش�.
		// �� ��, Arrays.sort�� ���� �ʴ� ������ Arrays.sort�� Long ��Ҵ�
		// ����� �� ���� �����̴�.
		Collections.sort(result);
		for(Long i : result) {
    	  System.out.print(i+" ");
		}
	}
	// �迭�� ���Ͽ� �������� ��� ���� �Ǵ� M�� ã�� �޼���
 	public static ArrayList<Long> list(long[] number) {
 		ArrayList<Long> result = new ArrayList<Long>();
 		// ��� ���� long�迭 array�� �����Ѵ�.
 		// ���� �ؾ��� number�� ù ��°�� �� ��° ���ڰ� ���� �۾����Ƿ� ���� �ӵ���
 		// ������ �� �� �ִ�.
 		Arrays.sort(number);
 		ArrayList<Long> check = common(number[0], number[1]);
 			// ù ��° ���ڿ� �� ��° ������ ���̿� ���� ����� ���ؼ� ������ �����ϸ�
 			// result�� �߰��Ѵ�.
	   		for(Long a : check) {
	   			boolean temp = true;
	   			for(int i = 1 ; i < number.length - 1 ; i++) {
	   				if(Math.abs(number[i+1] - number[i]) % a != 0) {
	   					temp = false;
	   				}
	   			}
	   			if(temp) {
	   				result.add(a);
	   			}
	   		}      
	   		return result;
 	}
 	// 1�� ������ �� ���� ���� ���� ����� ���ϴ� �޼���
 	public static ArrayList<Long> common(long a , long b) {
 		ArrayList<Long> result = new ArrayList<Long>();
 		// �����佺�׳׽��� ü�� �̿��Ͽ� i �� ������ �����Ѵ�.
 		for(long i = 1 ; i <= Math.sqrt(Math.abs(a-b)) ; i++) {
 			if(Math.abs(a-b) % i == 0) {
 				result.add(i);
 				if(Math.abs(a-b)/i != i) {
 					result.add(Math.abs(a-b)/i);
 				}
 			}
 			// M�� 1���� Ŀ�� �ϹǷ� ������ ����ִ� ����� 1�� �����Ѵ�.
 			result.remove(Long.valueOf(1));
 		}
 		return result;
 	}
}
package Gold;

import java.util.Arrays;
import java.util.Scanner;

public class Main1344 {
	
	public static boolean prime[] = new boolean[19];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		Arrays.fill(prime, false);
		prime();
		double result = percent(A,B);
		System.out.println(result);
	}
	// Ȯ�� A�� B�� �־����� ��, ��� �� ���� �Ҽ��� ������ Ȯ���� ���ϴ� �޼���
	public static double percent(int A, int B) {
		double per_A = ((double) A) / 100.0;
		double per_B = ((double) B) / 100.0;
		double result = 0.0;
		// ������� �̿��� ����
		for(int i = 0 ; i < prime.length ; i++) {
			for(int j = 0 ; j < prime.length ; j++) {
				// �Ѵ� �Ҽ������� ���Ͽ��� ���
				if(prime[i] && prime[j]) {
					// �� ���� Ȯ����, ���׺����� ���ؼ� 
					// (nCi*(per_A^i)*(1-per_A)^(18-i)) * (nCj*(per_B^j)*(1-per_B)^(18-j))�� �ȴ�.
					result += combination(prime.length-1,i)*(Math.pow(per_A, i)*Math.pow(1-per_A, 18-i))*
							combination(prime.length-1,j)*(Math.pow(per_B, j)*Math.pow(1-per_B, 18-j));
				}
			}
		}
		return 1D - result;
		
	}
	// 90���� 5�� �������� ��, 18��Ʈ�� �����Ƿ� 0~18���� �� �� �ִ�
	// ����, 0���� 18���� �Ҽ����� �Ǵ��ϴ� �޼���
	public static void prime() {
		prime[0] = true;
		prime[1] = true;
		for(int i=2; i*i<prime.length; i++){
        	// prime[i]�� �Ҽ����
            if(!prime[i]){
            	// prime[j] �Ҽ��� �ƴ� ǥ��
            	for(int j=i*i; j<prime.length; j+=i) {
            		prime[j] = true;                
            	}
            }        
        }
	}
	// �Ľ�Į �ﰢ���� �̿��� nCr�� ���ϴ� �޼���
	public static int combination(int n, int r) {
		if(n == r || r == 0) 
			return 1; 
		else 
			return combination(n - 1, r - 1) + combination(n - 1, r); 
	}

}

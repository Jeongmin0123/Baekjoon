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
	// 확률 A와 B가 주어졌을 때, 적어도 한 팀이 소수로 득점할 확률을 구하는 메서드
	public static double percent(int A, int B) {
		double per_A = ((double) A) / 100.0;
		double per_B = ((double) B) / 100.0;
		double result = 0.0;
		// 여사건을 이용할 예정
		for(int i = 0 ; i < prime.length ; i++) {
			for(int j = 0 ; j < prime.length ; j++) {
				// 둘다 소수득점을 못하였을 경우
				if(prime[i] && prime[j]) {
					// 이 때의 확률은, 이항분포에 의해서 
					// (nCi*(per_A^i)*(1-per_A)^(18-i)) * (nCj*(per_B^j)*(1-per_B)^(18-j))가 된다.
					result += combination(prime.length-1,i)*(Math.pow(per_A, i)*Math.pow(1-per_A, 18-i))*
							combination(prime.length-1,j)*(Math.pow(per_B, j)*Math.pow(1-per_B, 18-j));
				}
			}
		}
		return 1D - result;
		
	}
	// 90분을 5로 나누었을 때, 18파트로 나뉘므로 0~18골이 들어갈 수 있다
	// 따라서, 0부터 18까지 소수인지 판단하는 메서드
	public static void prime() {
		prime[0] = true;
		prime[1] = true;
		for(int i=2; i*i<prime.length; i++){
        	// prime[i]가 소수라면
            if(!prime[i]){
            	// prime[j] 소수가 아닌 표시
            	for(int j=i*i; j<prime.length; j+=i) {
            		prime[j] = true;                
            	}
            }        
        }
	}
	// 파스칼 삼각형을 이용한 nCr을 구하는 메서드
	public static int combination(int n, int r) {
		if(n == r || r == 0) 
			return 1; 
		else 
			return combination(n - 1, r - 1) + combination(n - 1, r); 
	}

}

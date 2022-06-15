package Silver;

import java.util.Scanner;

public class Main1929 {
	
	public static boolean[] prime;
	public static int M,N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		prime = new boolean[N+1];
		prime[0] = true;
		prime[1] = true;
		check();
		for(int i = M ; i <= N ; i++) {
			if(!prime[i]) {
				System.out.println(i);
			}
		}
	}
	
	// 에라토스테네스의 체
	public static void check() {
		for(int i = 2 ; i*i <= N ; i++) {
			if(!prime[i]) {
				for(int j = i*i ; j <= N ; j += i) {
					prime[j] = true;
				}
			}
		}
	}

}

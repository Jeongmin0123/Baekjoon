package Silver;

import java.util.Scanner;

public class Main2581 {

	public static boolean[] prime = new boolean[10001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		prime_check();
		int sum = 0;
		int min = 20000;
		for(int i = M ; i <= N ; i++) {
			if(!prime[i]) {
				sum += i;
				min = Math.min(i, min);
			}
		}
		if(min == 20000) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
	public static void prime_check() {
		prime[0] = true;
		prime[1] = true;
		for(int i=2; i*i<=10000; i++){
            if(!prime[i]){
            	for(int j=i*i; j<=10000; j+=i) {
            		prime[j] = true;                
            	}
            }        
        } 
	}
}

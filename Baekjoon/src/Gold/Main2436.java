package Gold;

import java.util.Scanner;

public class Main2436 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int[] result = find(A,B);
		System.out.println(result[0] + " " + result[1]);
	}
	public static int[] find(int A, int B) {
		int[] result = new int[2];
		int temp = B/A;
		for(int i = 2 ; i <= Math.sqrt(temp) ; i++) {
			if(temp%i != 0) continue;
			if(gcd(i,temp/i) == 1) {
				result[0] = i*A;
				result[1] = (temp/i)*A;
			}
		}
		return result;
	}
	public static int gcd(int a, int b) {
		int result = 1;
		for(int i = 1 ; i <= Math.min(a, b) ;i++) {
			if(a % i == 0 && b % i == 0) {
				result = i;
			}
		}
		return result;
	}
}

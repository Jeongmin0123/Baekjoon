package Gold;

import java.util.*;
import java.io.*;

public class Main17425 {
	// 숫자의 범위가 100000까지이므로 배열의 범위를 100001까지로 지정한다.
	// 이 때, prime_sum[i]는 i의 약수들의 합을 저장하고
	// sum[i]는 i까지의 prime_sum들의 합을 저장한다.
	public static long[] prime_sum = new long[100001];
	public static long[] sum = new long[100001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		divisor_sum();
		int t = Integer.parseInt(bf.readLine());
		while(t--> 0) { 
			int n = Integer.parseInt(bf.readLine());
			bw.write(sum[n]+"\n"); 
		}
		bw.flush();
	}
	// 각각의 숫자에 대한 약수들의 합과 그 숫자까지 약수들의 합을 반환하는 메서드
	// 약수와 배수는 상관관계에 있으므로 이를 이용한다.
	// 예를 들어, 4는 2의 배수이고, 6 또한 2의 배수이다. 그렇다면 4와 6은 2를 약수로 가지므로
	// 2를 약수의 합에 더해준다. 이러한 방식을 계속하면 배수의 합을 구할 수 있다.
	public static void divisor_sum() {
		// 0의 약수는 없으므로 0으로 고정한다.
		prime_sum[0] = 0;
		// 모든 숫자는 1을 약수로 가지므로 약수의 합의 시작을 1로 다 고정한다.
		for(int i = 1 ; i < prime_sum.length ; i++) {
			prime_sum[i] = 1;
		}
		// 2부터 100000까지 2의 배수, 3의 배수, 4의 배수.... 에 대하여 2,3,4....를 약수로 가지므로
		// 약수의 합에 가각을 더해준다.
		for(int i = 2 ; i < prime_sum.length ; i++) {
			for(int j = 1 ; i * j < prime_sum.length ; j++) {
				prime_sum[i*j] += i;
			}
		}
		sum[0] = 0;
		// 1~i까지의 숫자들의 약수의 합의 합은 i-1까지의 합에 i번째 숫자의 약수의 합을 더한것과 같다.
		for(int i = 1 ; i < sum.length ; i++) {
			sum[i] = sum[i-1] + prime_sum[i];
		}
	}
}

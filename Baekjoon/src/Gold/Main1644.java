package Gold;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1644 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// N보다 작은 소수들을 받는다.
		ArrayList<Integer> prime = prime(N);
		int result = check(N ,prime);
		System.out.println(result);
		sc.close();
		}
	
	// 연속된 소수의 합으로 나타낼 수 있는 경우의 수를 구하는 메서드
	public static int check(int N, ArrayList<Integer> prime) {
		int count = 0;
		// 소수합의 첫 번째 숫자를 ArrayList의 i번째 숫자로 정의한다.
		// 이후 i를 0부터 ArrayList.size() - 1까지의 범위로 지정한다.
		for(int i = 0 ; i < prime.size() ; i++) {
			// i번째 숫자가 소수합의 첫 번째 숫자인 각각의 경우에 대해서
			// 연속된 소수의 합으로 나타낼 수 있는지 없는지 판단한다.
			int sum = 0;
			for(int j = i ; j < prime.size() ; j++) {
				sum += prime.get(j);
				// sum == N이면 소수합이 가능하므로 count를 증가시킨다.
				if(sum == N) {
					count++;
					break;
				}
				// 만약 sum > N이면 더이상 계산하는 것이 의미가 없으므로 연산을 종료한다.
				if(sum > N) {
					break;
				}
			}
		}
		return count;
	}
	// int N이 주어졌을 때, N보다 작거나 같은 소수들의 ArrayList를 반환하는 메서드
	public static ArrayList<Integer> prime(int N) {
		ArrayList<Integer> list = new ArrayList<Integer>();		
		// 1은 소수가 아니므로 2부터 진행한다.
		for(int i = 2 ; i <= N ; i++) {
			// i가 소수인 경우 list에 추가한다.
			boolean check = isPrime(i);
			if(check) {
				list.add(i);
			}
		}
		return list;
	}
	// 어떠한 숫자가 소수인지 아닌지를 판단하는 메서드
	public static boolean isPrime(int num) {
		boolean result = true;
		// 에라토스테네스의 체로 인하여 Math.sqrt(num)까지만 나눠보면 된다.
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

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
		// M은 증가하는 순서이어야 하므로 정렬해준다.
		// 이 때, Arrays.sort를 쓰지 않는 이유는 Arrays.sort는 Long 요소는
		// 계산할 수 없기 때문이다.
		Collections.sort(result);
		for(Long i : result) {
    	  System.out.print(i+" ");
		}
	}
	// 배열에 대하여 나머지가 모두 같게 되는 M을 찾는 메서드
 	public static ArrayList<Long> list(long[] number) {
 		ArrayList<Long> result = new ArrayList<Long>();
 		// 계산 전에 long배열 array를 정렬한다.
 		// 정렬 해야지 number의 첫 번째와 두 번째 숫자가 가장 작아지므로 연산 속도를
 		// 빠르게 할 수 있다.
 		Arrays.sort(number);
 		ArrayList<Long> check = common(number[0], number[1]);
 			// 첫 번째 숫자와 두 번째 숫자의 차이에 대한 약수에 대해서 조건을 만족하면
 			// result에 추가한다.
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
 	// 1을 제외한 두 수의 차에 대한 약수를 구하는 메서드
 	public static ArrayList<Long> common(long a , long b) {
 		ArrayList<Long> result = new ArrayList<Long>();
 		// 에라토스테네스의 체를 이용하여 i 의 범위를 지정한다.
 		for(long i = 1 ; i <= Math.sqrt(Math.abs(a-b)) ; i++) {
 			if(Math.abs(a-b) % i == 0) {
 				result.add(i);
 				if(Math.abs(a-b)/i != i) {
 					result.add(Math.abs(a-b)/i);
 				}
 			}
 			// M은 1보다 커야 하므로 무조건 들어있는 약수인 1을 제거한다.
 			result.remove(Long.valueOf(1));
 		}
 		return result;
 	}
}
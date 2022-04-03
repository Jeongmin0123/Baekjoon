package Silver;

import java.util.Scanner;

public class Main2502 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int D = sc.nextInt();
		int K = sc.nextInt();
		// 첫번째 항을 a, 두번째 항을 b라고 가정했을 때,
		// [i][0] 은 i번째 항의 a의 개수를 알려주고
		// [i][1] 은 i번째 항의 b의 개수를 알려준다.
		String[][] arr= new String[D][2];
		// 배열에서 0번째 항의 a의 개수는 한개, 1번째 항의 b의 개수도 1개이기
		// 때문에 배열의 초기값을 아래와 같이 설정한다.
		arr[0][0] = "a";
		arr[0][1] = "";
		arr[1][0] = "";
		arr[1][1] = "b";
		// 피보나치 수열의 정의에 의해 각각의 배열에 숫자를 넣어준다.
		for(int i = 2 ; i < D ; i++) {
			arr[i][0] = arr[i-1][0] + arr[i-2][0];
			arr[i][1] = arr[i-1][1] + arr[i-2][1];
		}
		// 맨마지막 항의 a,b의 갯수를 숫자로 변환한다.
		int a = countChar(arr[D-1][0], 'a');
		int b = countChar(arr[D-1][1], 'b');
		// 결국 맨 마지막 항의 a,b 의 갯수에 각각 자연수배 해줘서 그 합이
		// K와 같을 때가 결과값이므로 그것을 위한 알고리즘을 작성하면 된다.
		for(int i = 1 ; i < K/a ; i++) {
			for(int j = 1 ; j < K/b ; j++) {
				if(a*i + b*j == K) {
					System.out.println(i);
					System.out.println(j);
					System.exit(0);
				}
			}
		}
	}
	//어떠한 문자열에서 특정 문자의 갯수를 반환하는 메서드
	public static int countChar(String str, char ch) {
		return str.length() - str.replace(String.valueOf(ch), "").length();
	}
	
}

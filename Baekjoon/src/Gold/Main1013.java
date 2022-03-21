package Gold;

import java.util.Scanner;

public class Main1013 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String[] results = new String[T];
		for(int i = 0 ; i < T ; i++) {
			String check = sc.next();
			// 시작 상태를 A로 지정한다.
			char state = 'A';
			// 모든 숫자에 대하여 그 숫자와 상태를 입력받으면 상태를 반환하는 함수를 실행한다.
			for(int j = 0 ; j < check.length() ; j++) {
				char ch = check.charAt(j);
				state = check(state, ch);
				// 상태가 X인 경우에는 옳지 않은 경우이므로 계산을 더 할필요 없이 계산을 중단한다.
				if(state =='X') break;
			}
			// A, F, G 경우로 연산이 끝난 경우에만 원하는 패턴을 지닌 전파이다.
			if(state =='A' || state =='F' || state =='G') {
				results[i] = "YES";
			} else {
				results[i] = "NO";
			}
		}
		for(int i = 0 ; i < T ; i++) {
			System.out.println(results[i]);
		}
		sc.close();
	}
	// 상태와 숫자를 입력받아 상태를 return 해주는 함수
	public static char check(char state, char ch) {
		if(ch == '0') {
			switch(state) {
			case 'A' : return 'B';
			case 'C' : return 'D';
			case 'D' : return 'E';
			case 'E' : return 'E';
			case 'F' : return 'B';
			case 'G' : return 'H';
			case 'H' : return 'E';
			}
		}
		if(ch == '1') {
			switch(state) {
			case 'A' : return 'C';
			case 'B' : return 'A';
			case 'E' : return 'F';
			case 'F' : return 'G';
			case 'G' : return 'G';
			case 'H' : return 'A';
			}
		}
		return 'X';
	}
}
	// 1001 뒤에 1이 무한히 반복되는 경우를 연산할 수 없기 때문에 오류가 난 함수
	/*for(int i = 0 ; i < T ; i++) {
		String check = sc.next();
		if(check.contains("100")) {
			check = check.replace("100", "a");
			while(true) {
				if(check.contains("a1")) {
					check = check.replace("a1", "b");
				} else if (check.contains("a0")) {
					check = check.replace("a0", "a");
				} else {
					break;
				}
			}
		}
		if(check.contains("01")) {
			check = check.replace("01", "b");
		}
		check = check.replace("b", "");
		if(check.contains("1") || check.contains("2") || check.contains("a")) {
			results[i] = "NO";
		} else {
			results[i] = "YES";
		}
	}
	for(int i = 0 ; i < T ; i++) {
			System.out.println(results[i]);
		}
	*/

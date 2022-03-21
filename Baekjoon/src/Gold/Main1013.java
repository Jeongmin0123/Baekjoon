package Gold;

import java.util.Scanner;

public class Main1013 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String[] results = new String[T];
		for(int i = 0 ; i < T ; i++) {
			String check = sc.next();
			// ���� ���¸� A�� �����Ѵ�.
			char state = 'A';
			// ��� ���ڿ� ���Ͽ� �� ���ڿ� ���¸� �Է¹����� ���¸� ��ȯ�ϴ� �Լ��� �����Ѵ�.
			for(int j = 0 ; j < check.length() ; j++) {
				char ch = check.charAt(j);
				state = check(state, ch);
				// ���°� X�� ��쿡�� ���� ���� ����̹Ƿ� ����� �� ���ʿ� ���� ����� �ߴ��Ѵ�.
				if(state =='X') break;
			}
			// A, F, G ���� ������ ���� ��쿡�� ���ϴ� ������ ���� �����̴�.
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
	// ���¿� ���ڸ� �Է¹޾� ���¸� return ���ִ� �Լ�
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
	// 1001 �ڿ� 1�� ������ �ݺ��Ǵ� ��츦 ������ �� ���� ������ ������ �� �Լ�
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

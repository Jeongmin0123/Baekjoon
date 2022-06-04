package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1759 {
	public static char list[];
	public static char code[];
	public static int L;
	public static int C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		list = new char[C];
		code = new char[L];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < C ; i++) {
			list[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(list);
		make_code(0,0);
	}
	
	// 길이에 맞는 문자열을 만드는 메서드
	// x는 주어진 문자열에서 암호에 들어갈 문자의 위치
	// idx는 들어갈 문자열의 암호에서의 위치
	public static void make_code(int x, int idx) {
		// 원하는 암호의 길이까지 문자를 넣어주면 그 암호가 모음 1개, 자음 2개 이상을 포함하는지 확인한다.
		if(idx == L) {
			if(check()) {
				System.out.println(code);
			}
			return;
		}
		for(int i = x ; i < C ; i++) {
			code[idx] = list[i];
			make_code(i+1,idx+1);
		}
	}
	
	// 모음 1개, 자음 2개 이상을 포함하는지 확인하는 메서드
	public static boolean check() {
		int consonant = 0;
		int vowel = 0;
		for(char x : code) {
			if(x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
				vowel++;
			} else {
				consonant++;
			}
		}
		if(consonant >= 2 && vowel >= 1) {
			return true;
		} else {
			return false;
		}
	}

}

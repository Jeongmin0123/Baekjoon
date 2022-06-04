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
	
	// ���̿� �´� ���ڿ��� ����� �޼���
	// x�� �־��� ���ڿ����� ��ȣ�� �� ������ ��ġ
	// idx�� �� ���ڿ��� ��ȣ������ ��ġ
	public static void make_code(int x, int idx) {
		// ���ϴ� ��ȣ�� ���̱��� ���ڸ� �־��ָ� �� ��ȣ�� ���� 1��, ���� 2�� �̻��� �����ϴ��� Ȯ���Ѵ�.
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
	
	// ���� 1��, ���� 2�� �̻��� �����ϴ��� Ȯ���ϴ� �޼���
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

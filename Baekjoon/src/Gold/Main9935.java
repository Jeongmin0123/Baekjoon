package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main9935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// ���� ���ڿ�
		String answer = br.readLine();
		// ���� ���ڿ�
		String bomb = br.readLine();
		
		Stack<Character> check = new Stack<Character>();
		
		// ���ڿ��� �ϳ��� stack�� �־��ش�.
		for(int i = 0 ; i < answer.length() ; i++) {
			check.push(answer.charAt(i));
			// stack�� �� ���ڿ��� ��ź ���ڿ����� �� ��� ������ ����������.
			if(check.size() >= bomb.length()) {
				boolean flag = true;
				// �ڿ��� bomb.length()������ ���ڰ� bomb�� ������ �� ���ڿ��� ���Ľ�Ų��.
				for(int j = 0 ; j < bomb.length() ; j++) {
					if(check.get(check.size() - bomb.length() + j) != bomb.charAt(j)) {
						flag = false;
						break;
					}
				}
				if(flag) {
					for(int j = 0 ; j < bomb.length() ; j++) {
						check.pop();
					}
				}
			}
		}
		// ���ڿ��� �� ���ĵ� ��� FRULA, �ƴ� ��� ���� ���ڿ��� ����Ѵ�.
		StringBuilder sb = new StringBuilder();
		if(check.size() == 0) {
			System.out.println("FRULA");
		}
		for(int i = 0 ; i < check.size() ; i++) {
			sb.append(check.get(i));
		}
		System.out.println(sb);
	}
}
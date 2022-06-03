package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main9935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 받은 문자열
		String answer = br.readLine();
		// 폭발 문자열
		String bomb = br.readLine();
		
		Stack<Character> check = new Stack<Character>();
		
		// 문자열을 하나씩 stack에 넣어준다.
		for(int i = 0 ; i < answer.length() ; i++) {
			check.push(answer.charAt(i));
			// stack에 들어간 문자열이 폭탄 문자열보다 긴 경우 폭발이 가능해진다.
			if(check.size() >= bomb.length()) {
				boolean flag = true;
				// 뒤에서 bomb.length()까지의 문자가 bomb과 같으면 그 문자열을 폭파시킨다.
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
		// 문자열이 다 폭파된 경우 FRULA, 아닌 경우 남은 문자열을 출력한다.
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
package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main4949 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String temp = br.readLine();
			Stack<Character> check = new Stack<>();
			if(temp.equals(".")) break;
			for(int i = 0 ; i < temp.length() ; i++) {
				char c = temp.charAt(i);
				if(c == '(' || c == '[') {
					check.push(c);
				} else if(c == ')') {
					if(check.isEmpty() || check.peek() != '(') {
						check.push(c);
						break;
					} else {
						check.pop();
					}
				} else if(c == ']') {
					if(check.isEmpty() || check.peek() != '[') {
						check.push(c);
						break;
					} else {
						check.pop();
					}
				}
			}
			if(check.isEmpty()) {
				sb.append("yes").append("\n");
			} else {
				sb.append("no").append("\n");
			}
		}
		System.out.println(sb);
	}

}

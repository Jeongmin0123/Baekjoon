package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main1662 {

	public static void main(String[] args) throws IOException {
		Stack<String> stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split("");
		for(int i = 0 ; i < s.length ; i++) {
			// )가 나오기 전까지 스택에 문자들을 넣어준다.
			if(!s[i].equals(")")) {
				stack.push(s[i]);
			// )를 만나는 경우
			} else {
				int cnt = 0;
				// (를 만나기 전까지의 길이를 구한다.
				while(!stack.peek().equals("(")) {
					String temp = stack.pop();
					// 만약 뒤에 *가 붙어있는 경우에는 그 String 자체를 길이로 봐줘야 하기 때문에
					// 뽑아서 그 숫자만큼을 길이로 더해준다.
					if(temp.equals("*")) {
						int len = Integer.parseInt(stack.pop());
						cnt += len;
					// 위 경우와 다르면 어떠한 숫자든 길이가 1이다.
					} else {
						cnt++;
					}
				}
				// (제거
				stack.pop();
				// ( 앞 반복횟수 구하기
				int mul = Integer.parseInt(stack.pop());
				// 그 뒤까지 숫자 길이를 반복횟수만큼 곱해준다.
				cnt *= mul;
				// 나온 결과값을 숫자라고 알려주기 위해 String으로 넣은 뒤에 *을 붙여준다.
				stack.push(String.valueOf(cnt));
				stack.push("*");
			}
		}
		int ans = 0;
		while(!stack.isEmpty()) {
			if(stack.peek().equals("*")) {
				stack.pop();
				ans += Integer.parseInt(stack.pop());
			} else {
				stack.pop();
				ans++;
			}
		}
		System.out.println(ans);
	}
	
	/*public static void main(String[] args) throws IOException {
		Stack<Character> zip = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		for(int i = 0 ; i < s.length() ; i++) {
			// 받아온 문자열을 하나씩 스택에 저장해준다.
			if(s.charAt(i) == ')') {
				zip.push(s.charAt(i));
			} else {
				// 만약 넣어주는 값이 )라면, 연산을 시작한다.
				
				String temp = "";
				while(true) {
					char temp2 = zip.pop();
					temp = temp2 + temp;
					if(temp2 == '(') {
						temp = zip.pop() + temp;
						break;
					}
				}
				int count = temp.charAt(0) - '0';
				temp = temp.substring(2,temp.length()-1);
				String result = "";
				for(int j = 0 ; j < count ; j++) {
					result += temp;
				}
				for(int j = 0 ; j < result.length() ; j++) {
					zip.add(result.charAt(j));
				}
			}
		}
		String result = "";
		while(zip.size() > 0) {
			result += zip.pop();
		}
		System.out.println(result.length());
	}*/

}

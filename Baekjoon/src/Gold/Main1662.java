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
			// )�� ������ ������ ���ÿ� ���ڵ��� �־��ش�.
			if(!s[i].equals(")")) {
				stack.push(s[i]);
			// )�� ������ ���
			} else {
				int cnt = 0;
				// (�� ������ �������� ���̸� ���Ѵ�.
				while(!stack.peek().equals("(")) {
					String temp = stack.pop();
					// ���� �ڿ� *�� �پ��ִ� ��쿡�� �� String ��ü�� ���̷� ����� �ϱ� ������
					// �̾Ƽ� �� ���ڸ�ŭ�� ���̷� �����ش�.
					if(temp.equals("*")) {
						int len = Integer.parseInt(stack.pop());
						cnt += len;
					// �� ���� �ٸ��� ��� ���ڵ� ���̰� 1�̴�.
					} else {
						cnt++;
					}
				}
				// (����
				stack.pop();
				// ( �� �ݺ�Ƚ�� ���ϱ�
				int mul = Integer.parseInt(stack.pop());
				// �� �ڱ��� ���� ���̸� �ݺ�Ƚ����ŭ �����ش�.
				cnt *= mul;
				// ���� ������� ���ڶ�� �˷��ֱ� ���� String���� ���� �ڿ� *�� �ٿ��ش�.
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
			// �޾ƿ� ���ڿ��� �ϳ��� ���ÿ� �������ش�.
			if(s.charAt(i) == ')') {
				zip.push(s.charAt(i));
			} else {
				// ���� �־��ִ� ���� )���, ������ �����Ѵ�.
				
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

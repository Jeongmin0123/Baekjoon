package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main12904 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer input = new StringBuffer(br.readLine());
		StringBuffer goal = new StringBuffer(br.readLine());
		while(input.length() < goal.length()) {
			// �� ���ڿ��� A�� ���
			if(goal.charAt(goal.length()-1) == 'A') {
				goal.deleteCharAt(goal.length()-1);
			// �� ���ڿ��� B�� ���
			} else if(goal.charAt(goal.length()-1) == 'B') {
				goal.deleteCharAt(goal.length()-1);
				goal.reverse();
			} else {
				break;
			}
		}
		if(input.toString().equals(goal.toString())) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

}

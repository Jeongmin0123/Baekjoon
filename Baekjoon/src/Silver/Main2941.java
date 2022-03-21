package Silver;

import java.util.Scanner;

public class Main2941 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		String text = sc.next();
		System.out.println(check(text));
	}
	
	public static int check(String s) {
		int num = s.length();
		for(int i = 0 ; i < s.length() - 1 ; i++) {
			String temp1 = s.substring(i, i+2);
			if(temp1.equals("c=") || temp1.equals("c-") || temp1.equals("d-") || temp1.equals("lj") ||
					temp1.equals("nj") || temp1.equals("s=") || temp1.equals("z=")) {
				num--;
			}
		}
		for(int i = 0 ; i < s.length() - 2 ; i++) {
			String temp2 = s.substring(i, i+3);
			if(temp2.equals("dz=")) num = num - 1;
		}
		return num;
	}
}

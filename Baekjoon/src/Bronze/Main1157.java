package Bronze;

import java.util.Scanner;

public class Main1157 {

	public static void main(String[] args) {
		int[] num = new int[26];
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		
		int max = -1;
		char ch = '?';
		for(int i = 0 ; i< word.length() ; i++) {
			if('A' <= word.charAt(i) && word.charAt(i) <= 'Z') {
				num[word.charAt(i)-'A']++;
			} else {
				num[word.charAt(i)-'a']++;
			}
		}
		
		for(int i = 0 ; i < num.length ; i++) {
			if(num[i] > max) {
				max = num[i];
				ch = (char)(i+65);
			}
			else if(num[i] == max) {
				ch ='?';
			}
		}
		System.out.println(ch);
		sc.close();
	}
}

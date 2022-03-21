package Gold;

import java.util.Scanner;

public class Main1062 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		String[] word = new String[N];
		for(int i = 0 ; i < N ; i++) {
			word[i] = sc.next();
		}
		int count = 0;
		for(int i = 0 ; i < N ; i++) {
			if(check(word[i], K)) count++;
		}
		System.out.println(count);
		
	}
	public static void count(String[] word, int[] count, int K) {
		for(int i = 0 ; i < word.length ; i++) {
			for(int j = 0 ; j < word[i].length() ; j++) {
				count[word[i].charAt(j) - 'a']++;
			}
		}
	}
	public static boolean check(String word, int K) {
		if(K < 4) return false;
		word = word.replace("a", "");
		word = word.replace("n", "");
		word = word.replace("t", "");
		word = word.replace("i", "");
		word = word.replace("c", "");
		
		String answer = "";
		for(int i = 0 ; i < word.length() ; i++) {
			if(word.indexOf(word.charAt(i)) == i) answer += word.charAt(i);
		}
		if(answer.length() <= K - 5) {
			return true;
		} else {
			return false;
		}
	}

}

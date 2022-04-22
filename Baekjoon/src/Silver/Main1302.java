package Silver;

import java.util.HashMap;
import java.util.Scanner;

public class Main1302 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 단어당 나오는 횟수를 알아야 하기 때문에 중복을 피하기 위해서 Hashmap을 사용한다.
		// 단어장과 그 단어의 나온 횟수라고 생각하면 편하다.
		HashMap<String, Integer> word = new HashMap<>();
		for(int i = 0 ; i < N ; i++) {
			String temp = sc.next();
			// 만약 새로운 단어라면 새 단어를 단어장에 넣고 나온 횟수를 1로 지정한다.
			if(word.get(temp) == null) {
				word.put(temp, 1);
			// 단어장에 이미 존재하면 그 단어의 나온 횟수를 1 증가시킨다.
			} else {
				word.put(temp, word.get(temp)+1);
			}
		}
		int max = 0;
		String answer = "";
		// 가장 많이 나온 단어를 찾는다.
		for(String key : word.keySet()) {
			if(max == word.get(key)) {
				if(answer.compareTo(key) > 0) {
					answer = key;
				}
			} else if(max < word.get(key)) {
				max = word.get(key);
				answer = key;
			}
		}
		System.out.println(answer);
		sc.close();
	}

}

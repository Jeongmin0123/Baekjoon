package Silver;

import java.util.HashMap;
import java.util.Scanner;

public class Main1302 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// �ܾ�� ������ Ƚ���� �˾ƾ� �ϱ� ������ �ߺ��� ���ϱ� ���ؼ� Hashmap�� ����Ѵ�.
		// �ܾ���� �� �ܾ��� ���� Ƚ����� �����ϸ� ���ϴ�.
		HashMap<String, Integer> word = new HashMap<>();
		for(int i = 0 ; i < N ; i++) {
			String temp = sc.next();
			// ���� ���ο� �ܾ��� �� �ܾ �ܾ��忡 �ְ� ���� Ƚ���� 1�� �����Ѵ�.
			if(word.get(temp) == null) {
				word.put(temp, 1);
			// �ܾ��忡 �̹� �����ϸ� �� �ܾ��� ���� Ƚ���� 1 ������Ų��.
			} else {
				word.put(temp, word.get(temp)+1);
			}
		}
		int max = 0;
		String answer = "";
		// ���� ���� ���� �ܾ ã�´�.
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

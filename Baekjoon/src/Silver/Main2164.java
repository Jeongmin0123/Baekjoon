package Silver;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main2164 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Deque<Integer> card = new ArrayDeque<>();
		for(int i = 1 ; i <= N ; i++) {
			card.addFirst(i);
		}
		while(card.size() != 1) {
			card.removeLast();
			int temp = card.removeLast();
			card.addFirst(temp);
		}
		System.out.println(card.removeLast());
	}
}
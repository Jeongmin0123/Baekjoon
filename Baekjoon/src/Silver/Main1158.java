package Silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1158 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1 ; i <= N ; i++) {
			queue.add(i);
		}
		System.out.print("<");
		while(!queue.isEmpty()) {
			for(int i = 0 ; i < K ; i++) {
				if(i == K-1) {
					int a = queue.remove();
					if(queue.size() == 0) {
						System.out.print(a);
					} else {
						System.out.print(a+", ");
					}
				} else {
					queue.add(queue.remove());
				}
			}
		}
		System.out.println(">");
	}

}

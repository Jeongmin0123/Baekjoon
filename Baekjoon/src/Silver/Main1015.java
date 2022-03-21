package Silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main1015 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for(int i = 0 ; i < N ; i++) {
			A[i] = sc.nextInt();
		}
		int[] result = sort(A);
		for(int i = 0 ; i < N ; i++) {
			System.out.println(result[i]);
		}
	}
	// ���İ��� int�迭�� ��ȯ���ִ� �Լ�
	public static int[] sort(int[] N) {
		// ������� �޾ƿ� �迭�� �������ش�.
		int[] result = new int[N.length];
		// ������ N�迭�� j��° �׿� �湮�� �ߴ��� �˷��ִ� �迭�� �����Ѵ�.
		boolean[] visited = new boolean[N.length];
		// result[i]�� N[i] ���� ��� �־��ش�.
		for(int i = 0 ; i < N.length ; i++) {
			result[i] = N[i];
		}
		// N �迭�� �������ش�.
		Arrays.sort(N);
		// ���� result �迭�� i��° �װ� N �迭�� j��° ���� ���� j��° ���� �湮���� ���� ���
		// j�� result[i]�� ������ �Ŀ� �湮 ���θ� true�� �ٲ۴�.
		for(int i = 0 ; i < N.length ; i++) {
			for(int j = 0 ; j < N.length ; j++) {
				if(result[i] == N[j] && !visited[j]) {
					result[i] = j;
					visited[j] = true;
					break;
				}
			}
		}
		return result;
	}

}

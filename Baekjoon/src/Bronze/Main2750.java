package Bronze;

import java.util.Arrays;
import java.util.Scanner;

public class Main2750 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = sc.nextInt();
		}
		// �����Լ��ν� �迭�� ������������ �������ִ� Arrays.sort �Լ��� ����Ͽ���.
		Arrays.sort(arr);
		
		for(int v : arr) {
			System.out.println(v);
		}
		sc.close();
	}
	

}

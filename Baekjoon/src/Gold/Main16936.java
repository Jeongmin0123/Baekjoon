package Gold;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main16936 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// ��� ���ڿ� �� ���ڸ� �μ����� ���� ��, 3�� ������ �����Ѵ�.
		long[][] arr = new long[N][2];		
		for(int i=0; i<N; i++) {
			arr[i][1] = sc.nextLong();
			long n = arr[i][1];
			while(true) {
				if(n % 3 == 0) {
					arr[i][0]++;
					n /= 3;
				} else {
					break;
				}
			}
		}
		// 3�� ������ ū ������� �����ϵ�, ���� 3�� ������ ������ ���� ���ڰ� �տ� ������ �����Ѵ�.
		Arrays.sort(arr, new Comparator<long[]>() {
			@Override
			public int compare(long[] o1, long[] o2) {
				if(o1[0] == o2[0]) {
					// 0��° �ε����� ������, 1��° �ε����� ��������
					return Long.compare(o1[1], o2[1]);
				}
				else {
					// 0��° �ε����� ��������
					return Long.compare(o2[0], o1[0]);
				}
			}
		});
		
		for(int i=0; i<N; i++) {
			System.out.print(arr[i][1]+" ");
		}		
		sc.close();
	}
	

}

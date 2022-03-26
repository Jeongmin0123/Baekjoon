package Silver;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main1181 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] arr = new String[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = sc.next();
		}
		
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// ���� ���̰� ���� ��� ���ڿ� ���� �������� �����Ѵ�.
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
				} else {
					// ���� ���̰� �ٸ� ���  �� ª���� ������ ������ �����Ѵ�.
					return o1.length() - o2.length();
				}
			}
		});
		// �迭�� �� �հ��� �׳� ����� ���� ���� �����ʹ� ���� ���� ���� ���� �ÿ���
		// ����ϵ��� for���� ������.
		System.out.println(arr[0]);
		for(int i = 1 ; i < N ; i++) {
			if(!arr[i].equals(arr[i-1])) {
				System.out.println(arr[i]);
			}
		}
	}	
}

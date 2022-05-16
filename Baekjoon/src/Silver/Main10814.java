package Silver;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main10814 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int N = sc.nextInt();
		String[][] arr = new String[N][2];		
		for(int i = 0; i < N; i++) {
			arr[i][0] = sc.next();
			arr[i][1] = sc.next();
		}
		
		// 나이로 정렬한 후에 나이가 같으면 이름 순으로 정렬한다.
		Arrays.sort(arr, new Comparator<String[]>() {
			@Override
			public int compare(String[] s1, String[] s2) {
				return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
			}
			
		});
		
		// 출력
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
		sc.close();
	}

}

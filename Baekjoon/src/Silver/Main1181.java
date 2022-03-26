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
				// 둘의 길이가 같은 경우 문자에 따라 오름차순 정렬한다.
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
				} else {
					// 둘의 길이가 다른 경우  더 짧은게 앞으로 오도록 정렬한다.
					return o1.length() - o2.length();
				}
			}
		});
		// 배열의 맨 앞값은 그냥 출력한 이후 뒤의 값부터는 앞의 값과 같지 않을 시에만
		// 출력하도록 for문을 돌린다.
		System.out.println(arr[0]);
		for(int i = 1 ; i < N ; i++) {
			if(!arr[i].equals(arr[i-1])) {
				System.out.println(arr[i]);
			}
		}
	}	
}

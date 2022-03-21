package Bronze;

import java.util.Scanner;

public class Main8958 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] arr = new String[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = sc.next();
		}
		for(int i = 0 ; i < N ; i++) {
			int sum = 0;
			int count = 0;
			for(int j = 0 ; j < arr[i].length(); j++) {
				if(arr[i].charAt(j) == 'O') {
					count++;
					sum += count;
				} else {
					count = 0;
				}
			}
			System.out.println(sum);
		}
		sc.close();
	}
}

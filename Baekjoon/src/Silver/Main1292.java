package Silver;

import java.util.Scanner;

public class Main1292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int[] array = new int[1002];
		int count = 1;
		for(int i = 1 ; i <=1000 ; i++) {
			for(int j = 0 ; j <i ; j++) {
				if(count==1001) break;
				array[count] = i;
				count++;
			}
		}
		int sum = 0;
		for(int i = A ; i <= B ; i++) {
			sum += array[i];
		}
		System.out.println(sum);
	}

}

package Gold;

import java.util.Scanner;

public class Main10830 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long B = sc.nextLong();
		int[][] arr = new int[N][N];
		int[][] result = new int[N][N];
		int[][] temp = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				arr[i][j] = sc.nextInt();
				result[i][j] = arr[i][j];
			}
		}
		if(B == 1) {
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					System.out.print(result[i][j] + " ");
				}
				System.out.println("");
			}
		}
		for(long i = 0 ; i < B - 1 ; i++) {
			for(int x = 0 ; x < N ; x++) {
				for(int y = 0 ; y < N ; y++) {
					int sum = 0;
					for(int k = 0 ; k < N ; k++) {
						sum += result[x][k]*arr[k][y];
					}
					temp[x][y] = sum%1000;
				}
			}
			for(int x = 0 ; x < N ; x++) {
				for(int y = 0 ; y < N ; y++) {
					result[x][y] = temp[x][y];
				}
			}
		}
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println("");
		}
	}
	

}

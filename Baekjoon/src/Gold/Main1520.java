package Gold;

import java.util.Scanner;

public class Main1520 {
	public static boolean used[][];
	public static int[][] arr;
	public static int count = 0;
	public static int[] rangeX = { 0, 0,-1, 1};
	public static int[] rangeY = {-1, 1, 0, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		arr = new int[N][M];
		used = new boolean[N][M];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		
	}
	
	public static int check(int x, int y) {
		if(x == arr.length && y == arr[0].length) {
			return 1;
		} else if(x == 0) {
			
		}
		
		return 1;
	}

}

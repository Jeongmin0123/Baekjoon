package Silver;

import java.util.Scanner;

public class Main1051 {
	public static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		arr = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			String temp = sc.next();
			for(int j = 0 ; j < M ; j++) {
				arr[i][j] = temp.charAt(j);
			}
		}
		System.out.println(check());
	}
	// 문제에 조건에 맞는 가장 큰 정사각형의 넓이를 반환하는 함수
	public static int check() {
		// 정사각형의 한변의 길이, 길이가 1인 정사각형은 없을 수 없으므로 default 값으로 지정
		int length = 1;
		// 정사각형의 넓이, 마찬가지로 길이가 1이면 넓이가 1이므로 default값으로 지정
		int size = 1;
		// 정사각형의 길이는 배열의 열과 행의 길이중 작은 값보다는 작거나 같아야 한다.
		while(length <= Math.min(arr.length, arr[0].length)) {
			Loop1: for(int i = 0 ; i < arr.length + 1 - length ; i++) {
				for(int j = 0 ; j < arr[0].length + 1 - length ; j++) {
					// 4꼭지점의 값을 같을 경우 크기를 재지정해준다.
					if(arr[i][j] == arr[i+length-1][j+length-1] && arr[i][j+length-1] == arr[i][j] && arr[i][j] == arr[i+length-1][j]) {
						size = length*length;
						// if문을 타고 들어왔다면 이미 길이가 length인 정사각형이 존재하는 걸 알아냈으므로
						// 길이가 length인 다른 정사각형들을 굳이 고려할 필요가 없기에 break 문을 사용한다.
						break Loop1;
					}
				}
			}
			length++;
		}
		return size;
	}

}

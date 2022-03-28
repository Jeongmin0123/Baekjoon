package Gold;

import java.util.Scanner;

public class Main10830 {
	// 메서드의 계산에서 맨 처음 입력받은 행렬이 필요하므로 정적 변수로 지정한다.
	public static int[][] origin;
	// 마찬가지로 행렬의 크기를 나타내는 숫자도 정적 변수로 지정한다.
	public static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		long B = sc.nextLong();
		origin = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				// A^B의 각 원소를 1,000으로 나눈 나머지를 출력한다라는 문장 때문에
				// 입력받은 원소를 1000으로 나눠 그 나머지를 넣어준다.
				origin[i][j] = sc.nextInt()%1000;
			}
		}
		int[][] result = div(origin, B);
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println("");
		}
		sc.close();
	}
	// 어떠한 행렬을 B제곱하는 메서드
	// 만약 파라미터값이 arr, 6인 경우[div(arr,6)] 밑에 문장을 통하여
	// result 배열은 div(arr,3) * div(arr,3)로 나눠진다
	// 이후 다시 div메서드가 돌아가 (div(arr,1)*div(arr,1)*div(arr,1))
	// *(div(arr,1)*div(arr,1)*div(arr,1))가 된다.
	public static int[][] div(int[][] arr, long B) {
		// 만약 1제곱을 하는 경우, 자기 자신을 그대로 반환한다.
		if(B == 1L) return arr;
		// 재귀 함수를 이용한다.
		int[][] result = div(arr, B/2);
		// 위에서 만약 제곱수를 반으로 나눠주었으므로 result를 두번 곱함으로써
		// 등호가 성립하도록 한다.
		result = multi(result, result);
		// 만약 나머지가 생겼다면, 원래 함수 하나가 튀어나온 것 이므로
		// result행렬에 origin행렬을 곱해준다.
		if(B % 2 == 1L) {
			result = multi(result, origin);
		}
		return result;
		
	}
	// 두 행렬의 곱을 반환하는 메서드, 이 때 반환값은 100으로 나눈 나머지 이므로
	// result[i][j] %= 1000;를 결과값에 넣어준다.
	public static int[][] multi(int[][] arr1, int[][] arr2) {
		int[][] result = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				for(int k = 0 ; k < N ; k++) {
					result[i][j] += (arr1[i][k]*arr2[k][j]);
					result[i][j] %= 1000;
				}
			}
		}
		return result;
	}
}
package Gold;

import java.util.Scanner;
public class Main11444 {
	// 메서드의 계산에서 맨 처음 입력받은 행렬이 필요하므로 정적 변수로 지정한다.
	public static long[][] origin = new long[2][2];
	// 마찬가지로 행렬의 크기를 나타내는 숫자도 정적 변수로 지정한다.
	public static long N;	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 피보나치 수열은 Fn = Fn-1 + Fn-2 이다.
		// 따라서 이를 행렬로 나타내면
		// (Fn+1) = (1 1)( Fn )
		// ( Fn )   (1 0)(Fn-1)
		// 로 나타낼 수 있다. 
		// 따라서 
		// (Fn+1) = (1 1)^n(1)
		// ( Fn )   (1 0)  (0)
		// 으로 나타낼 수 있으며 이때 행렬의 제곱 식은 10830번 : 행렬 제곱을 참고하면 된다.
		origin[0][0] = 1;
		origin[0][1] = 1;
		origin[1][0] = 1;
		origin[1][1] = 0;
		N = sc.nextLong();
		long[][] result = div(origin, N-1);	
		System.out.println(result[0][0]);
	}
	// 어떠한 행렬을 B제곱하는 메서드
	// 만약 파라미터값이 arr, 6인 경우[div(arr,6)] 밑에 문장을 통하여
	// result 배열은 div(arr,3) * div(arr,3)로 나눠진다
	// 이후 다시 div메서드가 돌아가 (div(arr,1)*div(arr,1)*div(arr,1))
	// *(div(arr,1)*div(arr,1)*div(arr,1))가 된다.
	public static long[][] div(long[][] arr, long B) {
		// 만약 1제곱을 하는 경우, 자기 자신을 그대로 반환한다.
		if(B == 1 || B == 0) return arr;
		// 재귀 함수를 이용한다.
		long[][] result = div(arr, B/2);
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
	// result[i][j] %= 1000000007;를 결과값에 넣어준다.
	public static long[][] multi(long[][] arr1, long[][] arr2) {
		long[][] result = new long[2][2];
		for(int i = 0 ; i < 2 ; i++) {
			for(int j = 0 ; j < 2 ; j++) {
				for(int k = 0 ; k < 2 ; k++) {
					result[i][j] += (arr1[i][k]*arr2[k][j]);
					result[i][j] %= 1000000007;
				}
			}
		}
		return result;
	}	
}

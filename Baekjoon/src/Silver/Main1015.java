package Silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main1015 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for(int i = 0 ; i < N ; i++) {
			A[i] = sc.nextInt();
		}
		int[] result = sort(A);
		for(int i = 0 ; i < N ; i++) {
			System.out.println(result[i]);
		}
	}
	// 정렬값을 int배열로 반환해주는 함수
	public static int[] sort(int[] N) {
		// 결과값을 받아올 배열을 지정해준다.
		int[] result = new int[N.length];
		// 정렬한 N배열의 j번째 항에 방문을 했는지 알려주는 배열을 지정한다.
		boolean[] visited = new boolean[N.length];
		// result[i]에 N[i] 값을 모두 넣어준다.
		for(int i = 0 ; i < N.length ; i++) {
			result[i] = N[i];
		}
		// N 배열을 정렬해준다.
		Arrays.sort(N);
		// 만약 result 배열의 i번째 항과 N 배열의 j번째 항이 같고 j번째 항을 방문하지 않은 경우
		// j를 result[i]에 대입한 후에 방문 여부를 true로 바꾼다.
		for(int i = 0 ; i < N.length ; i++) {
			for(int j = 0 ; j < N.length ; j++) {
				if(result[i] == N[j] && !visited[j]) {
					result[i] = j;
					visited[j] = true;
					break;
				}
			}
		}
		return result;
	}

}

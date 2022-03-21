package Silver;

import java.util.*;

public class Main1018 {
	// 문제를 풀기 위하여 main 함수의 N*M 크기의 보드판과 다시 칠해야 하는
	// 정사각형의 개수를 반환하는 함수에서의 8*8 크기의 보드판 2개가 필요하다.
	// 따라서 보드판 2개를 사용하는 것보다 1개의 보드판을 전역변수로 선언하여
	// 사용하는 것이 좋다고 생각하여 전역변수 보드판 problem을 만들었다.
	static char problem[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		problem = new char[N][M];
		// sc.nextline을 사용한 뒤에 row에 sc.nextline을 저장하는 이유는
		// nextline은 정보가 이미 입력되어 있는 경우 입력되어 있는 정보를 받은 이후 줄을 바꾸기 때문에
		// 오류가 발생하기 때문에, sc.nextLine을 먼저 한번 실행한 후에 for문을 시행한다.
		sc.nextLine();
		
		// 보드판에 색깔을 받아주는 문장
		for(int i = 0; i<N; i++) {
			String row = sc.nextLine();
			for(int j = 0 ; j<M; j++) {
				problem[i][j] = row.charAt(j);
			}
		}
		// 50X50 보드판의 정사각형 갯수가 2500개이므로 최대 바꿀 수 있는 정사각형의 개수를
		// 2500으로 잡은 후에 min 값을 통하여 ans와 계산결과를 비교하여 작은 값을 출력한다.
		int ans = 2500;
		for(int i = 0; i <N-7;i++) {
			for(int j = 0; j<M-7; j++) {
				ans = Math.min(count(i,j),ans);
			}
		}
		System.out.println(ans);
		sc.close();
	}
	// 8X8 보드판에서 바꿔야 할 정사각형의 개수를 받아오는 메서드
	public static int count(int x, int y) {
		// B = black, W = white
		int B = 0;	// 배열의 0,0 지점을 B라고 가정했을 때, B로 바꿔야 하는 갯수
		int W = 0;	// 배열의 0,0 지점을 W라고 가정했을 때, W로 바꿔야 하는 갯수
		for(int i = x ; i < x+8; i++) {
			for(int j = y ; j < y+8; j++) {
				if((i+j)%2 == 0) {
					if(problem[i][j] == 'B') W++;
					else B++;
				} else {
					if(problem[i][j] == 'B') B++;
					else W++;
				}
			}	
		}
		// 바꿔야 할 갯수중 더 작은 값을 return한다.
		return Math.min(B, W);
	}
}

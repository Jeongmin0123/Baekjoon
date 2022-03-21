package Silver;

import java.util.Scanner;

public class Main11729 {
	// ArrayList에서의 add함수를 사용하면 숫자들끼리의 합을 구해주기 때문에 StringBuilder 를 이용하여 수행과정을 합쳐준다.
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		// scanner를 이용하여 원판의 개수를 받아온다.
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// 수행횟수를 구한다.
		sb.append((int) Math.pow(2, n) - 1);
		// 수행횟수와 수행 과정 사이의 줄 바꿈을 수행한다.
		sb.append("\n");
		// 시작위치가 1, 끝 위치가 3이므로 중간 위치를 2로 두고 하노이 탑 함수를 실행한다.
		hanoi(n,1,2,3);
		System.out.println(sb);
		sc.close();
	}
	
	// 하노이 탑 함수
	public static void hanoi(int n, int start, int mid, int end) {
		// 만약 원판의 개수가 1이면 원판을 시작점에서 끝점으로 옮긴 후에 함수를 종료한다.
		if(n == 1) {
			sb.append(start + " " + end + "\n");
			return;
		}
		// 하노이 탑 함수는 크게 3단계로 구분해서 함수를 정의한다.
		// 1. 맨 밑의 원판을 제외하고 n-1개의 함수를 중간 지점까지 옮기는 것을 재귀함수로 불러온다.
		hanoi(n-1, start, end, mid);
		// 2. n개의 원판 중 맨 밑의 원판을 끝 지점으로 옮기는 과정을 sb에 추가한다.
		sb.append(start + " " + end + "\n");
		// 3. 중간 지점에 있는 n-1개의 원판을 끝 지점으로 옮기는 것 또한 재귀함수로 불러온다.
		hanoi(n-1, mid, start, end);
	}

}

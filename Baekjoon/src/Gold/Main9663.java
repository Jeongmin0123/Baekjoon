package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9663 {
	
	public static int answer, N;
	public static int[] colsNum;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		colsNum = new int[N];
		setQueen(0);
		System.out.println(answer);
	}

	public static void setQueen(int row) {
		// 마지막에 도달하면 값을 반환한다.
		if(row == N) {
			answer++;
			return;
		}
		// 이 함수를 통해서 각각의 행에는 하나의 퀸만 놓이게 된다.
		for(int i = 0 ; i < N ; i++) {
			colsNum[row] = i;
			if(isValid(row)) setQueen(row+1);
		}
	}
	
	// 같은 열에 존재하지 않고 같은 대각선상에 존재하는지 판단하는 함수
	public static boolean isValid(int row) {
		for(int i = 0 ; i < row ; i++) {
			if(colsNum[row] == colsNum[i] || row - i == Math.abs(colsNum[row] - colsNum[i])) {
				return false;
			}
		}
		return true;
	}
	
}


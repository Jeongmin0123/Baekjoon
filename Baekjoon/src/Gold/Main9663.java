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
		// �������� �����ϸ� ���� ��ȯ�Ѵ�.
		if(row == N) {
			answer++;
			return;
		}
		// �� �Լ��� ���ؼ� ������ �࿡�� �ϳ��� ���� ���̰� �ȴ�.
		for(int i = 0 ; i < N ; i++) {
			colsNum[row] = i;
			if(isValid(row)) setQueen(row+1);
		}
	}
	
	// ���� ���� �������� �ʰ� ���� �밢���� �����ϴ��� �Ǵ��ϴ� �Լ�
	public static boolean isValid(int row) {
		for(int i = 0 ; i < row ; i++) {
			if(colsNum[row] == colsNum[i] || row - i == Math.abs(colsNum[row] - colsNum[i])) {
				return false;
			}
		}
		return true;
	}
	
}


package Silver;

import java.util.*;

public class Main1018 {
	// ������ Ǯ�� ���Ͽ� main �Լ��� N*M ũ���� �����ǰ� �ٽ� ĥ�ؾ� �ϴ�
	// ���簢���� ������ ��ȯ�ϴ� �Լ������� 8*8 ũ���� ������ 2���� �ʿ��ϴ�.
	// ���� ������ 2���� ����ϴ� �ͺ��� 1���� �������� ���������� �����Ͽ�
	// ����ϴ� ���� ���ٰ� �����Ͽ� �������� ������ problem�� �������.
	static char problem[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		problem = new char[N][M];
		// sc.nextline�� ����� �ڿ� row�� sc.nextline�� �����ϴ� ������
		// nextline�� ������ �̹� �ԷµǾ� �ִ� ��� �ԷµǾ� �ִ� ������ ���� ���� ���� �ٲٱ� ������
		// ������ �߻��ϱ� ������, sc.nextLine�� ���� �ѹ� ������ �Ŀ� for���� �����Ѵ�.
		sc.nextLine();
		
		// �����ǿ� ������ �޾��ִ� ����
		for(int i = 0; i<N; i++) {
			String row = sc.nextLine();
			for(int j = 0 ; j<M; j++) {
				problem[i][j] = row.charAt(j);
			}
		}
		// 50X50 �������� ���簢�� ������ 2500���̹Ƿ� �ִ� �ٲ� �� �ִ� ���簢���� ������
		// 2500���� ���� �Ŀ� min ���� ���Ͽ� ans�� ������� ���Ͽ� ���� ���� ����Ѵ�.
		int ans = 2500;
		for(int i = 0; i <N-7;i++) {
			for(int j = 0; j<M-7; j++) {
				ans = Math.min(count(i,j),ans);
			}
		}
		System.out.println(ans);
		sc.close();
	}
	// 8X8 �����ǿ��� �ٲ�� �� ���簢���� ������ �޾ƿ��� �޼���
	public static int count(int x, int y) {
		// B = black, W = white
		int B = 0;	// �迭�� 0,0 ������ B��� �������� ��, B�� �ٲ�� �ϴ� ����
		int W = 0;	// �迭�� 0,0 ������ W��� �������� ��, W�� �ٲ�� �ϴ� ����
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
		// �ٲ�� �� ������ �� ���� ���� return�Ѵ�.
		return Math.min(B, W);
	}
}

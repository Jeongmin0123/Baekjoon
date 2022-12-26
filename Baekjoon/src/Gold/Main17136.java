package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17136 {

	public static int[][] map;
	public static int[] count = {0,5,5,5,5,5};
	public static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[10][10];
		for(int i = 0 ; i < 10 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < 10 ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer = Integer.MAX_VALUE;
		dfs(0,0,0);
		if(answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}
	
	// ��Ʈ��ŷ
	public static void dfs(int r, int c, int cnt) {
		// map�� ��� ������ �� Ž���� ���, answer ���� �ʱ�ȭ�Ѵ�.
		if(r == 9 && c > 9) {
			answer = Math.min(answer, cnt);
			return;
		}
		// answer ���� cnt���� �۰ų� ���� ���, �ּ� ������ �Ѿ�� ������ �� �̻� ������ �ʿ䰡 ����.
		if(answer <= cnt) return;
		if(c > 9) {
			dfs(r+1, 0, cnt);
			return;
		}
		// �־��� ��ǥ�� 1�� ��� �����̸� ���� �� �ִ�.
		if(map[r][c] == 1) {
			// ũ�Ⱑ ū �����̸� ���� ���̴� ���, ��Ʈ��ŷ�� ���� ������ ũ�� ���� �� �����Ƿ� ū ������ ���� ���δ�.
			for(int i = 5 ; i > 0 ; i--) {
				// �����̰� �����ְ�, �� �����̸� ���� �� �ִ� ��� �����̸� ���̰� dfs Ž���� ������ �� �ٽ� �����̸� ���ش�.
				if(count[i] > 0 && canAttach(r,c,i)) {
					Attach(r,c,i,0);
					count[i]--;
					dfs(r,c+1,cnt+1);
					Attach(r,c,i,1);
					count[i]++;
				}
			}
		// �־��� ��ǥ�� 0�� ��� �����̸� ���� �� �����Ƿ� ���� ��ǥ�� �Ѿ��.
		} else {
			dfs(r,c+1,cnt);
		}
	}
	// �����̸� ���̰ų� ���� �޼���, num ���� 0�̸� �����̸� �ٿ� �� ��ġ�� 0���� ���̵��� �ϰ�
	// num ���� 1�̸� �����̸� ���� �� ��ġ�� 1�� ���̵��� �ϴ� �޼���
	public static void Attach(int r, int c, int size, int num) {
		for(int i = r ; i < r + size ; i++) {
			for(int j = c ; j < c + size ; j++) {
				map[i][j] = num;
			}
		}
	}
	
	// �� ��ǥ�� �迭 ���ο� �����ϴ� �Ǵ��ϴ� �޼���
	public static boolean isValid(int r, int c) {
		if(r < 0 || c < 0 || r >= 10 || c >= 10) return false;
		return true;
	}
	
	// ũ�Ⱑ size�� �����̸� r,c�� ���� �� �ִ��� �Ǵ��ϴ� �޼���
	public static boolean canAttach(int r, int c, int size) {
		for(int i = r ; i < r + size ; i++) {
			for(int j = c ; j < c + size ; j++) {
				if(!isValid(i,j) || map[i][j] == 0) return false;
			}
		}
		return true;
	}

}

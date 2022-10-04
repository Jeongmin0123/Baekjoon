package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main2239 {

	static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static int[][] map;
	public static ArrayList<Node> checklist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		checklist = new ArrayList<>();
		for(int i = 0 ; i < 9 ; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j = 0 ; j < 9 ; j++) {
				map[i][j] = temp[j]-'0';
				// �޾ƿ� ���ڰ� 0�� ��� ���ڸ� ä����� �ϹǷ� ArrayList�� �����Ͽ� ���Ŀ� ����Ѵ�.
				if(map[i][j] == 0) {
					checklist.add(new Node(i,j));
				}
			}
		}
		play(0);
	}
	// ä���� ��ĭ�� ������ �Ķ���ͷ� �޾ƿ´�.
	public static void play(int cnt) {
		// ���� ��� 0�� ĭ�� ä����ٸ� �� map�� ����Ѵ�.
		if(cnt == checklist.size()) {
			print();
			System.exit(0);
		}
		// ä����� �� ��ĭ�� �޾ƿ´�.
		Node cur = checklist.get(cnt);
		int x = cur.x;
		int y = cur.y;
		// 1���� 9���� ��ĭ�� �� �� �ִ� ���ڸ� �����ϱ� ���� boolean �迭�� �����.
		boolean[] num = new boolean[10];
		// �� ��ĭ�� ���θ� ����Ͽ� �� �� ���� ���� ����ġ�� �Ѵ�.
		for(int i = 0 ; i < 9 ; i++) {
			if(map[x][i] != 0) {
				num[map[x][i]] = true;
			}
		}
		// �� ��ĭ�� ���θ� ����Ͽ� �� �� ���� ���� ����ġ�� �Ѵ�.
		for(int i = 0 ; i < 9 ; i++) {
			if(map[i][y] != 0) {
				num[map[i][y]] = true;
			}
		}
		// �� ��ĭ�� ���Ե� �簢���� ����Ͽ� �� �� ���� ���� ����ġ�� �Ѵ�.
		int X = (x/3)*3;
		int Y = (y/3)*3;
		for(int i = X ; i < X+3 ; i++) {
			for(int j = Y ; j < Y+3 ; j++) {
				if(map[i][j] != 0) {
					num[map[i][j]] = true;
				}
			}
		}
		// 1���� 9�߿� �� �� �ִ� ���ڰ� �����ϴ� ���, �� ���ڸ� �־��� �ڿ� �� ���� ������ ��ǥ�� Ž���Ѵ�.
		for(int i = 1 ; i < 10 ; i++) {
			if(!num[i]) {
				// ����Լ�
				map[x][y] = i;
				play(cnt+1);
				map[x][y] = 0;
			}
		}
	}
	// ��ĭ�� �� ä���� ��, print�� ���� �Լ�
	public static void print() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < 9 ; i++) {
			for(int j = 0 ; j < 9 ; j++) {
				sb.append(map[i][j]);
				System.out.println();
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}


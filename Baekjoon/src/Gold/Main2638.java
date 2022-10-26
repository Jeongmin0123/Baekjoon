package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2638 {

	// ��ǥ���� �����ϴ� class
	static class Node {
		int r;
		int c;
		
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	public static int R,C,time;
	public static int[][] map;
	public static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for(int i = 0 ; i < R ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// �� ��µ� �ɸ��� �ð�
		time = 0;
		while(true) {
			// ������ ���� ���, ���̰� �ð��� ������Ų��.
			if(findRemove()) {
				time++;
			// ���ϰ� ���� ���, while���� ����������.
			} else {
				break;
			}
		}
		System.out.println(time);
	}
	
	// ���� ġ� ã�� �޼���
	public static boolean findRemove() {
		Queue<Node> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[R][C];
		// ����� ������ ���� ������ �����ϴ� �迭
		int[][] check = new int[R][C];
		q.offer(new Node(0,0));
		visited[0][0] = true;
		// ���� ġ� �����ִ��� Ȯ���ϱ� ���� boolean Ÿ�� ����
		boolean canRemove = false;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			for(int i = 0 ; i < 4 ; i++) {
				int dr = cur.r + move[i][0];
				int dc = cur.c + move[i][1];
				// �湮�߰ų�, �迭�� ���Ե��� ������ ���� ������ �����Ѵ�.
				if(!isValid(dr,dc) || visited[dr][dc]) continue;
				// �̵��� ������ ������ �� ������ �������� �ٽ� 4��Ž���� �����Ѵ�.
				if(map[dr][dc] == 0) {
					visited[dr][dc] = true;
					q.offer(new Node(dr,dc));
				// �̵��� ������ ġ����, ���� �� �ִ� ġ� ���� �����̹Ƿ� canRemove�� true �ٲ��ְ�
				// �� ������ ����� ������ ������ 1 ������Ų��.
				} else if(map[dr][dc] == 1) {
					canRemove = true;
					check[dr][dc]++;
				}
			}
		}
		// 2�� �̻� ����� �����ϴ� ������ ġ� ���δ�.
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				if(check[i][j] >= 2) {
					map[i][j] = 0;
				}
			}
		}
		return canRemove;
	}
	
	public static boolean isValid(int r, int c) {
		if(r < 0 || c < 0 || r >= R || c >= C) return false;
		return true;
	}

}


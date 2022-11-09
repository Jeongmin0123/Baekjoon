package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main2665 {
	
	// ��ǥ�� �����ϴ� Ŭ����
	static class Node {
		int r;
		int c;
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	public static int N;
	public static char[][] map;
	// ������ �������� �����ϴµ� �μ� ���� ������ �����ϴ� �迭
	public static int[][] dp;
	public static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		dp = new int[N][N];
		// �μ� ���� ������ Max������ �ʱ�ȭ���ش�.
		for(int i = 0 ; i < N ; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		for(int i = 0 ; i < N ; i++) {
			String temp = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		bfs();
		// ���������� ���µ� �μ� ���� ������ ����Ѵ�.
		System.out.println(dp[N-1][N-1]);
	}
	
	public static void bfs() {
		Queue<Node> q = new ArrayDeque<>();
		// �������� queue�� �־��ְ� dp���� �ʱ�ȭ�Ѵ�.
		q.offer(new Node(0,0));
		dp[0][0] = 0;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			// ����� bfsŽ���ϸ鼭, �迭�� ������ ����� �ʰ�, ����� �� �������� ���µ� �μ� ���� �������� �ֱ� ������ �μ� ���� ������ ���� ���
			// dp���� �������ְ�, �� ������ queue�� �־��ش�.
			for(int i = 0 ; i < 4 ; i++) {
				int dr = cur.r + dir[i][0];
				int dc = cur.c + dir[i][1];
				if(!isValid(dr,dc)) continue;
				if(dp[cur.r][cur.c] < dp[dr][dc]) {
					// ����� ��� �̵��� ���� �Ⱥν��� �ǹǷ� �̵��ϱ� �� ���� �־��ش�.
					if(map[dr][dc] == '1') {
						dp[dr][dc] = dp[cur.r][cur.c];
					} else {
					// �������� ��� �̵��� ���� �ν�����ϹǷ� �̵��� ���� 1�� �߰��Ѵ�.
						dp[dr][dc] = dp[cur.r][cur.c]+1;
					}
					q.offer(new Node(dr,dc));
				}
			}
		}
	}
	
	// �迭�� ������� �Ǵ��ϴ� �޼���
	public static boolean isValid(int r, int c) {
		if(r < 0 || c < 0 || r >= N || c >= N) return false;
		return true;
	}

}

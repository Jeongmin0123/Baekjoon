package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main6593 {

	// x,y,z ��ǥ�� ��������� �� ������ ���µ� �ɸ� �ð��� �����ϴ� Ŭ����
	static class Node {
		int x;
		int y;
		int z;
		int time;
		
		public Node(int x, int y, int z, int time) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
			this.time = time;
		}
		
	}
	
	public static char[][][] map;
	public static boolean[][][] visited;
	public static int L,R,C;
	// ��,��,��,��,��,�Ʒ�
	public static int[] dx = {1,-1,0,0,0,0};
	public static int[] dy = {0,0,1,-1,0,0};
	public static int[] dz = {0,0,0,0,1,-1};
	public static Queue<Node> q;
	public static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			// �Է°��� 0,0,0�� ��� ������ �����Ѵ�.
			if(L == 0 && R == 0 && C == 0) break;
			// ���긶�� result ���� �ʱ�ȭ ���ش�.
			result = Integer.MAX_VALUE;
			map = new char[L][R][C];
			visited = new boolean[L][R][C];
			q = new ArrayDeque<>();
			// �ʿ� ���� �Է�
			for(int i = 0 ; i < L ; i++) {
				for(int j = 0 ; j < R ; j++) {
					map[i][j] = br.readLine().toCharArray();
				}
				br.readLine();
			}
			// map[i][j][k] ���� S�� ��� �������̹Ƿ� q�� �߰��Ѵ�.
			for(int i = 0 ; i < L ; i++) {
				for(int j = 0 ; j < R ; j++) {
					for(int k = 0 ; k < C ; k++) {
						if(map[i][j][k] == 'S') {
							q.add(new Node(j,k,i,0));
						}
					}
				}
			}
			bfs();
			// ����� ����
			if(result != Integer.MAX_VALUE) {
				sb.append("Escaped in ").append(result).append(" minute(s).");
			} else {
				sb.append("Trapped!");
			}
			sb.append("\n");
		}
		// ����� ���
		System.out.println(sb);
	}
	
	// bfs�Լ�
	public static void bfs() {
		Node start = q.peek();
		visited[start.z][start.x][start.y] = true;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			// �����¿����Ʒ� �̵�.
			for(int i = 0 ; i < 6 ; i++) {
				int x = cur.x + dx[i];
				int y = cur.y + dy[i];
				int z = cur.z + dz[i];
				// �̵��� ���� �̵������ϰ�, �湮�� �� ������ ����ִ� �����̸� �̵��Ѵ�.
				if(isValid(z,x,y) && !visited[z][x][y] && map[z][x][y] == '.') {
					q.offer(new Node(x,y,z,cur.time+1));
					visited[z][x][y] = true;
				}
				// �̵��� ������ �ⱸ�̸� �ɸ� �ð��� +1 ���� ���� ������� �ɸ� �ð� �� ���� ���� ���� ���Ͽ� result�� �����Ѵ�.
				if(isValid(z,x,y) && map[z][x][y] == 'E') {
					result = Math.min(result, cur.time+1);
					break;
				}
			}
		}
	}
	
	// x,y,z ��ǥ�� �ǹ� ���� �����ϴ��� �Ǵ��ϴ� �޼���
	public static boolean isValid(int z, int x, int y) {
		if(z < 0 || z >= L || x < 0 || x >= R || y < 0 || y >= C) return false;
		return true;
	}

}

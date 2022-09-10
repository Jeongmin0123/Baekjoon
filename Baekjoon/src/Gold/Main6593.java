package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main6593 {

	// x,y,z 좌표와 출발점에서 그 곳까지 가는데 걸린 시간을 저장하는 클래스
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
	// 하,상,좌,우,위,아래
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
			// 입력값이 0,0,0인 경우 연산을 종료한다.
			if(L == 0 && R == 0 && C == 0) break;
			// 연산마다 result 값을 초기화 해준다.
			result = Integer.MAX_VALUE;
			map = new char[L][R][C];
			visited = new boolean[L][R][C];
			q = new ArrayDeque<>();
			// 맵에 대한 입력
			for(int i = 0 ; i < L ; i++) {
				for(int j = 0 ; j < R ; j++) {
					map[i][j] = br.readLine().toCharArray();
				}
				br.readLine();
			}
			// map[i][j][k] 값이 S인 경우 시작점이므로 q에 추가한다.
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
			// 결과값 저장
			if(result != Integer.MAX_VALUE) {
				sb.append("Escaped in ").append(result).append(" minute(s).");
			} else {
				sb.append("Trapped!");
			}
			sb.append("\n");
		}
		// 결과값 출력
		System.out.println(sb);
	}
	
	// bfs함수
	public static void bfs() {
		Node start = q.peek();
		visited[start.z][start.x][start.y] = true;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			// 상하좌우위아래 이동.
			for(int i = 0 ; i < 6 ; i++) {
				int x = cur.x + dx[i];
				int y = cur.y + dy[i];
				int z = cur.z + dz[i];
				// 이동한 점이 이동가능하고, 방문한 적 없으며 비어있는 지점이면 이동한다.
				if(isValid(z,x,y) && !visited[z][x][y] && map[z][x][y] == '.') {
					q.offer(new Node(x,y,z,cur.time+1));
					visited[z][x][y] = true;
				}
				// 이동한 지점이 출구이면 걸린 시간에 +1 해준 값과 현재까지 걸린 시간 중 가장 작은 값을 비교하여 result에 저장한다.
				if(isValid(z,x,y) && map[z][x][y] == 'E') {
					result = Math.min(result, cur.time+1);
					break;
				}
			}
		}
	}
	
	// x,y,z 좌표가 건물 내에 존재하는지 판단하는 메서드
	public static boolean isValid(int z, int x, int y) {
		if(z < 0 || z >= L || x < 0 || x >= R || y < 0 || y >= C) return false;
		return true;
	}

}

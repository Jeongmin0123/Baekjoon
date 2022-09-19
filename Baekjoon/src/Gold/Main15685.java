package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main15685 {

	// 점의 위치, 방향, 세대를 저장하는 클래스
	static class Node {
		int x;
		int y;
		int dir;
		int gen;
		
		public Node(int x, int y, int dir, int gen) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.gen = gen;
		}
	}
	
	public static Node[] nodelist;
	public static boolean[][] map;
	// 0,1,2,3 방향 순으로 움직인다. 우상좌하
	public static int[][] move = {{0,1},{-1,0},{0,-1},{1,0}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		nodelist = new Node[N];
		map = new boolean[101][101];
		StringTokenizer st;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int gen = Integer.parseInt(st.nextToken());
			nodelist[i] = new Node(y,x,dir,gen);
		}
		// N개의 드래곤 커브를 그려 map에 방문처리 한다.
		for(int i = 0 ; i < N ; i++) {
			fill(nodelist[i]);
		}
		int result = count();
		System.out.println(result);
	}
	
	public static void fill(Node node) {
		int gen = node.gen;
		// 드래곤 커브는 이전 세대 방향의 역순으로 계속해서 방향이 추가된다. 따라서 이전 방향을 저장할 list를 만든다.
		ArrayList<Integer> dirList = new ArrayList<>();
		// 모든 드래곤 커브는 0세대가 기본이므로 0세대에 대한 점들을 방문처리한다.
		// 시작점
		map[node.x][node.y] = true;
		int lastX = node.x + move[node.dir][0];
		int lastY = node.y + move[node.dir][1];
		// 0세대의 끝점
		map[lastX][lastY] = true;
		dirList.add(node.dir);
		
		// 세대수만큼 반복한다.
		while(gen-- > 0) {
			// 이전 세대 방향의 역순으로 계속해서 방향이 추가시켜준다.
			for(int i = dirList.size() - 1 ; i >= 0 ; i--) {
				// 방향은 이전 방향에서 90도 회전 시킨 것이므로 dirList.get(i)+1로 얻어온다. 단, 4가 넘으면 안되므로 4로 나눠 그 나머지를 받아온다.
				int dir = (dirList.get(i)+1)%4;
				lastX += move[dir][0];
				lastY += move[dir][1];
				map[lastX][lastY] = true;
				dirList.add(dir);
			}
		}
	}
	
	// 정사각형의 개수를 세는 메서드
	public static int count() {
		int result = 0;
		for(int i = 0 ; i < 100 ; i++) {
			for(int j = 0 ; j < 100 ; j++) {
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) result++;
			}
		}
		return result;
	}
	
}

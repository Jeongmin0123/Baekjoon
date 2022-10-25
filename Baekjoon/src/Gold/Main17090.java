package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main17090 {

	public static int R, C;
	public static char[][] map;
	// 방문처리를 위한 배열, 탈출 가능한 지점인 경우 2, 아닌 경우 1로 방문처리 한다.
	public static int[][] visited;
	public static int answer, temp;
	// 문자에 따른 이동방법을 저장하는 map
	public static Map<Character, int[]> move;
	public static ArrayList<Node> nodelist;

	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new int[R][C];
		nodelist = new ArrayList<>();
		move = new HashMap<>();
		move.put('D', new int[] { 1, 0 });
		move.put('L', new int[] { 0, -1 });
		move.put('U', new int[] { -1, 0 });
		move.put('R', new int[] { 0, 1 });
		answer = 0;
		temp = 0;
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(visited[i][j] == 0) {
					dfs(i, j);
				}
			}
		}
		System.out.println(answer);
	}
	
	// 한 지점을 기준으로 문자에 따라 움직이게 하고, 움직인 지점에 따라 탈출가능 여부를 판단하는 메서드
	public static void dfs(int r, int c) {
		// 맨 처음에는 받아온 지점을 탈출 불가능 지점으로 가정하고 arraylist에 추가한다.
	    visited[r][c] = 1;
	    nodelist.add(new Node(r,c));
	    int[] moving = move.get(map[r][c]);
	    int dr = r + moving[0];
	    int dc = c + moving[1];
	    // 이동한 지점이 배열을 탈출하거나 탈출 가능한 지점과 연결된 경우
	    if(!isValid(dr,dc) || visited[dr][dc] == 2) {
	    	// 저장한 지점의 수만큼을 answer에 더해준다.
	    	int size = nodelist.size();
	    	answer += size;
	    	// 저장된 지점들을 탈출 가능한 지점으로 바꿔준 뒤 임시로 저장한 노드들을 초기화한다.
	    	for(int i = 0 ; i < size ; i++) {
	    		Node cur = nodelist.get(i);
	    		visited[cur.r][cur.c] = 2;
	    	}
	    	nodelist = new ArrayList<>();
	    	return;
	    // 이동한 지점이 탈출 불가능한 지점과 연결된 경우
	    } else if(visited[dr][dc] == 1) {
	    	// 저장된 지점들을 초기화한다.
	    	nodelist = new ArrayList<>();
	    	return;
	    // 0인 경우, 즉 아무 연산도 하지 않은 경우
	    } else {
	    	dfs(dr,dc);
	    }
	}

	public static boolean isValid(int r, int c) {
		if (r < 0 || c < 0 || r >= R || c >= C)
			return false;
		return true;
	}

}

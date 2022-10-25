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
	public static int[][] visited;
	public static int answer, temp;
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

	public static void dfs(int r, int c) {
	    visited[r][c] = 1;
	    nodelist.add(new Node(r,c));
	    int[] moving = move.get(map[r][c]);
	    int dr = r + moving[0];
	    int dc = c + moving[1];
	    if(!isValid(dr,dc) || visited[dr][dc] == 2) {
	    	int size = nodelist.size();
	    	answer += size;
	    	for(int i = 0 ; i < size ; i++) {
	    		Node cur = nodelist.get(i);
	    		visited[cur.r][cur.c] = 2;
	    	}
	    	nodelist = new ArrayList<>();
	    	return;
	    } else if(visited[dr][dc] == 1) {
	    	nodelist = new ArrayList<>();
	    	return;
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

package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17472 {

	// 지점의 좌표값을 저장하는 클래스
	static class Node {
		int r;
		int c;
		
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	// 두 섬간의 거리와 섬 번호를 저장하는 클래스
	static class Edge {
		int from;
		int to;
		int weight;
		
	}
	// 자기 자신을 부모로 하는 부모노드의 배열을 만드는 메서드
	public static void make() {
		parents = new int[num];
		for(int i = 0 ; i < num ; i++) {
			parents[i] = i;
		}
	}
	// a의 부모노드를 찾는 메서드
	public static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	// a와 b 노드의 부모노드가 다른 경우, 부모노드를 같게 합칩합시키는 메서드
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static int R,C;
	public static int[][] map;
	public static boolean[][] visited;
	public static int num = 1;
	public static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
	public static ArrayList<int[]> edgelist;
	public static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited = new boolean[R][C];
		edgelist = new ArrayList<>();
		
		for(int i = 0 ; i < R ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					makeIslandNum(i,j);
				}
			}
		}
		makeEdge();
		Collections.sort(edgelist, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		make();
		int count2 = 1;
		int sum = 0;
		for(int i = 0 ; i < edgelist.size() ; i++) {
			if(count2 == num - 1) break;
			if(union(edgelist.get(i)[0],edgelist.get(i)[1])) {
				sum += edgelist.get(i)[2];
				count2++;
			}
		}
		if(sum != 0 && count2 == num - 1) {
			System.out.println(sum);
		} else {
			System.out.println(-1);
		}
	}
	// 인근에 있는 섬들끼리 같은 번호로 섬 번호를 매겨주는 메서드
	public static void makeIslandNum(int r, int c) {
		Queue<Node> q = new ArrayDeque<>();
		visited[r][c] = true;
		ArrayList<Node> change = new ArrayList<>();
		change.add(new Node(r,c));
		q.offer(new Node(r,c));
		while(!q.isEmpty()) {
			Node cur = q.poll();
			for(int i = 0 ; i < 4 ; i++) {
				int dr = cur.r + move[i][0];
				int dc = cur.c + move[i][1];
				if(!isValid(dr,dc) || visited[dr][dc]) continue;
				if(map[dr][dc] == map[r][c]) {
					visited[dr][dc] = true;
					change.add(new Node(dr,dc));
					q.offer(new Node(dr,dc));
				}
			}
		}
		for(Node n : change) {
			map[n.r][n.c] = num;
		}
		num++;
	}
	
	// 두섬 사이 지점에서 다리를 놓을 수 있는 경우, 다리를 놓고 그에 대한 정보를 저장하는 메서드
	public static void makeEdge() {
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				if(map[i][j] != 0) {
					for(int k = 0 ; k < 4 ; k++) {
						int dr = i;
						int dc = j;
						int count = 0;
						while(true) {
							dr += move[k][0];
							dc += move[k][1];
							if(!isValid(dr,dc)) break;
							if(map[dr][dc] != 0) {
								if(count >= 2 && map[dr][dc] > map[i][j]) {
									edgelist.add(new int[] {map[dr][dc], map[i][j], count});
									break;
								} else {
									break;
								}
							}
							count++;
						}
					}
				}
			}
		}
	}
	// 지점이 배열 내부에 존재하는지 확인하는 메서드
	public static boolean isValid(int r, int c) {
		if(r < 0 || c < 0 || r >= R || c >= C) return false;
		return true;
	}
}

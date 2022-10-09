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

	// ������ ��ǥ���� �����ϴ� Ŭ����
	static class Node {
		int r;
		int c;
		
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	// �� ������ �Ÿ��� �� ��ȣ�� �����ϴ� Ŭ����
	static class Edge {
		int from;
		int to;
		int weight;
		
	}
	// �ڱ� �ڽ��� �θ�� �ϴ� �θ����� �迭�� ����� �޼���
	public static void make() {
		parents = new int[num];
		for(int i = 0 ; i < num ; i++) {
			parents[i] = i;
		}
	}
	// a�� �θ��带 ã�� �޼���
	public static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	// a�� b ����� �θ��尡 �ٸ� ���, �θ��带 ���� ��Ĩ�ս�Ű�� �޼���
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
	// �αٿ� �ִ� ���鳢�� ���� ��ȣ�� �� ��ȣ�� �Ű��ִ� �޼���
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
	
	// �μ� ���� �������� �ٸ��� ���� �� �ִ� ���, �ٸ��� ���� �׿� ���� ������ �����ϴ� �޼���
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
	// ������ �迭 ���ο� �����ϴ��� Ȯ���ϴ� �޼���
	public static boolean isValid(int r, int c) {
		if(r < 0 || c < 0 || r >= R || c >= C) return false;
		return true;
	}
}

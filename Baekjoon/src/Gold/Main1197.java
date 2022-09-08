package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1197 {

	// 두 정점과 가중치를 저장하는 class, 정렬시 가중치를 기준으로 정렬되도록 한다.
	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	// 두 정점이 연결되어 있는지 판단하기 위한 배열
	public static int[] parents;
	// 정점과 간선의 개수
	public static int V,E;
	// 정점의 정보를 저장하는 배열
	public static Edge[] edgelist;
	
	// 두 정점이 연결되어있는지 확인하기 위한 배열 생성
	public static void make () {
		parents = new int[V];
		for(int i = 0 ; i < V ; i++) {
			parents[i] = i;
		}
	}
	
	// 어떠한 정점의 부모노드를 찾는 메서드
	public static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	// 두 노드가 연결되어 있지 않으면 두 노드를 연결시키는 메서드
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		edgelist = new Edge[E];
		for(int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// 정점의 시작점이 1이므로 1씩 빼준다.
			edgelist[i] = new Edge(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
		}
		make();
		Arrays.sort(edgelist);
		int sum = 0;
		int count = 0;
		// 만약 연결이 되어있지 않으면 연결하고, 그 가중치를 결과값에 더해준다.
		for(Edge edge : edgelist) {
			if(union(edge.from,edge.to)) {
				sum += edge.weight;
				count++;
				// V개의 정점이 다 연결되었으면 종료한다.
				if(count == V-1) break;
			}
		}
		System.out.println(sum);
	}

}

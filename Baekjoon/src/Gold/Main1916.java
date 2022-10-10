package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1916 {

	static class Edge {
		int to;
		int weight;
		
		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
	}
	public static int N,M;
	public static int[] dp;
	public static ArrayList<ArrayList<Edge>> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		// 각 지점에 도달하는데 걸리는 비용을 저장하는 배열
		dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		StringTokenizer st;
		// 각 노드들에 대하여 그 노드와 연결된 엣지들에 대한 정보를 저장하는 리스트
		list = new ArrayList<>();
		for(int i = 0 ; i < N+1 ; i++) {
			list.add(new ArrayList<Edge>());
		}
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list.get(from).add(new Edge(to, weight));
		}
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		dijkstra(start);
		System.out.println(dp[end]);
		
	}
	// 다익스트라 함수
	public static void dijkstra(int start) {
		// 각 간선들을 가중치에 따라 정렬한다.
		PriorityQueue<Edge> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
		boolean[] check = new boolean[N+1];
		q.offer(new Edge(start,0));
		dp[start] = 0;
		while(!q.isEmpty()) {
			// 받아온 간선이 이미 고려된 간선인 경우 연산을 패스하고, 그렇지 않은 경우 방문 처리 한다.
			Edge cur = q.poll();
			if(check[cur.to]) {
				continue;
			} else {
				check[cur.to] = true;
			}
			if(dp[cur.to] > cur.weight) continue;
			// dp에 저장된 다음 노드까지 드는 비용이 (현재 노드까지 오는데 드는 비용 + 현재 노드에서 다음 노드까지 드는 비용)보다 큰 경우, 
			// dp에 저장된 비용을 재지정해주고 그 노드를 기준으로 다시 탐색한다.
			for(Edge next : list.get(cur.to)) {
				if(!check[next.to] && dp[next.to] > cur.weight + next.weight) {
					dp[next.to] = cur.weight + next.weight;
					q.offer(new Edge(next.to, dp[next.to]));
				}
			}
		}
	}
	
}

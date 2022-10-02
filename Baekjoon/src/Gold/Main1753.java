package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1753 {

	// 한 지점에서 갈수 있는 지점과 그 지점까지 가는데 드는 비용을 저장하는 클래스
	static class Node implements Comparable<Node> {
		int to;
		int cost;
		
		public Node(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
		
	}
	
	public static int K,V,E;
	public static int[] dis;
	public static ArrayList<ArrayList<Node>> graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		// 각 노드마다 연결된 노드를 저장하는 arraylist
		graph = new ArrayList<>();
		for(int i = 0 ; i < V + 1 ; i++) {
			graph.add(new ArrayList<Node>());
		}
		for(int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph.get(from).add(new Node(to,cost));
		}
		// 각 노드까지 도달하는 최소 비용을 저장하는 배욜
		dis = new int[V+1];
		dp();
		StringBuilder sb = new StringBuilder();
		for(int i = 1 ; i < V+1 ; i++) {
			// 최소비용이 max값인 경우, 갈수 없으므로 INF 아닌 경우 dis[i]를 반환한다.
			if(dis[i] != Integer.MAX_VALUE) {
				sb.append(dis[i]);
			} else {
				sb.append("INF");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void dp() {
		// 각 노드까지의 최소비용을 max값으로 초기화한다.
		for(int i = 0 ; i < V+1 ; i++) {
			dis[i] = Integer.MAX_VALUE;
		}
		// 자기 자신으로 가는 비용응ㄴ 0이다.
		dis[K] = 0;
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(K,0));
		while(!q.isEmpty()) {
			Node cur = q.poll();
			// 만약 현재 지점에서 원하는 곳으로 가는데 드는 비용이 시작 지점에서 원하는 곳으로 가는데 드는 비용보다 크면 연산할 필요가 없다.
			if(dis[cur.to] < cur.cost) continue;
			// 현재 지점에서 갈수 있는 모든 노드를 고려한다.
			for(int i = 0 ; i < graph.get(cur.to).size() ; i++) {
				Node next = graph.get(cur.to).get(i);
				// 만약에 시작 지점에서 다음 위치까지 가는 비용이 현재 비용과 가는데 드는 비용보다 큰 경우 최소값을 재지정한다.
				if(dis[next.to] > cur.cost + next.cost) {
					dis[next.to] = cur.cost + next.cost;
					q.offer(new Node(next.to, dis[next.to]));
				}
			}
		}
	}

}

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
		// �� ������ �����ϴµ� �ɸ��� ����� �����ϴ� �迭
		dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		StringTokenizer st;
		// �� ���鿡 ���Ͽ� �� ���� ����� �����鿡 ���� ������ �����ϴ� ����Ʈ
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
	// ���ͽ�Ʈ�� �Լ�
	public static void dijkstra(int start) {
		// �� �������� ����ġ�� ���� �����Ѵ�.
		PriorityQueue<Edge> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
		boolean[] check = new boolean[N+1];
		q.offer(new Edge(start,0));
		dp[start] = 0;
		while(!q.isEmpty()) {
			// �޾ƿ� ������ �̹� ����� ������ ��� ������ �н��ϰ�, �׷��� ���� ��� �湮 ó�� �Ѵ�.
			Edge cur = q.poll();
			if(check[cur.to]) {
				continue;
			} else {
				check[cur.to] = true;
			}
			if(dp[cur.to] > cur.weight) continue;
			// dp�� ����� ���� ������ ��� ����� (���� ������ ���µ� ��� ��� + ���� ��忡�� ���� ������ ��� ���)���� ū ���, 
			// dp�� ����� ����� ���������ְ� �� ��带 �������� �ٽ� Ž���Ѵ�.
			for(Edge next : list.get(cur.to)) {
				if(!check[next.to] && dp[next.to] > cur.weight + next.weight) {
					dp[next.to] = cur.weight + next.weight;
					q.offer(new Edge(next.to, dp[next.to]));
				}
			}
		}
	}
	
}

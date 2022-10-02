package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1753 {

	// �� �������� ���� �ִ� ������ �� �������� ���µ� ��� ����� �����ϴ� Ŭ����
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
		// �� ��帶�� ����� ��带 �����ϴ� arraylist
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
		// �� ������ �����ϴ� �ּ� ����� �����ϴ� ���
		dis = new int[V+1];
		dp();
		StringBuilder sb = new StringBuilder();
		for(int i = 1 ; i < V+1 ; i++) {
			// �ּҺ���� max���� ���, ���� �����Ƿ� INF �ƴ� ��� dis[i]�� ��ȯ�Ѵ�.
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
		// �� �������� �ּҺ���� max������ �ʱ�ȭ�Ѵ�.
		for(int i = 0 ; i < V+1 ; i++) {
			dis[i] = Integer.MAX_VALUE;
		}
		// �ڱ� �ڽ����� ���� ������� 0�̴�.
		dis[K] = 0;
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(K,0));
		while(!q.isEmpty()) {
			Node cur = q.poll();
			// ���� ���� �������� ���ϴ� ������ ���µ� ��� ����� ���� �������� ���ϴ� ������ ���µ� ��� ��뺸�� ũ�� ������ �ʿ䰡 ����.
			if(dis[cur.to] < cur.cost) continue;
			// ���� �������� ���� �ִ� ��� ��带 ����Ѵ�.
			for(int i = 0 ; i < graph.get(cur.to).size() ; i++) {
				Node next = graph.get(cur.to).get(i);
				// ���࿡ ���� �������� ���� ��ġ���� ���� ����� ���� ���� ���µ� ��� ��뺸�� ū ��� �ּҰ��� �������Ѵ�.
				if(dis[next.to] > cur.cost + next.cost) {
					dis[next.to] = cur.cost + next.cost;
					q.offer(new Node(next.to, dis[next.to]));
				}
			}
		}
	}

}

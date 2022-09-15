package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main4386 {

	// ���� x,y��ǥ�� ���Ƿ� ������ ��ȣ�� �����ϴ� Ŭ����
	static class Node {
		int num;
		double x;
		double y;
		
		public Node(int num, double x, double y) {
			super();
			this.num = num;
			this.x = x;
			this.y = y;
		}
	}
	
	// ���ۺ��� �������� ��ȣ�� �� ���� �Ÿ��� �����ϴ� Ŭ����
	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		double dis;
		
		// �Ÿ��� �������� �����Ѵ�.
		@Override
		public int compareTo(Edge o) {
			if(this.dis >= o.dis) return 1;
			return -1;
		}

		public Edge(int from, int to, double dis) {
			super();
			this.from = from;
			this.to = to;
			this.dis = dis;
		}
		
	}
	
	// �� ó���� ��� ����� �θ� ��带 �ڱ��ڽ����� �ʱ�ȭ�Ͽ� ������ִ� �޼���
	public static void make() {
		parents = new int[N];
		for(int i = 0 ; i < N ; i++) {
			parents[i] = i;
		}
	}
	
	// ��� ����� �θ��带 ã�� �޼���
	public static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	// �� ���� �θ� ��带 ���Ͽ� �������ϴ� �޼���
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
 	public static int[] parents;
	public static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		// ��帮��Ʈ�� �� ��� ������ ��θ� ������ ��������Ʈ�� �����Ѵ�.
		Node[] nodelist = new Node[N];
		ArrayList<Edge> edgelist = new ArrayList<>();
		
		// ��� ��带 �����Ѵ�.
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			double a = Double.parseDouble(st.nextToken());
			double b = Double.parseDouble(st.nextToken());
			nodelist[i] = new Node(i,a,b);
		}
		
		// ��������Ʈ�� ��� ��� ������ ������ �־��ش�.
		for(int i = 0 ; i < N ; i++) {
			for(int j = i + 1 ; j < N ; j++) {
				edgelist.add(new Edge(nodelist[i].num, nodelist[j].num, 
						Math.sqrt(Math.pow(nodelist[i].x - nodelist[j].x, 2) + Math.pow(nodelist[i].y - nodelist[j].y, 2))));
			}
		}
		
		make();
		// ��������Ʈ�� �����Ѵ�.
		Collections.sort(edgelist);
		double answer = 0;
		int count = 0;
		// ���ĵ� ��������Ʈ�� �տ������� �ϳ��� �̾Ƽ� �� ������ �������� ������ ����Ǿ� ������ �Ѿ�� ����Ǿ� ���� ������ �����Ų �� �� �Ÿ��� ������� �����ش�.
		for(int i = 0 ; i < edgelist.size() ; i++) {
			Edge temp = edgelist.get(i);
			if(union(temp.from, temp.to)) {
				count++;
				answer += temp.dis;
			}
			if(count == N-1) break;
		}
		System.out.println(answer);
	}

}

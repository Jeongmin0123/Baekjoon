package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main4386 {

	// 별의 x,y좌표와 임의로 지정한 번호를 저장하는 클래스
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
	
	// 시작별과 도착별의 번호와 그 사이 거리를 저장하는 클래스
	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		double dis;
		
		// 거리를 기준으로 정렬한다.
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
	
	// 맨 처음에 어떠한 노드의 부모 노드를 자기자신으로 초기화하여 만들어주는 메서드
	public static void make() {
		parents = new int[N];
		for(int i = 0 ; i < N ; i++) {
			parents[i] = i;
		}
	}
	
	// 어떠한 노드의 부모노드를 찾는 메서드
	public static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	// 두 수의 부모 노드를 비교하여 합집합하는 메서드
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
		// 노드리스트와 그 노드 사이의 경로를 저장할 엣지리스트를 생성한다.
		Node[] nodelist = new Node[N];
		ArrayList<Edge> edgelist = new ArrayList<>();
		
		// 모든 노드를 저장한다.
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			double a = Double.parseDouble(st.nextToken());
			double b = Double.parseDouble(st.nextToken());
			nodelist[i] = new Node(i,a,b);
		}
		
		// 엣지리스트에 모든 노드 사이의 정보를 넣어준다.
		for(int i = 0 ; i < N ; i++) {
			for(int j = i + 1 ; j < N ; j++) {
				edgelist.add(new Edge(nodelist[i].num, nodelist[j].num, 
						Math.sqrt(Math.pow(nodelist[i].x - nodelist[j].x, 2) + Math.pow(nodelist[i].y - nodelist[j].y, 2))));
			}
		}
		
		make();
		// 엣지리스트를 정렬한다.
		Collections.sort(edgelist);
		double answer = 0;
		int count = 0;
		// 정렬된 엣지리스트의 앞에서부터 하나씩 뽑아서 그 엣지의 시작점과 끝점이 연결되어 있으면 넘어가고 연결되어 있지 않으면 연결시킨 후 그 거리를 결과값에 더해준다.
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

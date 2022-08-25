package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1922 {

	public static int[] parents;
	public static boolean[] visited;
	public static int N,M;
	public static int count, sum;
	// a의 조상 노드를 찾는 함수
	public static int find(int a) {
		if(parents[a] == a) return a;
		else return parents[a] = find(parents[a]);
	}
	
	// 각각의 원소가 1개씩 존재하는 서로소 집합을 만드는 함수
	public static void make() {
		parents = new int[N+1];
		for(int i = 1 ; i <= N ; i++) {
			parents[i] = i;
		}
	}
	
	// a,b가 같은 집합에 있는지 판단하여 같은 집합에 없으면 둘이 합집합하고 있으면 false를 반환하는 함수
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	// 현재 위치, 다음 위치, 값을 저장하는 클래스
	static class Edge implements Comparable<Edge> {
		int now;
		int next;
		int value;
		
		public Edge(int now, int next, int value) {
			super();
			this.now = now;
			this.next = next;
			this.value = value;
		}

		@Override
		public int compareTo(Edge o) {
			return this.value - o.value;
		}
		
		

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		Edge[] network = new Edge[M];
		for(int i = 0 ; i < M ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			network[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		// 비중값 순으로 정렬한다.
		Arrays.sort(network);
		make();
		
		for(int i = 0 ; i < M ; i++) {
			// 모든 노드를 다 탐색하면 중단한다.
			if(count == N - 1) break;
			// 둘이 같은 집합에 없으면 합친 뒤에 비중값을 더해주고 있으면 있으면 다음 연산을 진행한다.
			if(union(network[i].now, network[i].next)) {
				count++;
				sum += network[i].value;
			}
		}
		
		System.out.println(sum);
	}
}


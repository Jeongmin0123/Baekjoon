package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1976 {

	public static int N,M;
	public static int[][] map;
	public static int parents[];
	public static int[] num;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[N][N];
		num = new int[M];
		make();
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 만약에 i와 j가 연결되어 있으면 union을 통해 부모노드를 같게 해준다.
				if(map[i][j] == 1) {
					union(i,j);
				}
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		// 연결되어야 하는 노드들의 집합을 만든다.
		for(int i = 0 ; i < M ; i++) {
			num[i] = Integer.parseInt(st.nextToken()) - 1;
		}
		for(int i = 0 ; i < M - 1 ; i++) {
			// 만약 연결되어야 하는 노드가 연결되어 있지 않다면 No를 반환후 종료한다.
			if(union(num[i], num[i+1])) {
				System.out.println("NO");
				System.exit(0);
			}
		}
		System.out.println("YES");
	}
	
	// 자기 자신을 부모 노드로 하는 집합 생성
	public static void make() {
		parents = new int[N];
		for(int i = 0 ; i < N ; i++) {
			parents[i] = i;
		}
	}
	
	// a의 부모 노드를 찾는 메서드
	public static int find(int a) {
		if(parents[a] == a) return parents[a];
		return parents[a] = find(parents[a]);
	}
	
	// a와 b의 부모노드가 다를 시 두 노드의 부모노드를 통일시켜주는 메서드
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}

}

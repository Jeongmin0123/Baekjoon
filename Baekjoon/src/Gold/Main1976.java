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
				// ���࿡ i�� j�� ����Ǿ� ������ union�� ���� �θ��带 ���� ���ش�.
				if(map[i][j] == 1) {
					union(i,j);
				}
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		// ����Ǿ�� �ϴ� ������ ������ �����.
		for(int i = 0 ; i < M ; i++) {
			num[i] = Integer.parseInt(st.nextToken()) - 1;
		}
		for(int i = 0 ; i < M - 1 ; i++) {
			// ���� ����Ǿ�� �ϴ� ��尡 ����Ǿ� ���� �ʴٸ� No�� ��ȯ�� �����Ѵ�.
			if(union(num[i], num[i+1])) {
				System.out.println("NO");
				System.exit(0);
			}
		}
		System.out.println("YES");
	}
	
	// �ڱ� �ڽ��� �θ� ���� �ϴ� ���� ����
	public static void make() {
		parents = new int[N];
		for(int i = 0 ; i < N ; i++) {
			parents[i] = i;
		}
	}
	
	// a�� �θ� ��带 ã�� �޼���
	public static int find(int a) {
		if(parents[a] == a) return parents[a];
		return parents[a] = find(parents[a]);
	}
	
	// a�� b�� �θ��尡 �ٸ� �� �� ����� �θ��带 ���Ͻ����ִ� �޼���
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}

}

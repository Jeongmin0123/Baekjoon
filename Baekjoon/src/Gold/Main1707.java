package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1707 {

	// ������ ������ ���� �����ϴ� �迭
	public static int[] colors;
	public static boolean check;
	public static ArrayList<ArrayList<Integer>> list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc <= T ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			colors = new int[V+1];
			list = new ArrayList<>();
			check = true;
			
			// list�� ������ �ʱ�ȭ ���ش�.
			for(int i = 0 ; i < V+1 ; i++) {
				list.add(new ArrayList<Integer>());
				colors[i] = 0;
			}
			// ����� ���鿡 ���� ������ ����Ʈ�� �־��ش�.
			// ����Ʈ�� i��°�� �� �ִ� arraylist���� i�� ���� ����� ������ ��ȣ�� ����ȴ�.
			for(int i = 0 ; i < E ; i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				list.get(v1).add(v2);
				list.get(v2).add(v1);
			}
			// �� ���� �̺� �׷����� ������ �������� ������ ������ �����Ѵ�.
			// ��� ������ ���鼭 ������ �������� ���� ��� �� ��带 �������� bfsŽ���� �Ѵ�.
			for(int i = 1 ; i < V+1 ; i++) {
				if(!check) {
					break;
				}
				if(colors[i] == 0) {
					bfs(i,1);
				}
			}
			sb.append(check ? "YES" : "NO").append("\n");
		}
		System.out.print(sb);
	}
	
	public static void bfs(int start, int color) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		colors[start] = color;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int to : list.get(cur)) {
				// ���� ���� ����� ����� ���� �������� ���� ���, ���� ����� ���� �ݴ�Ǵ� ���� ĥ�ϰ� �� ��带 queue�� �߰��Ѵ�.
				if(colors[to] == 0) {
					q.offer(to);
					colors[to] = -colors[cur];
				// ���� ��尡 ���� ���� ���� ���� ��� ������ �����Ѵ�.
				} else if(colors[to] == colors[cur]) {
					check = false;
					return;
				}
			}
		}
	}

}

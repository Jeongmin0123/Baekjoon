package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1707 {

	// 각각의 노드들의 색을 저장하는 배열
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
			
			// list와 색상을 초기화 해준다.
			for(int i = 0 ; i < V+1 ; i++) {
				list.add(new ArrayList<Integer>());
				colors[i] = 0;
			}
			// 연결된 노드들에 대한 정보를 리스트에 넣어준다.
			// 리스트의 i번째에 들어가 있는 arraylist에는 i번 노드와 연결된 노드들의 번호가 저장된다.
			for(int i = 0 ; i < E ; i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				list.get(v1).add(v2);
				list.get(v2).add(v1);
			}
			// 한 노드라도 이분 그래프의 성질을 만족하지 않으면 연산을 종료한다.
			// 모든 노드들을 돌면서 색깔이 정해지지 않은 경우 그 노드를 기준으로 bfs탐색을 한다.
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
				// 현재 노드와 연결된 노드의 색이 정해지지 않은 경우, 현재 노드의 색과 반대되는 색을 칠하고 그 노드를 queue에 추가한다.
				if(colors[to] == 0) {
					q.offer(to);
					colors[to] = -colors[cur];
				// 인접 노드가 현재 노드와 색이 같은 경우 연산을 종료한다.
				} else if(colors[to] == colors[cur]) {
					check = false;
					return;
				}
			}
		}
	}

}

package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main5014 {
	public static int F;
	public static int S;
	public static int G;
	public static int U;
	public static int D;
	public static int[] floor;
	public static int[] move = new int[2];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		move[0] = Integer.parseInt(st.nextToken());
		move[1] = -Integer.parseInt(st.nextToken());
		// ������ ���� ��ư���� �����ϴ� �迭
		floor = new int[F+1];
		bfs(S);
	}
	
	// dfs ���� ���ѷ����� �ð��ʰ��� �߻��ϹǷ� bfs�� ����Ѵ�.
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		// �湮�� ������ Ȯ���ϴ� �迭
		boolean[] check = new boolean[F+1];
		check[start] = true;
		// �������� ��ư�� �� ���� �����̹Ƿ� 0���� �����Ѵ�.
		floor[start] = 0;
		while(!q.isEmpty()) {
			// ���� ������ ��ǥ�����̸� ���� ��ư�� Ƚ���� ����Ѵ�.
			int now = q.poll();
			if(now == G) {
				System.out.println(floor[G]);
				return;
			}
			// �ö󰡴� ��ư�� �������� ��ư 2���� ����ؾ� �Ѵ�.
			for(int i = 0 ; i < 2 ; i++) {
				int next = now + move[i];
				if(next > F || next < 1) {
					continue;
				}
				// �湮���� ���� �����̸� �� ���� ���꿡 ���Խ�Ű�� �湮�� ���̶�� ǥ���� �ڿ�
				// ���� �������� ��ư�� �ѹ� �� ���� ���̹Ƿ� floor[now] + 1�� �����Ѵ�.
				if(!check[next]) {
					q.add(next);
					check[next] = true;
					floor[next] += floor[now] + 1;
				}
			}
		}
		// ���������ͷ� �� �� ���� ��� ����Ѵ�.
		System.out.println("use the stairs");
	}
}

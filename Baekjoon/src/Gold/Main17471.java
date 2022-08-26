package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17471 {

	// 구역의 개수
	public static int N;
	// 각각의 지점마다의 인구
	public static int[] person;
	// 각각의 지점마다 연결된 지점을 저장한다.
	public static ArrayList<ArrayList<Integer>> list;
	// 각각의 지점마다 방문되었는지 확인하는 배열
	public static boolean[] visited;
	public static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 사용될 변수 초기화 및 할당
		N = Integer.parseInt(br.readLine());
		person = new int[N];
		visited = new boolean[N];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
		}
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 각각의 지점마다의 인원 저장
		for (int i = 0; i < N; i++) {
			person[i] = Integer.parseInt(st.nextToken());
		}
		// 각각의 지점마다 연결된 지점 저장
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				int to = Integer.parseInt(st.nextToken()) - 1;
				list.get(i).add(to);
			}
		}
		subset(0);
		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}

	// 두 선거구로 나누는 부분집합 메서드
	public static void subset(int idx) {
		if (idx == N) {
			// A 선거구에 포함되는 지점의 index값을 저장하는 배열
			ArrayList<Integer> Aidx = new ArrayList<>();
			// B 선거구에 포함되는 지점의 index값을 저장하는 배열
			ArrayList<Integer> Bidx = new ArrayList<>();
			// 부분집합 메서드에 사용 되었으면 A, 아니면 B 선거구에 그 지점을 포함한다.
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					Aidx.add(i);
				} else {
					Bidx.add(i);
				}
			}
			// 각 선거구는 적어도 하나의 구역을 포함해야 한다.
			if (Aidx.size() == 0 || Bidx.size() == 0)
				return;
			// 두 선거구의 지점들에 대해 각 선거구가 연결되어있는지 확인하는 메서드
			cal(Aidx, Bidx);
			return;
		}
		visited[idx] = true;
		subset(idx + 1);
		visited[idx] = false;
		subset(idx + 1);
	}

	// 두 선거구의 지점들에 대해 각 선거구가 연결되어있는지 확인하는 메서드
	public static void cal(ArrayList<Integer> Aidx, ArrayList<Integer> Bidx) {
		// A 선거구가 모두 연결되어 있는지 확인한다.
		Queue<Integer> Aq = new ArrayDeque<>();
		// 어느 지점이 사용되었는지 저장하는 배열
		boolean[] used = new boolean[N];
		// A 구역의 시작지점을 임의로 정한 뒤에 queue에 넣어준다.
		Aq.offer(Aidx.get(0));
		used[Aidx.get(0)] = true;
		// A 선거구에서 연결된 구역의 개수
		int Acnt = 1;
		while (!Aq.isEmpty()) {
			// queue에 저장된 값을 뺀다.
			int Acur = Aq.poll();
			for (int i = 0; i < list.get(Acur).size(); i++) {
				// 현재 지점에 저장된 지점에서 A 선거구에 존재하면서 사용된 적 없는 구역을 사용표시하고 queue에 저장한 뒤 A 선거구에서 연결된 구역의
				// 개수를 늘려준다.
				if (visited[list.get(Acur).get(i)] && !used[list.get(Acur).get(i)]) {
					used[list.get(Acur).get(i)] = true;
					Acnt++;
					Aq.offer(list.get(Acur).get(i));
				}
			}
		}

		// B 선거구가 모두 연결되어 있는지 확인한다.
		Queue<Integer> Bq = new ArrayDeque<>();
		// 어느 지점이 사용되었는지 저장하는 배열
		used = new boolean[N];
		// B 구역의 시작지점을 임의로 정한 뒤에 queue에 넣어준다.
		Bq.offer(Bidx.get(0));
		used[Bidx.get(0)] = true;
		// B 선거구에서 연결된 구역의 개수
		int Bcnt = 1;
		while (!Bq.isEmpty()) {
			// queue에 저장된 값을 뺀다.
			int Bcur = Bq.poll();
			for (int i = 0; i < list.get(Bcur).size(); i++) {
				// 현재 지점에 저장된 지점에서 A 선거구에 존재하면서 사용된 적 없는 구역을 사용표시하고 queue에 저장한 뒤 A 선거구에서 연결된 구역의
				// 개수를 늘려준다.
				if (!visited[list.get(Bcur).get(i)] && !used[list.get(Bcur).get(i)]) {
					used[list.get(Bcur).get(i)] = true;
					Bcnt++;
					Bq.offer(list.get(Bcur).get(i));
				}
			}
		}
		
		// 각 선거구에서 연결된 지점의 개수와 선거구에 존재하는 구역의 개수가 같으면 각 선거구에 포함된 인구를 합산한 뒤에 두 선거구의 인구 차이의 최소값을 저장한다.
		if (Acnt == Aidx.size() && Bcnt == Bidx.size()) {
			int Asum = 0;
			int Bsum = 0;
			for (int i = 0; i < Aidx.size(); i++) {
				Asum += person[Aidx.get(i)];
			}
			for (int i = 0; i < Bidx.size(); i++) {
				Bsum += person[Bidx.get(i)];
			}
			answer = Math.min(answer, Math.abs(Asum - Bsum));
		}
	}

}

package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main11000 {

	public static room[] rooms;
	public static PriorityQueue<Integer> pq;
	public static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// ���Ǹ����� ���� �ð�, ������ �ð��� �����ϴ� �迭
		rooms = new room[N];
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			rooms[i] = new room(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		// ������ �ð� ������ �������� �����Ѵ�.
		Arrays.sort(rooms);
		pq = new PriorityQueue<>();
		getRooms();
		System.out.println(pq.size());
	}
	
	// ������ ���۽ð��� ������ �ð��� �����ϰ�, ������ �ð��� �������� �������� �����ϴ� Ŭ���� 
	static class room implements Comparable<room>{
		int start, end;
		
		public room(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(room o) {
			// TODO Auto-generated method stub
			return this.start != o.start ? this.start - o.start : this.end - o.end;
		}
	}

	// ���ǽǸ��� ��� �ð��� �ּ������� �ǵ��� ���Ǹ� ��ġ�� �ڿ� �� ���ǽ��� ������ ���ǰ� ������ �ð��� pq�� �����Ѵ�.
	public static void getRooms() {
		// ù��° ���Ǹ� pq�� �����Ѵ�.
		pq.offer(rooms[0].end);
		for(int i = 1 ; i < N ; i++) {
			// ù��° ���ǿ� �ٸ� ���ǰ� �ð��� ��ġ�� ������ ù��° ���Ǹ� ��� ���ǽ��� ������ �ð��� �����Ѵ�.
			// �̸� �� �ݺ��Ͽ� ���ǽǸ��� ������ �ð��� �����Ѵ�.
			if(pq.peek() <= rooms[i].start) {
				pq.poll();
			}
			pq.offer(rooms[i].end);
		}
	}
}


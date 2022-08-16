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
		// 강의마다의 시작 시간, 끝나는 시간을 저장하는 배열
		rooms = new room[N];
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			rooms[i] = new room(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		// 끝나는 시간 순으로 오름차순 정렬한다.
		Arrays.sort(rooms);
		pq = new PriorityQueue<>();
		getRooms();
		System.out.println(pq.size());
	}
	
	// 강의의 시작시간과 끝나는 시간을 저장하고, 끝나는 시간을 기준으로 오름차순 정렬하는 클래스 
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

	// 강의실마다 비는 시간이 최소한으로 되도록 강의를 배치한 뒤에 각 강의실의 마지막 강의가 끝나는 시간을 pq에 저장한다.
	public static void getRooms() {
		// 첫번째 강의를 pq에 저장한다.
		pq.offer(rooms[0].end);
		for(int i = 1 ; i < N ; i++) {
			// 첫번째 강의와 다른 강의가 시간이 겹치지 않으면 첫번째 강의를 듣는 강의실의 끝나는 시간을 조정한다.
			// 이를 쭉 반복하여 강의실마다 끝나는 시간을 저장한다.
			if(pq.peek() <= rooms[i].start) {
				pq.poll();
			}
			pq.offer(rooms[i].end);
		}
	}
}


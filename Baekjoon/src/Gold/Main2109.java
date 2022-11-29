package Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2109 {
    
	public static int N, maxDay;
	static class Lecture implements Comparable<Lecture> {
		int day;
		int pay;
		public Lecture(int day, int pay) {
			super();
			this.day = day;
			this.pay = pay;
		}
		// 강연료 순으로 강의를 정렬한다.
		@Override
		public int compareTo(Lecture o) {
			return o.pay - this.pay;
		}
	}
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	// 강의를 저장하는 우선순위 큐
    	PriorityQueue<Lecture> pq = new PriorityQueue<>();
    	maxDay = 0;
    	for(int i = 0 ; i < N ; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    		int pay = Integer.parseInt(st.nextToken());
    		int day = Integer.parseInt(st.nextToken());
    		if(day > maxDay) {
    			maxDay = day;
    		}
    		pq.offer(new Lecture(day,pay));
    	}
    	// 그 날짜에 배당된 강의가 있는지 여부를 저장하는 배열
    	boolean[] used = new boolean[maxDay+1];
    	int size = pq.size();
    	int sum = 0;
    	// 강의의 개수만큼 반복한다.
    	for(int i = 0 ; i < size ; i++) {
    		Lecture cur = pq.poll();
    		// 현재 강의의 만료일을 기준으로 하루씩 앞으로 가면서 비어있는 날짜에 강의를 넣어준다.
    		int check = cur.day;
    		for(int j = check ; j > 0 ; j--) {
    			// 그 날짜의 일정이 비어있는 경우 그 날짜에 현재 강의를 채워주고 방문처리 해준다.
    			if(!used[j]) {
    				sum += cur.pay;
    				used[j] = true;
    				break;
    			}
    		}
    	}
    	System.out.println(sum);
    }
}
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
		// ������ ������ ���Ǹ� �����Ѵ�.
		@Override
		public int compareTo(Lecture o) {
			return o.pay - this.pay;
		}
	}
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	// ���Ǹ� �����ϴ� �켱���� ť
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
    	// �� ��¥�� ���� ���ǰ� �ִ��� ���θ� �����ϴ� �迭
    	boolean[] used = new boolean[maxDay+1];
    	int size = pq.size();
    	int sum = 0;
    	// ������ ������ŭ �ݺ��Ѵ�.
    	for(int i = 0 ; i < size ; i++) {
    		Lecture cur = pq.poll();
    		// ���� ������ �������� �������� �Ϸ羿 ������ ���鼭 ����ִ� ��¥�� ���Ǹ� �־��ش�.
    		int check = cur.day;
    		for(int j = check ; j > 0 ; j--) {
    			// �� ��¥�� ������ ����ִ� ��� �� ��¥�� ���� ���Ǹ� ä���ְ� �湮ó�� ���ش�.
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
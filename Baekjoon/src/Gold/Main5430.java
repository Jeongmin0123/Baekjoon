package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main5430 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
   
	public static void main(String[] args) throws IOException {
		
		ArrayDeque<Integer> deque;
		StringTokenizer st;
      
		int T = Integer.parseInt(br.readLine());
      
		for(int i = 0 ; i < T ; i++) {
         
			// 명령어
			String command = br.readLine();
			int n = Integer.parseInt(br.readLine());
			// 괄호안에 숫자들을 ,를 기준으로 나눠서 deque에 저장한다.
			st = new StringTokenizer(br.readLine(), "[],");
         
			deque = new ArrayDeque<Integer>();
			for(int j = 0; j < n; j++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}
			check(command,deque);
		}
		System.out.println(sb);
	}
	
	// 각 테스트 케이스에 대한 연산
	public static void check(String command, ArrayDeque<Integer> deque) {
		boolean start = true;
		for(char cmd : command.toCharArray()) {
			
			// 명령어가 R인 경우 방향을 바꾼다.
			if(cmd == 'R') {
				start = !start;
				continue;
			}
			// 명령어가 D인 경우
			if(start) {            
				// 만약 반환 된 원소가 없을 경우 error를 출력하도록 하고 함수 종료
				if(deque.pollFirst() == null) {
					sb.append("error\n");
					return;
				}
            
			}
			else {
				if(deque.pollLast() == null) {
					sb.append("error\n");
					return;
				}   
			}
		}
		
		sb.append('[');
		if(deque.size() > 0) {
			// 배열이 뒤집어져 있으면 뒤부터 그렇지 않으면 앞부터 추출한다.
			if(start) {
				sb.append(deque.pollFirst());
				while(!deque.isEmpty()) {
					sb.append(',').append(deque.pollFirst());
				}
    	    } else {
    	    	sb.append(deque.pollLast());
    	    	while(!deque.isEmpty()) {
    	    		sb.append(',').append(deque.pollLast());
    	    	}
    	    }
		}
		sb.append(']').append('\n');
	}

}
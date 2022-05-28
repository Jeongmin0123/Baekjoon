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
         
			// ��ɾ�
			String command = br.readLine();
			int n = Integer.parseInt(br.readLine());
			// ��ȣ�ȿ� ���ڵ��� ,�� �������� ������ deque�� �����Ѵ�.
			st = new StringTokenizer(br.readLine(), "[],");
         
			deque = new ArrayDeque<Integer>();
			for(int j = 0; j < n; j++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}
			check(command,deque);
		}
		System.out.println(sb);
	}
	
	// �� �׽�Ʈ ���̽��� ���� ����
	public static void check(String command, ArrayDeque<Integer> deque) {
		boolean start = true;
		for(char cmd : command.toCharArray()) {
			
			// ��ɾ R�� ��� ������ �ٲ۴�.
			if(cmd == 'R') {
				start = !start;
				continue;
			}
			// ��ɾ D�� ���
			if(start) {            
				// ���� ��ȯ �� ���Ұ� ���� ��� error�� ����ϵ��� �ϰ� �Լ� ����
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
			// �迭�� �������� ������ �ں��� �׷��� ������ �պ��� �����Ѵ�.
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
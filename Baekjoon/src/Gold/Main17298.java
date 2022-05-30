package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main17298 {
	
	public static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] num = new int[n];
		Stack<Integer> check = new Stack<Integer>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		// stack이 비어있지 않고 새로 들어간 index에 존재하는 숫자가 왼쪽에 존재하던 기존의 숫자보다 큰 경우 기존의
		// 숫자를 가장 가까운 오른쪽의 숫자로 바꿔준다.
		for(int i = 0 ; i < n ; i++) {
			while(!check.isEmpty() && num[check.peek()] < num[i]) {
				num[check.pop()] = num[i];
			}
			check.push(i);
		}
		// stack에 남아있는 숫자들은 오른쪽에 자기 자신보다 큰 숫자가 없으므로 -1을 대입해준다.
		while(!check.isEmpty()) {
			num[check.pop()] = -1;
		}
		
		// 배열을 사용하여 for문으로 출력 시 시간초과가 발생하므로 StringBuilder를 사용한다.
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < n ; i++) {
			sb.append(num[i]).append(' ');
		}
		System.out.println(sb);
	}

}

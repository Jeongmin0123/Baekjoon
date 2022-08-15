package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main2668 {

	public static boolean[] used;
	public static int[] num;
	public static ArrayList<Integer> result;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		//
		used = new boolean[N+1];
		num = new int[N+1];
		for(int i = 1 ; i <= N ; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		result = new ArrayList<Integer>();
		// 배열에 있는 숫자들에 대하여 싸이클이 존재하는지 확인하고 존재하면 그 숫자를 list에 넣는다
		for(int i = 1 ; i <= N ; i++) {
			used[i] = true;
			dfs(i,i);
			used[i] = false;
		}
		// 작은 수부터 출력하기 때문에 정렬한다.
		Collections.sort(result);
		StringBuilder sb = new StringBuilder();
		sb.append(result.size());
		sb.append("\n");
		for(int i = 0 ; i < result.size() ; i++) {
			sb.append(result.get(i));
			sb.append("\n");
		}
		System.out.println(sb);
	}
   
	// 재귀함수를 이용하여 한 싸이클의 시작점이자 끝점을 list에 추가해주는 메서드
	public static void dfs(int start, int end) {
		// 어떤 위치의 숫자를 받아와 배열에서 그 숫자 위치에 있는 숫자가 사용되지 않았으면 그 숫자를 사용하여
		// 다시 재귀함수를 호출한다.
		if(!used[num[start]]) {
			used[num[start]] = true;
			dfs(num[start], end);
			used[num[start]] = false;
		}
		if(num[start] == end) {
			result.add(end);
		}
	}
}
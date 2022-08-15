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
		// �迭�� �ִ� ���ڵ鿡 ���Ͽ� ����Ŭ�� �����ϴ��� Ȯ���ϰ� �����ϸ� �� ���ڸ� list�� �ִ´�
		for(int i = 1 ; i <= N ; i++) {
			used[i] = true;
			dfs(i,i);
			used[i] = false;
		}
		// ���� ������ ����ϱ� ������ �����Ѵ�.
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
   
	// ����Լ��� �̿��Ͽ� �� ����Ŭ�� ���������� ������ list�� �߰����ִ� �޼���
	public static void dfs(int start, int end) {
		// � ��ġ�� ���ڸ� �޾ƿ� �迭���� �� ���� ��ġ�� �ִ� ���ڰ� ������ �ʾ����� �� ���ڸ� ����Ͽ�
		// �ٽ� ����Լ��� ȣ���Ѵ�.
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
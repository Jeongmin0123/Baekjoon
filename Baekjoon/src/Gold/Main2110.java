package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2110 {

	public static int N,C;
	public static int[] houses;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		houses = new int[N];
		for(int i = 0 ; i < N ; i++) {
			houses[i] = Integer.parseInt(br.readLine());
		}
		// �̺� Ž���� ���� �����Ѵ�.
		Arrays.sort(houses);
		calc();
	}
	
	// ���� ������ �� ������ ������ �ִ� �Ÿ��� ����ϴ� �޼���
	public static void calc() {
		// �̺� Ž����, ���� ��ǥ�� 0���� 1000000000�̰�, ���� ��ǥ�� ���� ���� �����Ƿ�
		// �� ������ ������ ������ �Ÿ� 1���� 1000000000�̹Ƿ� �̿� ���� L,R���� �����Ѵ�.
		int L = 1;
		int R = 1000000000;
		int answer = 0;
		while(L <= R) {
			int mid = (L+R)/2;
			if(check(mid)) {
				answer = mid;
				L = mid + 1;
			} else {
				R = mid - 1;
			}
		}
		System.out.println(answer);
	}
	
	// distance ��ŭ�� �Ÿ� ���̸� ���� �� C�� �̻��� �����⸦ ��ġ�� �� �ִ��� Ȯ���ϴ� �޼���
	public static boolean check(int distance) {
		// ���� ó�� ������� �� ������ ��ġ�Ѵ�.
		int count = 1;
		int last = houses[0];
		for(int i = 1 ; i < N ; i++) {
			// �� �� ������ �Ÿ��� distance���� ũ�ų� �������ٸ� �ڿ� ���� �����⸦ ��ġ�Ѵ�.
			if(houses[i] - last >= distance) {
				count++;
				last = houses[i];
			}
		}
		return count >= C;
	}
}

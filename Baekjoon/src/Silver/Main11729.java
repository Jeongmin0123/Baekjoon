package Silver;

import java.util.Scanner;

public class Main11729 {
	// ArrayList������ add�Լ��� ����ϸ� ���ڵ鳢���� ���� �����ֱ� ������ StringBuilder �� �̿��Ͽ� ��������� �����ش�.
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		// scanner�� �̿��Ͽ� ������ ������ �޾ƿ´�.
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// ����Ƚ���� ���Ѵ�.
		sb.append((int) Math.pow(2, n) - 1);
		// ����Ƚ���� ���� ���� ������ �� �ٲ��� �����Ѵ�.
		sb.append("\n");
		// ������ġ�� 1, �� ��ġ�� 3�̹Ƿ� �߰� ��ġ�� 2�� �ΰ� �ϳ��� ž �Լ��� �����Ѵ�.
		hanoi(n,1,2,3);
		System.out.println(sb);
		sc.close();
	}
	
	// �ϳ��� ž �Լ�
	public static void hanoi(int n, int start, int mid, int end) {
		// ���� ������ ������ 1�̸� ������ ���������� �������� �ű� �Ŀ� �Լ��� �����Ѵ�.
		if(n == 1) {
			sb.append(start + " " + end + "\n");
			return;
		}
		// �ϳ��� ž �Լ��� ũ�� 3�ܰ�� �����ؼ� �Լ��� �����Ѵ�.
		// 1. �� ���� ������ �����ϰ� n-1���� �Լ��� �߰� �������� �ű�� ���� ����Լ��� �ҷ��´�.
		hanoi(n-1, start, end, mid);
		// 2. n���� ���� �� �� ���� ������ �� �������� �ű�� ������ sb�� �߰��Ѵ�.
		sb.append(start + " " + end + "\n");
		// 3. �߰� ������ �ִ� n-1���� ������ �� �������� �ű�� �� ���� ����Լ��� �ҷ��´�.
		hanoi(n-1, mid, start, end);
	}

}

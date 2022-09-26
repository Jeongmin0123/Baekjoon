package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main1174 {
	
	public static int[] nums = {9,8,7,6,5,4,3,2,1,0};
	public static ArrayList<Long> result = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		subset(0,0);
		// result set�� �����Ѵ�.
		Collections.sort(result);
		// 0~9���� �� 10���� ���ڸ� ����ϰų� ������� �ʴ� ���� 2^10=1024�̴�. �̶�, ��� ������� �ʴ� ���� ���� �ϹǷ� 1023������ ���� �迭�� ���� �� �ִ�.
		if(N > 1023) {
			System.out.println(-1);
		} else {
			System.out.println(result.get(N-1));
		}
	}
	
	// �������� ���ĵǾ� �ִ� ���ڵ��� �κ������� �̿��Ͽ� ����ϰų� ������� �ʴ� ������� �����ϴ� ���ڵ��� ����� �ش�.
	public static void subset(long sum, int idx) {
		// result set�� ���� �����ϴ� ������ ��� result set�� �����ش�.
		if(!result.contains(sum)) result.add(sum);
		// ��� ���ڸ� �� ����� ���, ������ �����Ѵ�.
		if(idx >= 10) return;
		// idx��° ���ڸ� ����Ͽ� �����ϴ� ���ڸ� ����� ���
		subset(sum*10 + nums[idx], idx+1);
		// idx��° ���ڸ� ������� �ʰ� �����ϴ� ���ڸ� ����� ���
		subset(sum, idx+1);
	}
}

package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main13904 {

	public static int N;
	// ���� ����Ʈ�� �����ϴ� arraylist
	public static ArrayList<homework> list;
	// ���� ������ �� ���� ū���� �����ϴ� int
	public static int lastDay = -1;

	static class homework implements Comparable<homework> {
		int endDay;
		int worth;

		public homework(int endDay, int worth) {
			super();
			this.endDay = endDay;
			this.worth = worth;
		}

		// ���� ������ �����ϱ� ���� compareTo �޼���
		@Override
		public int compareTo(homework o) {
			if(this.endDay == o.endDay) {
				return o.worth - this.worth;
			}
			return o.endDay - this.endDay;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		// �����ϱ��� ���� �ϼ� �� ���� ū ���� �� ������ ���� �ϸ� ������ �ִ밪�� ���� �� �ִ�.
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int day = Integer.parseInt(st.nextToken());
			int worth = Integer.parseInt(st.nextToken());
			list.add(new homework(day, worth));
			lastDay = Math.max(lastDay, day);
		}
		// �������� �����Ѵ�.
		Collections.sort(list);
		// ������ �ִ밪
		int result = 0;
		// ������ ������ ������ ������ �Ҽ� �ִ� ���� �� ������ �ִ밪�� ���� �����Ѵ�.
		for(int day = lastDay ; day > 0 ; day--) {
			result += calc(day);
		}
		System.out.println(result);
	}

	public static int calc(int day) {
		// �׳� �ִ� ������ ���� �� �ִ� ������ ��ġ
		int idx = -1;
		// �׳��� �ִ� ����
		int max = 0;
		for(int i = 0 ; i < list.size() ; i++) {
			// ����, ���� ��¥���� ����ϴ� ������ �������� �۴ٸ� �� �̻� ����� �ʿ䰡 ����.
			if(list.get(i).endDay < day) break;
			// ������ �������� �����ְ�, �� ������ ������� ����� ������Ÿ ū ��� �׳��� �ִ� ������ �׿� ���� ��ġ���� �ٲ��ش�.
			if(list.get(i).endDay >= day && list.get(i).worth > max) {
				max = list.get(i).worth;
				idx = i;
			}
		}
		if(max == 0) {
			return 0;
		} else {
			list.remove(idx);
			return max;
		}
	}
}

package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main13904 {

	public static int N;
	// 과제 리스트를 저장하는 arraylist
	public static ArrayList<homework> list;
	// 과제 마감일 중 가장 큰값을 저장하는 int
	public static int lastDay = -1;

	static class homework implements Comparable<homework> {
		int endDay;
		int worth;

		public homework(int endDay, int worth) {
			super();
			this.endDay = endDay;
			this.worth = worth;
		}

		// 과제 내역을 정렬하기 위한 compareTo 메서드
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
		// 마감일까지 남은 일수 중 가장 큰 값을 맨 마지막 날에 하면 점수의 최대값을 얻을 수 있다.
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int day = Integer.parseInt(st.nextToken());
			int worth = Integer.parseInt(st.nextToken());
			list.add(new homework(day, worth));
			lastDay = Math.max(lastDay, day);
		}
		// 과제들을 정렬한다.
		Collections.sort(list);
		// 점수의 최대값
		int result = 0;
		// 마지막 날부터 각각의 날마다 할수 있는 과제 중 점수가 최대값인 것을 진행한다.
		for(int day = lastDay ; day > 0 ; day--) {
			result += calc(day);
		}
		System.out.println(result);
	}

	public static int calc(int day) {
		// 그날 최대 점수를 받을 수 있는 과제의 위치
		int idx = -1;
		// 그날의 최대 점수
		int max = 0;
		for(int i = 0 ; i < list.size() ; i++) {
			// 만약, 오늘 날짜보다 고려하는 과제의 마감일이 작다면 더 이상 고려할 필요가 없다.
			if(list.get(i).endDay < day) break;
			// 과제의 마감일이 남아있고, 그 점수가 현재까지 고려한 점수보타 큰 경우 그날의 최대 점수와 그에 대한 위치값을 바꿔준다.
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

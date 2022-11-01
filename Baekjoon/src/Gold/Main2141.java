package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2141 {

	// 마을의 위치와 사람 수를 저장하는 클래스
	static class Village implements Comparable<Village> {
		long num;
		long people;
		
		public Village(long num, long people) {
			super();
			this.num = num;
			this.people = people;
		}

		// 마을의 위치 순으로 정렬하고, 위치가 같은 경우 사람수로 정렬한다.
		@Override
		public int compareTo(Village o) {
			if(this.num == o.num) {
				return (int) (this.people - o.people);
			}
			return (int) (this.num - o.num);
		}
	}
	
	public static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// 모든 마을의 사람 수
		long count = 0;
		Village[] arr = new Village[N];
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr[i] = new Village(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
			count += arr[i].people;
		}
		Arrays.sort(arr);
		long result = 0;
		// 사람수의 중간값이 포함된 마을을 찾아, 그 값을 반환한다.
		for(int i = 0 ; i < N ; i++) {
			result += arr[i].people;
			if(result >= (count+1)/2) {
				System.out.println(arr[i].num);
				break;
			}
		}
	}

}

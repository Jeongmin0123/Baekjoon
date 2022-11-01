package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2141 {

	// ������ ��ġ�� ��� ���� �����ϴ� Ŭ����
	static class Village implements Comparable<Village> {
		long num;
		long people;
		
		public Village(long num, long people) {
			super();
			this.num = num;
			this.people = people;
		}

		// ������ ��ġ ������ �����ϰ�, ��ġ�� ���� ��� ������� �����Ѵ�.
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
		// ��� ������ ��� ��
		long count = 0;
		Village[] arr = new Village[N];
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr[i] = new Village(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
			count += arr[i].people;
		}
		Arrays.sort(arr);
		long result = 0;
		// ������� �߰����� ���Ե� ������ ã��, �� ���� ��ȯ�Ѵ�.
		for(int i = 0 ; i < N ; i++) {
			result += arr[i].people;
			if(result >= (count+1)/2) {
				System.out.println(arr[i].num);
				break;
			}
		}
	}

}

package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15961 {

	public static int N,d,k,c;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		// ��Ʈ�� ȸ���ʹ��� �ʱ�ȭ�Ѵ�.
		int[] belt = new int[N];
		int[] eated = new int[d+1];
		for(int i = 0 ; i < N ; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}
		int left = 0;
		int right = k;
		int max = 0;
		int sum = 0;
		
		// ���� ���� ���� �ʹ��̶�� �ʹ䰡������ ������Ű�� ���� �ʹ��� ��ȣ�� �� �ʹ��� ���� ������ ������Ű��
		// �̹� �Ծ��� �ʹ��� ��� �� �ʹ��� ���� ������ ������Ų��.
		for(int i = 0 ; i < right ; i++) {
			if(eated[belt[i]] == 0) {
				sum++;
			}
			eated[belt[i]]++;
		}
		// ���ʽ� ��ȣ�� ���� ���� ��� +1�� �Ͽ� max ���� �ʱ�ȭ�ϰ� �ƴѰ�� ���� �ʹ䰡������ max�� �ʱ�ȭ�Ѵ�.
		if(eated[c] == 0) {
			sum++;
			max = sum;
			sum--;
		} else {
			max = sum;
		}
		while(left < N) {
			// ȸ���ʹ��� Ư�������� right�� �� ������ �����ϸ� �� ó�� ��ġ�� ������ �Ѵ�.
			if(right >= N) {
				right -= N;
			}
			// ���� ���� �ʹ��� ���� �ѹ��� �Ծ�� ���� �ʹ��� ���, �ʹ� �������� ������Ų��.
			if(eated[belt[right]] == 0) {
				sum++;
			}
			// ���� �ʹ��� ������ ������Ű�� ������ ��ĭ �̵��Ѵ�.
			eated[belt[right]]++;
			right++;
			// ������ �ʹ��� ���� �ѹ� �Ծ �ʹ��� ���, �ʹ� �������� ���ҽ�Ų��.
			if(eated[belt[left]] == 1) {
				sum--;
			}
			// ���� �ʹ��� ������ ���ҽ�Ű�� ������ ��ĭ �̵��Ѵ�.
			eated[belt[left]]--;
			left++;
			// ���ʽ� �ʹ��� ���� ���, �� ���� ���� ������ ������ Ǭ��.
			if(eated[c] == 0) {
				sum++;
				if(sum > max) max = sum;
				sum--;
			} else {
				if(sum > max) max = sum;
			}
		}
		System.out.println(max);
	}

}

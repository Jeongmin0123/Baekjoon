package Gold;

import java.util.Scanner;

public class Main1011 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] ans = new int[T];
		for(int i = 0 ; i < T ; i++) {
			int day = 0;
			int pos = sc.nextInt();
			// ���� ����
			int ob_pos = sc.nextInt();
			// ��ǥ ����
			int max=(int)Math.sqrt(ob_pos-pos);
			// �ѹ��� ���� �ִ� �ִ� ������ (int)Math.sqrt(ob_pos-pos)��.
			// �� ������ 1,2,3 .... ��������� �����ϸ鼭 �̵��ϴٰ� �߰��������� max���� ���� ������ ����
			// ���� �������� �ٷ� ������ �̵��Ÿ� ���� 1�� �Ǳ� ���ؼ� max, max-1, max-2 ..... 3,2,1 �̷� ������ �̵��ϰ� �Ǵµ�
			// ���������� �� ������ �̿��Ͽ� �� ���� ���ϸ� �̵��� �� �ִ� �ִ밪�� Math.sqrt(max^2 + 2max)���´�. ��
			// �̶� �̵��� �� �ִ� �ִ� ���� �������� �����ϹǷ� ���� �Ҽ��� �ڸ��� �� (int)Math.sqrt(ob_pos-pos)�� �ǰԵȴ�. 
			if(max == Math.sqrt(ob_pos-pos)) day = 2*max - 1;
			// max == Math.sqrt(ob_pos-pos) �� ���������� �� ���Ŀ� ���ؼ� �߰����� ��Ȯ�� max���� �ѹ� ���� ���Ŀ� 
			// �̵��ϴ� �Ÿ��� �پ��� ������ �ɸ��� ���� 1���� max������ ������ ���ϰ� max-1���� 1������ ������ ���� 2*max - 1�� �ȴ�.
			else if ((ob_pos-pos) <= Math.pow(max, 2) + max) day = 2*max;
			// (ob_pos-pos) <= Math.pow(max, 2) + max) �� �߰����� max���� �ι� ������ ���Ŀ� �̵��ϴ� �Ÿ��� �پ���.
			// ���� �ɸ��� ���� 1���� max������ ������ ���ϰ� max���� 1������ ������ ���� 2max�� �ȴ�.
			else day = 2*max + 1;
			// ������ ���� �ڰ� ���� ����̹Ƿ� max���� �߰��� 3���̱� ������ �ɸ��� ���� 2*max + 1�� �ȴ�.
			ans[i] = day;
			}
		sc.close();
		
		for(int i = 0 ; i < ans.length ; i++) {
			System.out.print(ans[i] + " ");
			// ���� test case�� ���� ���� ����Ѵ�.
		}
			
	}
	
}
	

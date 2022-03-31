package Gold;

import java.util.Scanner;
public class Main11444 {
	// �޼����� ��꿡�� �� ó�� �Է¹��� ����� �ʿ��ϹǷ� ���� ������ �����Ѵ�.
	public static long[][] origin = new long[2][2];
	// ���������� ����� ũ�⸦ ��Ÿ���� ���ڵ� ���� ������ �����Ѵ�.
	public static long N;	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// �Ǻ���ġ ������ Fn = Fn-1 + Fn-2 �̴�.
		// ���� �̸� ��ķ� ��Ÿ����
		// (Fn+1) = (1 1)( Fn )
		// ( Fn )   (1 0)(Fn-1)
		// �� ��Ÿ�� �� �ִ�. 
		// ���� 
		// (Fn+1) = (1 1)^n(1)
		// ( Fn )   (1 0)  (0)
		// ���� ��Ÿ�� �� ������ �̶� ����� ���� ���� 10830�� : ��� ������ �����ϸ� �ȴ�.
		origin[0][0] = 1;
		origin[0][1] = 1;
		origin[1][0] = 1;
		origin[1][1] = 0;
		N = sc.nextLong();
		long[][] result = div(origin, N-1);	
		System.out.println(result[0][0]);
	}
	// ��� ����� B�����ϴ� �޼���
	// ���� �Ķ���Ͱ��� arr, 6�� ���[div(arr,6)] �ؿ� ������ ���Ͽ�
	// result �迭�� div(arr,3) * div(arr,3)�� ��������
	// ���� �ٽ� div�޼��尡 ���ư� (div(arr,1)*div(arr,1)*div(arr,1))
	// *(div(arr,1)*div(arr,1)*div(arr,1))�� �ȴ�.
	public static long[][] div(long[][] arr, long B) {
		// ���� 1������ �ϴ� ���, �ڱ� �ڽ��� �״�� ��ȯ�Ѵ�.
		if(B == 1 || B == 0) return arr;
		// ��� �Լ��� �̿��Ѵ�.
		long[][] result = div(arr, B/2);
		// ������ ���� �������� ������ �����־����Ƿ� result�� �ι� �������ν�
		// ��ȣ�� �����ϵ��� �Ѵ�.
		result = multi(result, result);
		// ���� �������� ����ٸ�, ���� �Լ� �ϳ��� Ƣ��� �� �̹Ƿ�
		// result��Ŀ� origin����� �����ش�.
		if(B % 2 == 1L) {
			result = multi(result, origin);
		}
		return result;
		
	}
	// �� ����� ���� ��ȯ�ϴ� �޼���, �� �� ��ȯ���� 100���� ���� ������ �̹Ƿ�
	// result[i][j] %= 1000000007;�� ������� �־��ش�.
	public static long[][] multi(long[][] arr1, long[][] arr2) {
		long[][] result = new long[2][2];
		for(int i = 0 ; i < 2 ; i++) {
			for(int j = 0 ; j < 2 ; j++) {
				for(int k = 0 ; k < 2 ; k++) {
					result[i][j] += (arr1[i][k]*arr2[k][j]);
					result[i][j] %= 1000000007;
				}
			}
		}
		return result;
	}	
}

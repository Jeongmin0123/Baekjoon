package Gold;

import java.util.Scanner;

public class Main10830 {
	// �޼����� ��꿡�� �� ó�� �Է¹��� ����� �ʿ��ϹǷ� ���� ������ �����Ѵ�.
	public static int[][] origin;
	// ���������� ����� ũ�⸦ ��Ÿ���� ���ڵ� ���� ������ �����Ѵ�.
	public static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		long B = sc.nextLong();
		origin = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				// A^B�� �� ���Ҹ� 1,000���� ���� �������� ����Ѵٶ�� ���� ������
				// �Է¹��� ���Ҹ� 1000���� ���� �� �������� �־��ش�.
				origin[i][j] = sc.nextInt()%1000;
			}
		}
		int[][] result = div(origin, B);
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println("");
		}
		sc.close();
	}
	// ��� ����� B�����ϴ� �޼���
	// ���� �Ķ���Ͱ��� arr, 6�� ���[div(arr,6)] �ؿ� ������ ���Ͽ�
	// result �迭�� div(arr,3) * div(arr,3)�� ��������
	// ���� �ٽ� div�޼��尡 ���ư� (div(arr,1)*div(arr,1)*div(arr,1))
	// *(div(arr,1)*div(arr,1)*div(arr,1))�� �ȴ�.
	public static int[][] div(int[][] arr, long B) {
		// ���� 1������ �ϴ� ���, �ڱ� �ڽ��� �״�� ��ȯ�Ѵ�.
		if(B == 1L) return arr;
		// ��� �Լ��� �̿��Ѵ�.
		int[][] result = div(arr, B/2);
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
	// result[i][j] %= 1000;�� ������� �־��ش�.
	public static int[][] multi(int[][] arr1, int[][] arr2) {
		int[][] result = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				for(int k = 0 ; k < N ; k++) {
					result[i][j] += (arr1[i][k]*arr2[k][j]);
					result[i][j] %= 1000;
				}
			}
		}
		return result;
	}
}
package Bronze;

import java.util.Scanner;

public class Main2798 {
	public static void main(String[] args) {
		// scanner�� �̿��Ͽ� ī�� ���� ���� �޾ƿ´�.
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		// ī�� ����ŭ�� �迭�� �����Ͽ� �� �迭�� ���� ī�忡 �����ִ� ���ڸ� �޾ƿ´�.
		int[] arr = new int[n];
		for(int i = 0;i < n; i++) {
			arr[i] = sc.nextInt();
		}
		// ���� �޾ƿ��� �Լ��� �̿��Ͽ� ����� ����Ѵ�.
		System.out.println(search(arr, n, m));
		sc.close();
	}
	// M�� �ִ��� ����� īƮ 3���� ���� ����ϴ� �Լ�
	public static int search(int[] arr, int n, int m) {
		int result = 0;
		// ù ��° ī��� ���� ī�尡 2�� �����ϹǷ� n-2��° ī������� �ݺ����� �����Ѵ�.
		for(int i = 0; i<n-2; i++) {
			// ���������� �� ��° ī��� �տ� ī�尡 1��, �ڿ� ī�尡 1�� �����ϹǷ� 2��°���� n-1��° ī������� �ݺ����� �����Ѵ�.
			for(int j = i+1; j<n-1; j++) {
				// ���������� ������ ī��� �տ� 2���� ī�尡 �����ϹǷ� 3��°���� n��° ī������� �ݺ����� �����Ѵ�.
				for(int k = j+1; k<n; k++) {
					// 3���� ī���� ���� ���ึ�� temp ������ �����Ѵ�.
					int temp = arr[i] + arr[j] + arr[k];
					// ���� temp ������ m�� ���ٸ� ����Ѵ�.
					if(m == temp) {
						return temp;
					}
					// ���� temp������ result���� ũ�� m���� ������ result�� ������ �� ������ ����Ѵ�.
					if(result < temp && temp < m) {
						result = temp;
					}
				}
			}
		}
		return result;
	}
}

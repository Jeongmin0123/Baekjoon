package Silver;

import java.util.Scanner;

public class Main1051 {
	public static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		arr = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			String temp = sc.next();
			for(int j = 0 ; j < M ; j++) {
				arr[i][j] = temp.charAt(j);
			}
		}
		System.out.println(check());
	}
	// ������ ���ǿ� �´� ���� ū ���簢���� ���̸� ��ȯ�ϴ� �Լ�
	public static int check() {
		// ���簢���� �Ѻ��� ����, ���̰� 1�� ���簢���� ���� �� �����Ƿ� default ������ ����
		int length = 1;
		// ���簢���� ����, ���������� ���̰� 1�̸� ���̰� 1�̹Ƿ� default������ ����
		int size = 1;
		// ���簢���� ���̴� �迭�� ���� ���� ������ ���� �����ٴ� �۰ų� ���ƾ� �Ѵ�.
		while(length <= Math.min(arr.length, arr[0].length)) {
			Loop1: for(int i = 0 ; i < arr.length + 1 - length ; i++) {
				for(int j = 0 ; j < arr[0].length + 1 - length ; j++) {
					// 4�������� ���� ���� ��� ũ�⸦ ���������ش�.
					if(arr[i][j] == arr[i+length-1][j+length-1] && arr[i][j+length-1] == arr[i][j] && arr[i][j] == arr[i+length-1][j]) {
						size = length*length;
						// if���� Ÿ�� ���Դٸ� �̹� ���̰� length�� ���簢���� �����ϴ� �� �˾Ƴ����Ƿ�
						// ���̰� length�� �ٸ� ���簢������ ���� ����� �ʿ䰡 ���⿡ break ���� ����Ѵ�.
						break Loop1;
					}
				}
			}
			length++;
		}
		return size;
	}

}

package Gold;

import java.util.Arrays;
import java.util.Scanner;

public class Main1027 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// �� ������ ����
		int[] build = new int[N];
		// �� �������� ���̴� �ǹ��� ����
		int[] visible = new int[N];
		for(int i = 0 ; i < N ; i++) {
			build[i] = sc.nextInt();
		}
		visible = count(build, visible);
		// visible �迭�� �����Ѵ�.
		Arrays.sort(visible);
		System.out.println(visible[N-1]);
		sc.close();
	}
	// ������ �ǹ����� ���̴� �ǹ� ���� return �ϴ� �迭�� ��ȯ�Ѵ�.
	public static int[] count(int[] build, int[] visible) {
		for(int i = 0 ; i < build.length - 1 ; i++) {
			// ������ i��° �ǹ��� i+1 �ǹ����� �翷�� �ǹ��� ������ ���̱�
			// ������ Ȯ�������� ���̴� �ǹ����� 1���� ���������ش�.
			visible[i]++;
			visible[i+1]++;
			// �پ��ִ� �ǹ����� �� ������ �� ������ ���� ��, �� ���� �մ� ������ ����
			double slope = (double) build[i+1] - build[i];
			for(int j = i+2 ; j < build.length ; j++) {
				// i��° �ǹ��� j��° �ǹ����� �� ������ �� ������ ���� ��, �� ���� �մ� ������ ����
				double slope2 = (double)(build[j]-build[i])/(j-i);
				// ���� slope >= slope2�� ��� i��° �ǹ����� j��° �ǹ��� ������ �ʰ� �ȴ�.
				// ���� �ؿ� ������ �������� �ʰ� �ٽ� for������ ���ư���.
				if(slope >= slope2) continue;
				// �ݴ��� ���� �ǹ��� ���̱� ������ vsible[i]�� visible[j]�� ������Ű��
				// �� ū ���⸦ slope�� �ٲ��� �� �ٽ� for���� �����Ͽ�
				// ���� ���࿡�� ���� slope2�� slope���� Ŭ ��쿡�� visible�� ������Ų��.
				// �� ������ �� �ǹ� ���̿� �ִ� �ǹ����� ���Ⱑ Ŀ������ i��° �ǹ����� j��° �ǹ��� ���̱� �����̴�.
				slope = slope2;
				visible[i]++;
				visible[j]++;
			}
		}
		return visible;
	}

	public static int count(int[] arr) {
		// ���̴� �ǹ��� �ִ밪�� max�� �д�.
		int max = 0;
		for(int i = 0 ; i < arr.length ; i++) {
			// �� �ǹ����ٿ��� ���̴� �ǹ��� ���� count�� �д�.
			int count = 0;
			// i��° �ǹ��� �պκ��� �ǹ��鿡 ���� ���̴�.
			for(int j = 0 ; j < i ; j++) {
				// j��° �ǹ��� i��° �ǹ��� �� ������ ������ ������ �������� ���Ѵ�.
				float a = (arr[j] - arr[i]) /(float) (j - i);
				float b = (j*arr[i] - i*arr[j])/ (float) (j - i);
				boolean visible = true;
				// ���� i��° �ǹ��� j��° �ǹ� ���̿��� �ǹ��� �������� ���� ���� �����Ѵٸ� �� �ǹ��� ���� �� ���̹Ƿ�
				// ������ �ʴ´ٰ� ���� for���� �����Ѵ�.
				for(int k = j + 1 ; k < i ; k++) {
					if(a*k+b <= arr[k]) {
						visible = false;
						break;
					}
				}
				if(visible) count++;
			}
			// i��° �ǹ��� �޺κ��� �ǹ��鿡 ���� ���̴�.
			for(int j = i + 1 ; j < arr.length ; j++) {
				float a = (arr[j] - arr[i]) /(float) (j - i);
				float b = (j*arr[i] - i*arr[j])/ (float) (j - i);
				boolean visible = true;
				for(int k = i + 1 ; k < j ; k++) {
					if(a*k+b <= arr[k]) {
						visible = false;
						break;
					}
				}
				if(visible) count++;
			}
			// ���� i��° �ǹ����� ���̴� �ǹ��� ���� max���� ũ�� max���� ��ü�Ѵ�.
			if(count > max) max = count;
		}
		return max;
	}
}

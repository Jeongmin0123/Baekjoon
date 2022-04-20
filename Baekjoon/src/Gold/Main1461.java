package Gold;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main1461 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<Integer> num = new ArrayList<Integer>();
		for(int i = 0 ; i < N ; i++) {
			int temp = sc.nextInt();
			num.add(temp);
		}
		int result = 0;
		Collections.sort(num);
		// å�� ������ �ѹ��� ��� �ٴ� �� �ִ� å�� �������� ū ���
		if(N > M) {
			// 0�������� ���� �ָ� �������ִ� ���� ���������� ���� �ּҷ� ���� �� �ִ�.
			// ���� �ٸ� �������� å�� ���� �ٽ� �������� ���ƿ��� �ݸ�, ���� �ָ� ������ ����
			// ���� �� ���ƿ��� �ʱ� ������ 1���� ������� �ϹǷ� �̸� ��������� ���ش�.
			if(Math.abs(num.get(0)) > Math.abs(num.get(num.size()-1))) {
				result -= Math.abs(num.get(0));
			} else {
				result -= Math.abs(num.get(num.size()-1));
			}
			// �̵��� ��, M���� å�� ��� ���ٰ� �����ϸ� ���� ���� �ָ��ִ� ���� ���� ���鼭
			// �� ������ ����� M-1 �� ������ å�� �ΰ�� �� �����Ƿ�, ���� �ָ��ִ� ���� 2�� �Ÿ���
			// ������� ���ϰ�, M���� ������ ArrayList���� �����Ѵ�.
			while(num.size() > M) {
				if(Math.abs(num.get(0)) > Math.abs(num.get(num.size()-1))) {
					result += 2*Math.abs(num.get(0));
					for(int i = 0 ; i < M ; i++) {
						num.remove(0);
					}
				} else {
					result += 2*Math.abs(num.get(num.size()-1));
					for(int i = 0 ; i < M ; i++) {
						num.remove(num.size()-1);
					}
				}
			}
			// ���� å ��ġ�� �� ����� ���
			if(num.get(0) > 0) {
				result += 2*Math.abs(num.get(num.size()-1));
				// ���� å ��ġ�� �� ������ ���
			} else if(num.get(num.size()-1) < 0) {
				result += 2*Math.abs(num.get(0));
				// ���� å ��ġ�� ���, ���� ���� ���
			} else {
				result += 2*Math.abs(num.get(num.size()-1)) + 2*Math.abs(num.get(0));
			}
		// å�� ������ �ѹ��� ��� �ٴ� �� �ִ� å�� �������� ���� ���
		} else {
			if(num.get(0) > 0) {
				result += Math.abs(num.get(num.size()-1));
			} else if(num.get(num.size()-1) < 0) {
				result += Math.abs(num.get(0));
			} else {
				result = 2*Math.abs(num.get(num.size()-1)) + 2*Math.abs(num.get(0));
				if(Math.abs(num.get(0)) > Math.abs(num.get(num.size()-1))) {
					result -= Math.abs(num.get(0));
				} else {
					result -= Math.abs(num.get(num.size()-1));
				}
			}
		}
		
		System.out.println(result);
		sc.close();
	}

}

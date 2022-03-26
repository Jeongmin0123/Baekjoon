package Gold;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main1092 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// ũ������ ���� ���� ����Ʈ�� ArrayList�� �δ� ������ �� ũ������ �̿��ؼ� �ڽ��� �� ���
		// �ڽ��� �����ϰų� ������� ���ϰ� �ؾߵǴµ� �Ϲ� �迭�� ����� �� ������� �ֱ� ������
		// �ڽ� ����Ʈ�� ArrayList�� ����ߴ�. �׷��� �迡 ũ���� ���� ���ѵ� ArrayList��
		// ����Ѵ�.
		ArrayList<Integer> crain = new ArrayList<Integer>();
		for(int i = 0 ; i < N ; i++) {
			crain.add(sc.nextInt());
		}
		int M = sc.nextInt();
		ArrayList<Integer> box = new ArrayList<Integer>();
		for(int i = 0 ; i < M ; i++) {
			box.add(sc.nextInt());
		}
		int result = time(crain, box, N);
		System.out.println(result);
		sc.close();
	}
	
	public static int time(ArrayList<Integer> crain, ArrayList<Integer> box, int N) {
		int time = 0;
		// ũ���ΰ� �ڽ��� ���� ����Ʈ�� �����ϵ� �������� �������ش�
		// �� ������ ���Ŀ� �����ϰڴ�.
		Collections.sort(crain, Collections.reverseOrder());
		Collections.sort(box, Collections.reverseOrder());
		// ���� ���� ���ſ� �ڽ��� ���԰� ũ������ ���� �����߿��� �ִ밪���� ũ�� � �ڽ��� �� �� �����Ƿ�
		// -1�� �����Ѵ�.
		if(box.get(0) > crain.get(0)) {
			return -1;
		}
		// ���� �ڽ��� ���� ������ ������ �����Ѵ�.
		while(box.size() != 0) {
			// ũ������ �ε���
			int crain_idx = 0;
			int box_idx = 0;
			// ũ������ �ε����� N���� ���� �������� ������ �����Ѵ�.
			while(crain_idx < N) {
				// �Ʒ��� ��� �̹� ��� �ڽ��� �Ȱ� ������ �����̹Ƿ� ������ �����Ѵ�.
				if(box_idx == box.size()) break;
				// �Ʒ��� ��� ���� ũ�������� �ڽ��� �� �� �����Ƿ� crain�� �ε����� ������Ű��
				// �� ��ġ�� �ڽ��� �����Ѵ�.
				if(crain.get(crain_idx) >= box.get(box_idx)) {
					crain_idx++;
					box.remove(box_idx);
				// �Ʒ��� ��� ���� ũ�������� �ڽ��� �� �� �����Ƿ� ���� �ڽ��� ���� ���� �� �����ϰ�
				// ���� �ڽ��� ���� ������ �����Ѵ�.
				} else if(crain.get(crain_idx) < box.get(box_idx)) {
					box_idx++;
				}
			}
			// �� ������ �� ����Ǿ��� ��� 1���� �������Ƿ� �ð��� ������Ű�� �ٽ� ���������� �Ѵ�.
			time++;
		}
		return time;
	}
}

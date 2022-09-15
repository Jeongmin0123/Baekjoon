package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14891 {

	// ��Ϲ��� ������ �����ϴ� �迭
	public static int[][] Gear = new int[4][8];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i = 0 ; i < 4 ; i++) {
			String temp = br.readLine();
			for(int j = 0 ; j < 8 ; j++) {
				Gear[i][j] = temp.charAt(j) - '0';
			}
		}
		int K = Integer.parseInt(br.readLine());
		int result = 0;
		for(int i = 0 ; i < K ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int index = Integer.parseInt(st.nextToken()) - 1;
			int direction = Integer.parseInt(st.nextToken());
			start(index,direction);
			
		}
		for(int i= 0 ; i < 4 ; i++) {
			result += Gear[i][0] * Math.pow(2, i);
		}
		System.out.println(result);
	}
	
	// �޾ƿ� ��ġ�� �������� ���� �������� ����� �ڿ� ���� ��Ϲ����� ȸ����Ų��.
	public static void start(int index, int direction) {
		leftSide(index-1,-direction);
		rightSide(index+1,-direction);
		rotation(index,direction);
	}
	
	// ���� ��ġ�� ������ ��Ϲ����� ȸ���ϴ��� ���ϴ��� �Ǵ��ϴ� �޼���
	public static void leftSide(int index, int direction) {
		if(index < 0) return;
		if(Gear[index+1][6] != Gear[index][2]) {
			leftSide(index-1,-direction);
			rotation(index,direction);
		}
	}
	// ���� ��ġ�� �������� ��Ϲ����� ȸ���ϴ��� ���ϴ��� �Ǵ��ϴ� �޼���
	public static void rightSide(int index, int direction) {
		if(index > 3) return;
		if(Gear[index-1][2] != Gear[index][6]) {
			rightSide(index+1,-direction);
			rotation(index,direction);
		}
	}
	// ��Ϲ����� ȸ����Ű�� �޼���
	public static void rotation(int index, int direction) {
		if(direction == 1) {
			int temp = Gear[index][7];
			for(int i = 7 ; i > 0 ; i--) {
				Gear[index][i] = Gear[index][i-1];
			}
			Gear[index][0] = temp;
		} else {
			int temp = Gear[index][0];
			for(int i = 0 ; i < 7 ; i++) {
				Gear[index][i] = Gear[index][i+1];
			}
			Gear[index][7] = temp;
		}
	}

}

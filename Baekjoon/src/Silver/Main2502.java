package Silver;

import java.util.Scanner;

public class Main2502 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int D = sc.nextInt();
		int K = sc.nextInt();
		// ù��° ���� a, �ι�° ���� b��� �������� ��,
		// [i][0] �� i��° ���� a�� ������ �˷��ְ�
		// [i][1] �� i��° ���� b�� ������ �˷��ش�.
		String[][] arr= new String[D][2];
		// �迭���� 0��° ���� a�� ������ �Ѱ�, 1��° ���� b�� ������ 1���̱�
		// ������ �迭�� �ʱⰪ�� �Ʒ��� ���� �����Ѵ�.
		arr[0][0] = "a";
		arr[0][1] = "";
		arr[1][0] = "";
		arr[1][1] = "b";
		// �Ǻ���ġ ������ ���ǿ� ���� ������ �迭�� ���ڸ� �־��ش�.
		for(int i = 2 ; i < D ; i++) {
			arr[i][0] = arr[i-1][0] + arr[i-2][0];
			arr[i][1] = arr[i-1][1] + arr[i-2][1];
		}
		// �Ǹ����� ���� a,b�� ������ ���ڷ� ��ȯ�Ѵ�.
		int a = countChar(arr[D-1][0], 'a');
		int b = countChar(arr[D-1][1], 'b');
		// �ᱹ �� ������ ���� a,b �� ������ ���� �ڿ����� ���༭ �� ����
		// K�� ���� ���� ������̹Ƿ� �װ��� ���� �˰����� �ۼ��ϸ� �ȴ�.
		for(int i = 1 ; i < K/a ; i++) {
			for(int j = 1 ; j < K/b ; j++) {
				if(a*i + b*j == K) {
					System.out.println(i);
					System.out.println(j);
					System.exit(0);
				}
			}
		}
	}
	//��� ���ڿ����� Ư�� ������ ������ ��ȯ�ϴ� �޼���
	public static int countChar(String str, char ch) {
		return str.length() - str.replace(String.valueOf(ch), "").length();
	}
	
}

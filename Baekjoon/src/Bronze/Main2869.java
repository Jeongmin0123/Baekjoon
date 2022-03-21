package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2869 {

	public static void main(String[] args) throws IOException {
		// �ð� ������ ���߱� ���Ͽ� BufferedReader�� ����Ѵ�.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// ������ �������� �Է¹޴´�.
		int up = Integer.parseInt(st.nextToken());
		int down = Integer.parseInt(st.nextToken());
		int length = Integer.parseInt(st.nextToken());
		// �ɸ� �ϼ��� �ö󰡾��ϴ� ���̸� �Ϸ翡 �ö� �� �ִ� �Ÿ��� ���� ���� ���̴�.
		// �� ��, �ö󰡾� �ϴ� ���̿��� �̲������� ���̸� ���� ������ ������ ���� �ö󰡱⸸ �ϹǷ� �ᱹ �� �ö󰡾ߵǴ� ���̴� length - down �� �ȴ�.
		int day = (length - down)/(up - down);
		if((length - down)%(up - down) != 0) day++;
		System.out.println(day);
	}
}

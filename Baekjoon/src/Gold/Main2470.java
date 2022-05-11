package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2470 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Scanner ���� �ð��ʰ��� �����Ƿ� BufferedReader�� ����Ѵ�.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] sol = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
  	   	for (int i = 0; i < n; i++) {
  	   		sol[i] = Integer.parseInt(st.nextToken());
  	   	}
  	   	// �� ����� ������ ��, ph�� 0���� ���� �־����� ���� �Ѵ� -1000000000�̳� 1000000000�� ���̹Ƿ� �� ��츦 min������ �д�.
  	   	int min = 2000000000;
  	   	Arrays.sort(sol);
  	   	// ������
  	   	int start = 0;
  	   	// ����
  	   	int end = n-1;
  	   	int sol1 = 0;
  	   	int sol2 = 0;
  	   	while(start < end) {
  	   		// �� ����� ���� ���� min������ ������ min���� ��ü�ϰ� �� ���� ��ġ���� sol1, sol2�� �д�.
  	   		if(Math.abs(sol[start] + sol[end]) < min) {
  	   			min = Math.abs(sol[start] + sol[end]);
  	   			sol1 = sol[start];
  	   			sol2 = sol[end];
  	   		}
  	   		// �� ����� ���� ���� 0���� ũ��, ���� ���� �� �������� ����� �ϹǷ� end���� ���̰� �� �ݴ�� start ���� �ø���.
  	   		if(sol[start] + sol[end] > 0) {
  	   			end--;
  	   		} else {
  	   			start++;
  	   		}   
  	   	}
  	   	System.out.println(sol1 + " " + sol2);
	}

}
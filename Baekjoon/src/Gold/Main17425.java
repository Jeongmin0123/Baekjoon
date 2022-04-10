package Gold;

import java.util.*;
import java.io.*;

public class Main17425 {
	// ������ ������ 100000�����̹Ƿ� �迭�� ������ 100001������ �����Ѵ�.
	// �� ��, prime_sum[i]�� i�� ������� ���� �����ϰ�
	// sum[i]�� i������ prime_sum���� ���� �����Ѵ�.
	public static long[] prime_sum = new long[100001];
	public static long[] sum = new long[100001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		divisor_sum();
		int t = Integer.parseInt(bf.readLine());
		while(t--> 0) { 
			int n = Integer.parseInt(bf.readLine());
			bw.write(sum[n]+"\n"); 
		}
		bw.flush();
	}
	// ������ ���ڿ� ���� ������� �հ� �� ���ڱ��� ������� ���� ��ȯ�ϴ� �޼���
	// ����� ����� ������迡 �����Ƿ� �̸� �̿��Ѵ�.
	// ���� ���, 4�� 2�� ����̰�, 6 ���� 2�� ����̴�. �׷��ٸ� 4�� 6�� 2�� ����� �����Ƿ�
	// 2�� ����� �տ� �����ش�. �̷��� ����� ����ϸ� ����� ���� ���� �� �ִ�.
	public static void divisor_sum() {
		// 0�� ����� �����Ƿ� 0���� �����Ѵ�.
		prime_sum[0] = 0;
		// ��� ���ڴ� 1�� ����� �����Ƿ� ����� ���� ������ 1�� �� �����Ѵ�.
		for(int i = 1 ; i < prime_sum.length ; i++) {
			prime_sum[i] = 1;
		}
		// 2���� 100000���� 2�� ���, 3�� ���, 4�� ���.... �� ���Ͽ� 2,3,4....�� ����� �����Ƿ�
		// ����� �տ� ������ �����ش�.
		for(int i = 2 ; i < prime_sum.length ; i++) {
			for(int j = 1 ; i * j < prime_sum.length ; j++) {
				prime_sum[i*j] += i;
			}
		}
		sum[0] = 0;
		// 1~i������ ���ڵ��� ����� ���� ���� i-1������ �տ� i��° ������ ����� ���� ���ѰͰ� ����.
		for(int i = 1 ; i < sum.length ; i++) {
			sum[i] = sum[i-1] + prime_sum[i];
		}
	}
}

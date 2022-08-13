package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15686 {
	
	public static int N,M;
	public static ArrayList<int[]> homes;
	public static ArrayList<int[]> chickens;
	public static int[] candidate;
	public static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// ���� ��ǥ�� �����ϴ� ����Ʈ
		homes = new ArrayList<>();
		// ġŲ���� ��ǥ�� �����ϴ� ����Ʈ
		chickens = new ArrayList<>();
		// ġŲ�� ��ǥ�� ��Ƴ��� ����Ʈ���� �ĺ��� ��ǥ�� �ε���
		candidate = new int[M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < N ; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 0) {
					continue;
				} else if(temp == 1) {
					homes.add(new int[] {i,j});
				} else {
					chickens.add(new int[] {i,j});
				}
			}
		}
		comb(0,0);
		System.out.println(result);
	}
	
	// ġŲ�� �ĺ����� �����ϴ� �޼���
	public static void comb(int cnt, int start) {
		if(cnt == M) {
			result = Math.min(result, calc());
			return;
		}
		for(int i = start ; i < chickens.size() ; i++) {
			candidate[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
	
	// ġŲ�Ÿ��� ����ϴ� �޼���
	public static int calc() {
		int[] distance = new int[homes.size()];
		Arrays.fill(distance, Integer.MAX_VALUE);
		for(int i = 0 ; i < homes.size() ; i++) {
			for(int j = 0 ; j < candidate.length ; j++) {
				int r = chickens.get(candidate[j])[0];
				int c = chickens.get(candidate[j])[1];
				distance[i] = Math.min(distance[i], Math.abs(homes.get(i)[0]-r) + Math.abs(homes.get(i)[1] - c));
			}
		}
		int total = 0;
		for(int i : distance) {
			total += i;
		}
		return total;
	}
}

package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1475 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int[] counts = new int[10];
		for(int i = 0 ; i < input.length() ; i++) {
			int idx = input.charAt(i) - '0';
			counts[idx]++;
		}
		int max = 0;
		int temp = counts[6] + counts[9];
		if(temp % 2 == 0) {
			counts[6] = counts[9] = temp/2;
		} else {
			counts[6] = counts[9] = temp/2 + 1;
		}
		for(int i = 0 ; i < 10 ; i++) {
			max = Math.max(max, counts[i]);
		}
		System.out.println(max);
	}

}

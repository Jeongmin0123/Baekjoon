package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2470 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Scanner 사용시 시간초과가 나오므로 BufferedReader를 사용한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] sol = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
  	   	for (int i = 0; i < n; i++) {
  	   		sol[i] = Integer.parseInt(st.nextToken());
  	   	}
  	   	// 두 용액을 섞었을 때, ph가 0에서 가장 멀어지는 경우는 둘다 -1000000000이나 1000000000일 때이므로 그 경우를 min값으로 둔다.
  	   	int min = 2000000000;
  	   	Arrays.sort(sol);
  	   	// 시작점
  	   	int start = 0;
  	   	// 끝점
  	   	int end = n-1;
  	   	int sol1 = 0;
  	   	int sol2 = 0;
  	   	while(start < end) {
  	   		// 두 용액을 섞은 값이 min값보다 작으면 min값을 대체하고 그 때의 위치값을 sol1, sol2로 둔다.
  	   		if(Math.abs(sol[start] + sol[end]) < min) {
  	   			min = Math.abs(sol[start] + sol[end]);
  	   			sol1 = sol[start];
  	   			sol2 = sol[end];
  	   		}
  	   		// 두 용액을 섞은 값이 0보다 크면, 양의 값이 더 작은것을 섞어야 하므로 end값을 줄이고 그 반대는 start 값을 늘린다.
  	   		if(sol[start] + sol[end] > 0) {
  	   			end--;
  	   		} else {
  	   			start++;
  	   		}   
  	   	}
  	   	System.out.println(sol1 + " " + sol2);
	}

}
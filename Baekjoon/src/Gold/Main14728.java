package Gold;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14728 {

	public static int N,T;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
	}
	
}

/* public static int max = Integer.MIN_VALUE;
public static int N,T;
public static int[] expectTime;
public static int[] score;
public static boolean[] used;

public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	N = Integer.parseInt(st.nextToken());
	T = Integer.parseInt(st.nextToken());
	expectTime = new int[N];
	score = new int[N];
	used = new boolean[N];
	for(int i = 0 ; i < N ; i++) {
		st = new StringTokenizer(br.readLine(), " ");
		expectTime[i] = Integer.parseInt(st.nextToken());
		score[i] = Integer.parseInt(st.nextToken());
	}
	subset(0,0,0);
	System.out.println(max);
}

public static void subset(int idx, int sum, int time) {
	if(time > T) {
		return;
	}
	
	max = Math.max(max, sum);

	if(idx == N) {
		return;
	}
	
	used[idx] = true;
	subset(idx+1, sum+score[idx], time + expectTime[idx]);
	used[idx] = false;
	subset(idx+1, sum, time);
}
*/


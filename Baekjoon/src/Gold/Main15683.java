package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main15683 {

	// cctv의 좌표와 번호를 저장하는 클래스
	static class cctv {
		int r;
		int c;
		int num;
		
		public cctv(int num, int r, int c) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
		}
	}
	
	public static int R,C;
	public static int[][] map;
	public static int[][] copy;
	// 주어진 모든 cctv를 저장하는 arraylist
	public static ArrayList<cctv> cctvlist = new ArrayList<>();
	public static int[] dirs;
	public static int[][] move = {{-1,0},{0,1},{1,0},{0,-1}};
	public static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for(int i = 0 ; i < R ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 0이나 6이 아니면 cctv이므로 cctv arraylist에 넣어준다.
				if(map[i][j] != 0 && map[i][j] != 6) cctvlist.add(new cctv(map[i][j],i,j));
			}
		}
		// 각각의 cctv 방향을 저장하기 위한 배열
		dirs = new int[cctvlist.size()];
		dfs(cctvlist.size(), 0);
		System.out.println(answer);
	}
	
	// 각각의 cctv에 대하여 방향을 지정해주고, 다 지정하면 그 지정값에 대한 사각지대의 크기를 구한다.
	public static void dfs(int end, int depth) {
		if(depth == end) {
			// 원본 배열에 연산을 진행하게 되면 다음 연산시에 연산이 꼬이므로 새로 copy 배열을 만들어 사용한다.
			copy = new int[R][C];
			for(int i = 0 ; i < R ; i++) {
				for(int j = 0 ; j < C ; j++) {
					copy[i][j] = map[i][j];
				}
			}
			// 주어진 cctv와 그 방향에 대하여 copy 배열을 바꿔주는 메서드
			calc();
			// 사각지대의 개수를 구하는 메서드
			checkcount();
			return;
		}
		for(int i = 0 ; i < 4 ; i++) {
			dirs[depth] = i;
			dfs(end, depth+1);
		}
	}
	
	public static void calc() {
		for(int i = 0 ; i < cctvlist.size() ; i++) {
			cctv now = cctvlist.get(i);
			int d = dirs[i];
			// 각각의 cctv와 그 방향을 고려하여 감시구역인 경우, 그 지역의 값을 바꿔준다.
			if(now.num == 1) {
				if(d==0) {
					remove(now,0);
				} else if(d==1) {
					remove(now,1);
				} else if(d==2) {
					remove(now,2);
				} else {
					remove(now,3);
				}
			} else if(now.num == 2) {
				if(d==0 || d==2) {
					remove(now,0);
					remove(now,2);
				} else {
					remove(now,1);
					remove(now,3);
				}
			} else if(now.num == 3) {
				if(d==0) {
					remove(now,0);
					remove(now,1);
				} else if(d==1) {
					remove(now,1);
					remove(now,2);
				} else if(d==2) {
					remove(now,2);
					remove(now,3);
				} else {
					remove(now,3);
					remove(now,0);
				}
			} else if(now.num == 4) {
				if(d==0) {
					remove(now,0);
					remove(now,1);
					remove(now,2);
				} else if(d==1) {
					remove(now,1);
					remove(now,2);
					remove(now,3);
				} else if(d==2) {
					remove(now,2);
					remove(now,3);
					remove(now,0);
				} else {
					remove(now,3);
					remove(now,0);
					remove(now,1);
				}
			} else if(now.num == 5) {
				remove(now,0);
				remove(now,1);
				remove(now,2);
				remove(now,3);
			}
		}
	}
	
	// 한 cctv에 대하여 방향값과 그 cctv의 위치값을 통해 감시구역의 값을 -1로 바꿔주는 메서드
	public static void remove(cctv now, int dir) {
		int dr = now.r + move[dir][0];
		int dc = now.c + move[dir][1];
		while(true) {
			if(!isValid(dr,dc) || copy[dr][dc] == 6) break;
			if(copy[dr][dc] == 0) {
				copy[dr][dc] = -1;
			}
			dr += move[dir][0];
			dc += move[dir][1];
		}
	}
	
	// 이동한 지점이 배열 안에 있는지 판단하는 메서드
	public static boolean isValid(int r, int c) {
		if(r < 0 || c < 0 || r >= R || c >= C) return false;
		return true;
	}
	
	// 최소 사각 지대의 개수를 갱신하는 메서드
	public static void checkcount() {
		int count = 0;
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				if(copy[i][j] == 0) count++;
			}
		}
		answer = Math.min(answer, count);
	}
}

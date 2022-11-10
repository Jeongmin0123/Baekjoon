package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main15683 {

	// cctv�� ��ǥ�� ��ȣ�� �����ϴ� Ŭ����
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
	// �־��� ��� cctv�� �����ϴ� arraylist
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
				// 0�̳� 6�� �ƴϸ� cctv�̹Ƿ� cctv arraylist�� �־��ش�.
				if(map[i][j] != 0 && map[i][j] != 6) cctvlist.add(new cctv(map[i][j],i,j));
			}
		}
		// ������ cctv ������ �����ϱ� ���� �迭
		dirs = new int[cctvlist.size()];
		dfs(cctvlist.size(), 0);
		System.out.println(answer);
	}
	
	// ������ cctv�� ���Ͽ� ������ �������ְ�, �� �����ϸ� �� �������� ���� �簢������ ũ�⸦ ���Ѵ�.
	public static void dfs(int end, int depth) {
		if(depth == end) {
			// ���� �迭�� ������ �����ϰ� �Ǹ� ���� ����ÿ� ������ ���̹Ƿ� ���� copy �迭�� ����� ����Ѵ�.
			copy = new int[R][C];
			for(int i = 0 ; i < R ; i++) {
				for(int j = 0 ; j < C ; j++) {
					copy[i][j] = map[i][j];
				}
			}
			// �־��� cctv�� �� ���⿡ ���Ͽ� copy �迭�� �ٲ��ִ� �޼���
			calc();
			// �簢������ ������ ���ϴ� �޼���
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
			// ������ cctv�� �� ������ ����Ͽ� ���ñ����� ���, �� ������ ���� �ٲ��ش�.
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
	
	// �� cctv�� ���Ͽ� ���Ⱚ�� �� cctv�� ��ġ���� ���� ���ñ����� ���� -1�� �ٲ��ִ� �޼���
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
	
	// �̵��� ������ �迭 �ȿ� �ִ��� �Ǵ��ϴ� �޼���
	public static boolean isValid(int r, int c) {
		if(r < 0 || c < 0 || r >= R || c >= C) return false;
		return true;
	}
	
	// �ּ� �簢 ������ ������ �����ϴ� �޼���
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

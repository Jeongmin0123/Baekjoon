package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main17144 {

	public static int R,C,T;
	public static int[][] map;
	public static int[][] dxdy = {{-1,0},{0,1},{1,0},{0,-1}};
	public static int[][] dxdy2 = {{1,0},{0,1},{-1,0},{0,-1}};
	public static ArrayList<int[]> air;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		// 공기청정기의 위치를 받아와 저장한다.
		air = new ArrayList<>();
		for(int i = 0 ; i < R ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					air.add(new int[] {i,j});
				}
			}
		}
		Rotation(T);
		int sum = 0;
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				if(map[i][j] != -1) {
					sum += map[i][j];
				}
			}
		}
		System.out.println(sum);
	}
	
	// 확산을 위한 메서드
	public static void spread() {
		int[][] spreadMap = new int[R][C];
		for(int x = 0 ; x < R ; x++) {
			for(int y = 0 ; y < C ; y++) {
				int cnt = 0;
				for(int i = 0 ; i < 4 ; i++) {
					int dx = x + dxdy[i][0];
					int dy = y + dxdy[i][1];
					// 사방면에 대하여 확산이 가능한 위치면 확산 시킨뒤에 cnt를 1 증가시킨다. 즉 ,cnt는 한 지점에서 확산된 주변 지점의 개수이다.
					if(isValid(dx,dy)) {
						spreadMap[dx][dy] += map[x][y]/5;
						cnt++;
					}
				}
				// 확산되고 남은 값을 원래 지점에 넣어준다,
				map[x][y] -= (map[x][y]/5)*cnt;
			}
		}
		// 각각의 위치에 확산된 값과 남은 먼지의 값을 더해준다.
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				map[i][j] += spreadMap[i][j];
			}
		}
	
	}
	// 맵 범위내에 존재하고 그 위치가 공기청정기가 아니면 확산 가능하다.
	public static boolean isValid(int x, int y) {
		if(x >= R || x < 0 || y < 0 || y >= C || map[x][y] == -1) return false;
		return true;
	}
	
	// 한번 돌때마다 확산시켜 준 뒤에 공기청정기 두 칸을 기준으로 위아래 각가 회전시켜준다
	public static void Rotation(int T) {
		for(int tc = 0 ; tc < T ; tc++) {
			spread();
			// 공기청정기가 위치하는 곳중 위의 값을 x,y에 넣어준다.
			int x = air.get(0)[0];
			int y = air.get(0)[1];
			int idx = 0;
			while(true) {
				if(idx == 4) break;
				int dx = x + dxdy[idx][0];
				int dy = y + dxdy[idx][1];
				// 회전 가능하면 x,y쪽으로 한칸식 당겨준다.
				if(isValidRotation(dx, dy)) {
					map[x][y] = map[dx][dy];
					x = dx;
					y = dy;
				// 불가능하면 회전 방향을 바꾼다.
				} else {
					idx++;
				}
			}
			// 회전이 다 끝나면 공기 청정기의 위치는 다스 0으로 바꿔주고, 공기청정기에서 나온 값은 0으로 바꿔준다.
			map[air.get(0)[0]][air.get(0)[1]] = -1;
			map[air.get(0)[0]][air.get(0)[1]+1] = 0;
			// 공기청정기가 위치하는 곳중 아래의 값을 x,y에 넣어준다.
			x = air.get(1)[0];
			y = air.get(1)[1];
			idx = 0;
			while(true) {
				if(idx == 4) break;
				int dx = x + dxdy2[idx][0];
				int dy = y + dxdy2[idx][1];
				// 회전 가능하면 x,y쪽으로 한칸식 당겨준다.
				if(isValidRotation2(dx, dy)) {
					map[x][y] = map[dx][dy];
					x = dx;
					y = dy;
				// 불가능하면 회전 방향을 바꾼다.
				} else {
					idx++;
				}
			}
			map[air.get(1)[0]][air.get(1)[1]] = -1;
			map[air.get(1)[0]][air.get(1)[1]+1] = 0;
		}
	}
	// 공기청정기 두 칸을 기준으로 위의 값들이 회전 가능한 경우를 판단하는 메서드
	public static boolean isValidRotation(int x, int y) {
		if(x > air.get(0)[0] || x < 0 || y < 0 || y >= C) return false;
		return true;
	}
	// 공기청정기 두 칸을 기준으로 아래의 값들이 회전 가능한 경우를 판단하는 메서드
	public static boolean isValidRotation2(int x, int y) {
		if(x < air.get(1)[0] || x >=R || y < 0 || y >= C) return false;
		return true;
	}
	
}


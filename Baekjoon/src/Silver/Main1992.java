package Silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1992 {
	
	public static int[][] map;
	public static int N;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			String s = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		QuadTree(0,0,N);
		System.out.println(sb);
	}
	public static void QuadTree(int x, int y, int size) {
		if(isValid(x,y,size)) {
			sb.append(map[x][y]);
			return;
		}
		int part_size = size/2;
		sb.append("(");
		QuadTree(x, y, part_size);
		QuadTree(x, y+part_size, part_size);
		QuadTree(x+part_size, y, part_size);
		QuadTree(x+part_size, y+part_size, part_size);
		sb.append(")");
	}
	public static boolean isValid(int x, int y, int size) {
		int check = map[x][y];
		for(int i = x ; i < x + size ; i++) {
			for(int j = y ; j < y + size ; j++) {
				if(map[i][j] != check) {
					return false;
				}
			}
		}
		return true;
	}
}


package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main2239 {

	static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static int[][] map;
	public static ArrayList<Node> checklist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		checklist = new ArrayList<>();
		for(int i = 0 ; i < 9 ; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j = 0 ; j < 9 ; j++) {
				map[i][j] = temp[j]-'0';
				// 받아온 숫자가 0인 경우 숫자를 채워줘야 하므로 ArrayList에 저장하여 추후에 사용한다.
				if(map[i][j] == 0) {
					checklist.add(new Node(i,j));
				}
			}
		}
		play(0);
	}
	// 채워줄 빈칸의 순서를 파라미터로 받아온다.
	public static void play(int cnt) {
		// 만약 모든 0인 칸을 채워줬다면 그 map을 출력한다.
		if(cnt == checklist.size()) {
			print();
			System.exit(0);
		}
		// 채워줘야 할 빈칸을 받아온다.
		Node cur = checklist.get(cnt);
		int x = cur.x;
		int y = cur.y;
		// 1부터 9까지 빈칸에 들어갈 수 있는 숫자를 저장하기 위한 boolean 배열을 만든다.
		boolean[] num = new boolean[10];
		// 그 빈칸의 가로를 고려하여 들어갈 수 없는 수를 가지치기 한다.
		for(int i = 0 ; i < 9 ; i++) {
			if(map[x][i] != 0) {
				num[map[x][i]] = true;
			}
		}
		// 그 빈칸의 세로를 고려하여 들어갈 수 없는 수를 가지치기 한다.
		for(int i = 0 ; i < 9 ; i++) {
			if(map[i][y] != 0) {
				num[map[i][y]] = true;
			}
		}
		// 그 빈칸이 포함된 사각형을 고려하여 들어갈 수 없는 수를 가지치기 한다.
		int X = (x/3)*3;
		int Y = (y/3)*3;
		for(int i = X ; i < X+3 ; i++) {
			for(int j = Y ; j < Y+3 ; j++) {
				if(map[i][j] != 0) {
					num[map[i][j]] = true;
				}
			}
		}
		// 1부터 9중에 들어갈 수 있는 숫자가 존재하는 경우, 그 숫자를 넣어준 뒤에 그 다음 순서의 좌표를 탐색한다.
		for(int i = 1 ; i < 10 ; i++) {
			if(!num[i]) {
				// 재귀함수
				map[x][y] = i;
				play(cnt+1);
				map[x][y] = 0;
			}
		}
	}
	// 빈칸을 다 채웠을 때, print를 위한 함수
	public static void print() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < 9 ; i++) {
			for(int j = 0 ; j < 9 ; j++) {
				sb.append(map[i][j]);
				System.out.println();
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}


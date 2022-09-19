package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main15685 {

	// ���� ��ġ, ����, ���븦 �����ϴ� Ŭ����
	static class Node {
		int x;
		int y;
		int dir;
		int gen;
		
		public Node(int x, int y, int dir, int gen) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.gen = gen;
		}
	}
	
	public static Node[] nodelist;
	public static boolean[][] map;
	// 0,1,2,3 ���� ������ �����δ�. �������
	public static int[][] move = {{0,1},{-1,0},{0,-1},{1,0}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		nodelist = new Node[N];
		map = new boolean[101][101];
		StringTokenizer st;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int gen = Integer.parseInt(st.nextToken());
			nodelist[i] = new Node(y,x,dir,gen);
		}
		// N���� �巡�� Ŀ�긦 �׷� map�� �湮ó�� �Ѵ�.
		for(int i = 0 ; i < N ; i++) {
			fill(nodelist[i]);
		}
		int result = count();
		System.out.println(result);
	}
	
	public static void fill(Node node) {
		int gen = node.gen;
		// �巡�� Ŀ��� ���� ���� ������ �������� ����ؼ� ������ �߰��ȴ�. ���� ���� ������ ������ list�� �����.
		ArrayList<Integer> dirList = new ArrayList<>();
		// ��� �巡�� Ŀ��� 0���밡 �⺻�̹Ƿ� 0���뿡 ���� ������ �湮ó���Ѵ�.
		// ������
		map[node.x][node.y] = true;
		int lastX = node.x + move[node.dir][0];
		int lastY = node.y + move[node.dir][1];
		// 0������ ����
		map[lastX][lastY] = true;
		dirList.add(node.dir);
		
		// �������ŭ �ݺ��Ѵ�.
		while(gen-- > 0) {
			// ���� ���� ������ �������� ����ؼ� ������ �߰������ش�.
			for(int i = dirList.size() - 1 ; i >= 0 ; i--) {
				// ������ ���� ���⿡�� 90�� ȸ�� ��Ų ���̹Ƿ� dirList.get(i)+1�� ���´�. ��, 4�� ������ �ȵǹǷ� 4�� ���� �� �������� �޾ƿ´�.
				int dir = (dirList.get(i)+1)%4;
				lastX += move[dir][0];
				lastY += move[dir][1];
				map[lastX][lastY] = true;
				dirList.add(dir);
			}
		}
	}
	
	// ���簢���� ������ ���� �޼���
	public static int count() {
		int result = 0;
		for(int i = 0 ; i < 100 ; i++) {
			for(int j = 0 ; j < 100 ; j++) {
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) result++;
			}
		}
		return result;
	}
	
}

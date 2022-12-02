package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main22944 {

   static class Node {
      int r;
      int c;
      int time;
      int health;
      int umbrella;
      int count;
      public Node(int r, int c, int time, int health, int umbrella,int count) {
         super();
         this.r = r;
         this.c = c;
         // �ɸ� �ð�
         this.time = time;
         // ���� ü��
         this.health = health;
         // ���� ����� ������
         this.umbrella = umbrella;
         // ������� ����� ����� ��
         this.count = count;
      }
   }
   // K : ������ �����ϴ� ����� �� ����
   public static int N,H,D,K;
   public static int result = -1;
   public static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
   public static char[][] map;
   public static boolean[][][] visited;
   public static Queue<Node> q;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      N = Integer.parseInt(st.nextToken());
      H = Integer.parseInt(st.nextToken());
      D = Integer.parseInt(st.nextToken());
      map = new char[N][N];
      q = new ArrayDeque<>();
      for(int i = 0 ; i < N ; i++) {
         String temp = br.readLine();
         for(int j = 0 ; j < N ; j++) {
            map[i][j] = temp.charAt(j);
            if(map[i][j] == '.') {
               continue;
            } else if(map[i][j] == 'U') {
               // ����� �Է����� ������ ����� �� ������ ������Ų��.
               K++;
            } else if(map[i][j] == 'S') {
               // �������� Queue�� �־��ش�.
               q.offer(new Node(i,j,0,H,0,0));
            }
         }
      }
      // �湮ó���� ���� �迭, �̶�, ������� ����� ����� ������ ���� �湮ó���� �ٸ��� ���־�� �ϹǷ� 3���� �迭�� ������ش�.
      visited = new boolean[N][N][K+1];
      bfs();
      System.out.println(result);
   }
   
   public static void bfs() {
      while(!q.isEmpty()) {
         Node cur = q.poll();
         // ���� ������ �������̰� ü���� ���� ä�� �����ߴٸ� �ּ� �̵� Ƚ���� �ʱ�ȭ�Ѵ�.
         if(map[cur.r][cur.c] == 'E') {
            if(cur.health >= 0) {
               result = cur.time;
               return;
            }
         }
         // ���� ü���� 0���� �۴ٸ� �׾����Ƿ� ���� ������ �����Ѵ�.
         if(cur.health < 0) continue;
         for(int i = 0 ; i < 4 ; i++) {
            int dr = cur.r + move[i][0];
            int dc = cur.c + move[i][1];
            if(!isValid(dr,dc)) continue;
            // �̵��� ������ ����� ���
            if(map[dr][dc] == 'U') {
               // �湮���� ���� ��쿡�� �����Ѵ�.
               if(!visited[dr][dc][cur.count]) {
                  // ����� �������� �����ִ� ���
                  if(cur.umbrella > 0) {
                     // ����� ���ƾ��� �湮ó���� �����Ѵ�. �� ��, ����� �������� ���������Ƿ� ���� ü���� ���� �ʴ´�.
                     q.offer(new Node(dr,dc,cur.time+1,cur.health,D,cur.count+1));
                     visited[dr][dc][cur.count] = true;
                     map[dr][dc] = '.';
                     // ����� �������� �������� ���� ���
                  } else {
                     // ����� ���ƾ��� �湮ó���� �����Ѵ�. �� ��, ����� �������� 0�̹Ƿ� ���� ü���� 1 �����Ѵ�.
                     q.offer(new Node(dr,dc,cur.time+1,cur.health - 1,D,cur.count+1));
                     visited[dr][dc][cur.count] = true;
                     map[dr][dc] = '.';
                  }
               }
            // �̵��� ������ ����� �ƴ� ���
            } else {
               // �湮���� ���� ��쿡�� �����Ѵ�.
               if(!visited[dr][dc][cur.count]) {
                  if(cur.umbrella > 0) {
                     q.offer(new Node(dr,dc,cur.time+1,cur.health,cur.umbrella-1,cur.count));
                     visited[dr][dc][cur.count] = true;
                  } else {
                     q.offer(new Node(dr,dc,cur.time+1,cur.health - 1,cur.umbrella,cur.count));
                     visited[dr][dc][cur.count] = true;
                  }
               }
            }
         }
      }
   }
   // �湮�� ������ �迭�� ������� �Ǵ��ϴ� �޼���
   public static boolean isValid(int r, int c) {
      if(r < 0 || c < 0 || r >= N || c >= N) return false;
      return true;
   }
}
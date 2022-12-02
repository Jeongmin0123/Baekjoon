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
         // 걸린 시간
         this.time = time;
         // 현재 체력
         this.health = health;
         // 남은 우산의 내구도
         this.umbrella = umbrella;
         // 현재까지 사용한 우산의 수
         this.count = count;
      }
   }
   // K : 지도에 존재하는 우산의 총 개수
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
               // 우산이 입력으로 들어오면 우산의 총 개수를 증가시킨다.
               K++;
            } else if(map[i][j] == 'S') {
               // 시작점을 Queue에 넣어준다.
               q.offer(new Node(i,j,0,H,0,0));
            }
         }
      }
      // 방문처리를 위한 배열, 이때, 현재까지 사용한 우산의 개수에 따라 방문처리를 다르게 해주어야 하므로 3차원 배열로 만들어준다.
      visited = new boolean[N][N][K+1];
      bfs();
      System.out.println(result);
   }
   
   public static void bfs() {
      while(!q.isEmpty()) {
         Node cur = q.poll();
         // 현재 지점이 도착점이고 체력이 남은 채로 도달했다면 최소 이동 횟수를 초기화한다.
         if(map[cur.r][cur.c] == 'E') {
            if(cur.health >= 0) {
               result = cur.time;
               return;
            }
         }
         // 현재 체력이 0보다 작다면 죽었으므로 다음 연산을 진행한다.
         if(cur.health < 0) continue;
         for(int i = 0 ; i < 4 ; i++) {
            int dr = cur.r + move[i][0];
            int dc = cur.c + move[i][1];
            if(!isValid(dr,dc)) continue;
            // 이동한 지점이 우산인 경우
            if(map[dr][dc] == 'U') {
               // 방문하지 않은 경우에만 연산한다.
               if(!visited[dr][dc][cur.count]) {
                  // 우산의 내구도가 남아있는 경우
                  if(cur.umbrella > 0) {
                     // 우산을 갈아쓰고 방문처리를 진행한다. 이 때, 우산의 내구도가 남아있으므로 현재 체력은 줄지 않는다.
                     q.offer(new Node(dr,dc,cur.time+1,cur.health,D,cur.count+1));
                     visited[dr][dc][cur.count] = true;
                     map[dr][dc] = '.';
                     // 우산의 내구도가 남아있지 않은 경우
                  } else {
                     // 우산을 갈아쓰고 방문처리를 진행한다. 이 때, 우산의 내구도가 0이므로 현재 체력이 1 감소한다.
                     q.offer(new Node(dr,dc,cur.time+1,cur.health - 1,D,cur.count+1));
                     visited[dr][dc][cur.count] = true;
                     map[dr][dc] = '.';
                  }
               }
            // 이동한 지점이 우산이 아닌 경우
            } else {
               // 방문하지 않은 경우에만 연산한다.
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
   // 방문한 지점이 배열을 벗어나는지 판단하는 메서드
   public static boolean isValid(int r, int c) {
      if(r < 0 || c < 0 || r >= N || c >= N) return false;
      return true;
   }
}
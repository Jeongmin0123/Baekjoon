package Silver;

import java.util.Scanner;

public class Main1004 {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int T = sc.nextInt();
      int[] result = new int[T];
      for(int i = 0 ; i < T ; i++) {
         int x1 = sc.nextInt();
         int y1 = sc.nextInt();
         int x2 = sc.nextInt();
         int y2 = sc.nextInt();
         int N = sc.nextInt();
         int sum = 0;
         for(int j = 0 ; j < N ; j++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int r = sc.nextInt();
            // 최소 이탈횟수를 sum으로 둔다.
            sum += check(x1, y1, x2, y2, a, b, r);
         }
         result[i] = sum;
      }
      for(int i = 0 ; i < T ; i++) {
         System.out.println(result[i]);
      }
   }
   // x1, y1을 출발점, x2, y2를 도착지점으로 보고 a,b를 원의 중심의 좌표, r은 원의 반지름으로 두고 풀이를 진행한다.
   public static int check(int x1, int y1, int x2, int y2, int a ,int b, int r) {
      // 행성계 간의 이동은 결국 두 점 중에 한점이 행성계 외부, 나머지 한 점은 행성계 내부에 존재하는 경우 일어나므로
      // 두 가지의 경우에는 행성계의 이동횟수가 1증가하므로 1을 반환하고 이외의 경우에는 0을 반환한다.
      // 한 점은 원 내부, 한 점은 원 내부에 존재하기 위해서는 원의 중심과 좌표 사이의 거리가
      // 하나는 반지름보다 커야하고 하나는 작아야 한다.
      if(Math.sqrt(Math.pow(a-x1, 2)+Math.pow(b-y1, 2)) > r && Math.sqrt(Math.pow(a-x2, 2)+Math.pow(b-y2, 2)) < r) {
         return 1;
      } else if(Math.sqrt(Math.pow(a-x2, 2)+Math.pow(b-y2, 2)) > r && Math.sqrt(Math.pow(a-x1, 2)+Math.pow(b-y1, 2)) < r) {
         return 1;
      } else {
         return 0;
      }
   }

}
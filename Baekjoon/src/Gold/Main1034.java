package Gold;

import java.util.Scanner;

public class Main1034 {
   public static int[][] lamp;
   public static int M;
   public static int N;
   public static int K;
   public static String[] temp;
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      N = sc.nextInt();
      M = sc.nextInt();
      lamp = new int[N][M];
      temp = new String[N];
      for(int i = 0 ; i < N ; i++) {
         temp[i] = sc.next();
         for(int j = 0 ; j < M ; j++) {
            // lamp[i][j] = temp[i].charAt(j); 를 사용하지 않는 이유는
            // charAt 함수는 char값을 반환하는 함수이기 때문에 lamp[i][j]에
            // 0이나 1이 아닌 0의 아스키코드 값인 48과 1의 아스키코드 값인 49를
            // 저장하기 때문에 추후 계산에 영향을 주기 때문에 밑의 방식으로 저장한다.
            lamp[i][j] = Integer.parseInt(temp[i].charAt(j)+"");
         }
      }
      K = sc.nextInt();
      System.out.println(max());
   }
   // 켜저있는 행의 최댓값을 구하는 함수
   public static int max() {
      // 각 행에 대하여 그 행을 다 킬수 있는지 없는지에 대한 여부를 저장하는 boolean타입 배열
      boolean[] check = new boolean[N];
      int max = 0;
      for(int i = 0 ; i < N ; i++) {
         // 어떠한 행에 대하여 몇번 눌러서 다 켤수 있는지에 대한 변수이다.
         int count1 = 0;
         for(int j = 0 ; j < M ; j++) {
            // 만약 어떠한 행의 몇번째 열이 0이라면 그 열을 눌러주어 숫자를 바꿔줘야 하므로
            // count1을 1더해준다.
            if(lamp[i][j] == 0) {
               count1++;
            }
         }
         // 모든 스위치는 2번 누르면 원상태로 돌아가므로 어떠한 행과 K에 대하여 2로 나누었을 때
         // 나머지가 같고 count1이 K보다 작거나 같으면 그 행을 켤 수 있기 때문에 check[i]
         // 값을 true값으로 지정한다.
         if(count1 % 2 == K % 2 && count1 <= K) {
            check[i] = true;
         }
      }
      for(int i = 0 ; i < N ; i++) {
         // 그 행을 다 킬수 있는 경우에만 연산을 진행한다.
         if(check[i]) {
            // 킬수 있는 행에 대해서만 그 행과 같은 상태인 행들의 숫자를 반환한다.
            int count2 = 0;
            for(int j = 0 ; j < N ; j++) {
               if(temp[i].equals(temp[j])) {
                  count2++;
               }
            }
            if(count2 > max) {
               max = count2;
            }
         }         
      }
   return max;
   }
}
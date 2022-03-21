package Gold;

import java.util.Scanner;

public class Main1025 {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      int M = sc.nextInt();
      int[][] number = new int[N][M];
      for(int i = 0 ; i < N ; i++) {
         String s = sc.next();
         for(int j = 0 ; j < M ; j++) {
            // 2차원 배열에 값을 넣어줄 때, number[i][j] = s.charAt(j)로 넣어주면
            // 원하는 숫자가 아닌 원래 숫자에 48이 더해진 숫자가 들어간다.
            // 그 이유는 s.charAt()의 return 값이 char 값이며, 아스키 코드를 따르기 때문이다.
            // 아스키코드 표를 보면 잘 알 수 있다.
            number[i][j] = s.charAt(j) - '0';
         }
      }
      int result = max_square(number);
      System.out.println(result);
      sc.close();
   }
   
   // 2차원 배열을 받아서 가장 큰 제곱수를 return 해주는 함수
   public static int max_square(int[][] arr) {
      // 제곱수가 없을 경우 return 값이 -1이므로 맨 처음 max값을 -1으로 지정한다.
      int max = -1;
      for(int i = 0 ; i < arr.length ; i++) {
         for(int j = 0 ; j < arr[0].length ; j++) {
            // 2차원 배열에서 숫자 하나를 골랐는데, 그 숫자가 제곱수일 경우
            // 그 숫자가 max값보다 크면 max값을 재지정한다.
            if(square(arr[i][j]) && arr[i][j] > max) {
               max = arr[i][j];
            }
            // d_i는 2차원 배열에서 행의 증가량, 즉, 행의 공차라고 생각하면 편하다.
            // 동시에 d_j는 2차원 배열에서 열의 증가량, 즉, 열의 공차라고 생각하면 편하다.
            // 이 때, 배열의 i,j번째에 있는 숫자에서 움직일 수 있는 거리는
            // -i < d_i < 배열의 행의 길이 - i, j < d_j < 배열의 열의 길이 - j이다.
            // 위 범위에서 벗어나는 경우 배열 안에 존재할 수 없다.
            for(int d_i = -i; d_i < arr.length-i ; d_i++) {
               for(int d_j = -j ; d_j < arr[0].length - j ; d_j++) {
                  // 공차가 둘다 0인 경우 움직이지 않기 때문에 스킵하고 다음 for문을 진행한다.
                  if(d_i == 0 && d_j == 0) {
                     continue;
                  }
                  int num = 0;
                  int a = i;
                  int b = j;
                  // 배열안에 숫자가 존재해야 하므로 a,b의 범위는 아래와 같다.
                  while (a >= 0 && b >= 0 && a < arr.length && b < arr[0].length) {
                     // num은 숫자가 하나씩 추가될수록 맨뒤에 숫자가 하나씩 붙는 형태이므로
                     // 아래와 같은 식으로 표현된다.
                     num = num*10 + arr[a][b];
                     // num이 제곱수면서 max값보다 클 경우, max값을 교체한다.
                     if(square(num) && num > max) {
                        max = num;
                     }
                     // 공차를 더해주면서 좌표를 이동한다.
                     a = a + d_i;
                     b = b + d_j;
                  }
               }
            }
         }
      }
      return max;
   }
   // 어떠한 숫자가 제곱수인지 아닌지를 판단하는 함수이다.
   public static boolean square(int N) {
      // 에라토스테네스의 체에 의하여 Math.sqrt(N)까지만 계산하면 된다.
      for(int i = 0 ; i <= Math.sqrt(N) ; i++) {
         if(N == i*i) {
            return true;
         }
      }
      return false;
   }

}
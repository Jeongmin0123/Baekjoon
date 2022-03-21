package Gold;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main1038 {
   public static List<Long> list;
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int N  = sc.nextInt();
      list = new ArrayList<Long>();
      // 0 ~ 9 까지의 숫자중에 임의로 몇개를 뽑는다고 가정하면 뽑은 숫자들로 만들 수 있는
      // 감소하는 수는 오직 하나이다. 따라서 감소하는 수의 총 개수는 2^10 - 1 인 1022개이다
      // 이 때, 0은 0번째 감소하는 숫자이므로 N의 범위가 1022보다 클 경우 -1을 출력하고 종료한다.
      if(N > 1022) {
         System.out.println(-1);
         // exit() 메서드는 -1을 출력한 뒤에 프로세시를 정상종료를 시키는 메서드이다.
         System.exit(0);
      }
      // 0부터 9로 시작되는 감소하는 수를 구한다.
      for(int i = 0 ; i < 10 ; i++) {
         add_num(i,1);
      }
      // 계산이 수행되고 나면 list가 정렬되지 않은 상태로 저장되어 있기 때문에 list를 정렬해준다.
      Collections.sort(list);
      System.out.println(list.get(N));
   }
   // 감소하는 수를 구하는 메서드
   public static void add_num(long num, int len) {
	   // 길이가 10보다 클 경우 감소하는 수가 될 수 없기 때문에 함수를 종료한다.
      if(len > 10) return;
      // 만약 위에 return 값에 걸리지 않는다면 밑 문장에 의해서 이미 감소하는 수를 받은 것이기
      // 때문에 이 숫자를 add 함수를 통해 리스트에 저장한다.
      list.add(num);
      // num의 맨 마지막 자리가 i보다 클 경우 num에 10을 곱해준 후 i를 더해주는 방식으로
      // 리스트에 감소하는 수를 추가해준다
      for(int i = 0 ; i < 10 ; i++) {
         if(num % 10 > i) {
            add_num(num*10 + i, len + 1);
         }
      }
   }
/*   시간 초과로 돌아가지 않는 코드
 *    public static ArrayList<Long> list = new ArrayList<Long>();
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int N  = sc.nextInt();
      이 부분에서 1000000000번 수행을 해야하므로 시간초과가 발생한다.
      for(long i = 0 ; i < 1000000000 ; i++) {
         if(decrease_num(i)) {
            list.add(i);
         }
      }
      System.out.println(list.get(N));
   }
   
   public static boolean decrease_num(long N) {
      if(N < 10) return true;
      while(N >= 10) {
         long a = N % 10;
         N = N/10;
         long b = N % 10;
         if(a >= b) return false;
      }
      return true;
   } */
}
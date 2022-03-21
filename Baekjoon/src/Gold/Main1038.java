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
      // 0 ~ 9 ������ �����߿� ���Ƿ� ��� �̴´ٰ� �����ϸ� ���� ���ڵ�� ���� �� �ִ�
      // �����ϴ� ���� ���� �ϳ��̴�. ���� �����ϴ� ���� �� ������ 2^10 - 1 �� 1022���̴�
      // �� ��, 0�� 0��° �����ϴ� �����̹Ƿ� N�� ������ 1022���� Ŭ ��� -1�� ����ϰ� �����Ѵ�.
      if(N > 1022) {
         System.out.println(-1);
         // exit() �޼���� -1�� ����� �ڿ� ���μ��ø� �������Ḧ ��Ű�� �޼����̴�.
         System.exit(0);
      }
      // 0���� 9�� ���۵Ǵ� �����ϴ� ���� ���Ѵ�.
      for(int i = 0 ; i < 10 ; i++) {
         add_num(i,1);
      }
      // ����� ����ǰ� ���� list�� ���ĵ��� ���� ���·� ����Ǿ� �ֱ� ������ list�� �������ش�.
      Collections.sort(list);
      System.out.println(list.get(N));
   }
   // �����ϴ� ���� ���ϴ� �޼���
   public static void add_num(long num, int len) {
	   // ���̰� 10���� Ŭ ��� �����ϴ� ���� �� �� ���� ������ �Լ��� �����Ѵ�.
      if(len > 10) return;
      // ���� ���� return ���� �ɸ��� �ʴ´ٸ� �� ���忡 ���ؼ� �̹� �����ϴ� ���� ���� ���̱�
      // ������ �� ���ڸ� add �Լ��� ���� ����Ʈ�� �����Ѵ�.
      list.add(num);
      // num�� �� ������ �ڸ��� i���� Ŭ ��� num�� 10�� ������ �� i�� �����ִ� �������
      // ����Ʈ�� �����ϴ� ���� �߰����ش�
      for(int i = 0 ; i < 10 ; i++) {
         if(num % 10 > i) {
            add_num(num*10 + i, len + 1);
         }
      }
   }
/*   �ð� �ʰ��� ���ư��� �ʴ� �ڵ�
 *    public static ArrayList<Long> list = new ArrayList<Long>();
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int N  = sc.nextInt();
      �� �κп��� 1000000000�� ������ �ؾ��ϹǷ� �ð��ʰ��� �߻��Ѵ�.
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
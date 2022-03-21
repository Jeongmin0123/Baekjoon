package Gold;

import java.util.Arrays;
import java.util.Scanner;

public class Main1041 {
   // �ֻ����� ���� 6���̴�.
   public static int[] plane = new int[6];
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      long N = sc.nextLong();
      for(int i = 0 ; i < 6 ; i++) {
         plane[i] = sc.nextInt();
      }
      long result = 0;
      // ���� �ֻ����� ������ 1���� ��� �迭�� ������ ��, �� ������ ���ڸ� �� �������� �� ���Ѵ�.
      if(N == 1) {
         Arrays.sort(plane);
         for(int i = 0 ; i < 5 ; i++) {
            result += plane[i];
         }
      }
      else {
         // �׸��� ���� �� 3���� ���̴� �ֻ����� ������ 4��, �� 2���� ���̴� �ֻ����� ������ 8(N-2)+4
         // �� 1���� ���̴� �ֻ����� ������ 5(N-2)(N-2)+4(N-2)�̴�.
         result = min_3(plane)*4 + min_2(plane)*(8*(N-2)+4)+min_1(plane)*(5*(N-2)*(N-2)+4*(N-2));
      }
      System.out.println(String.valueOf(result));
      sc.close();
      
   }
   // 3���� ���̴� ���, 3�� ������ ���� ���� �ּҰ��� ���ϴ� �Լ�
   public static int min_3(int[] arr) {
      int sum = 0;
      // �������� ���ؼ� (A,F), (B,F), (C,D) ���� ���� ¦�� �̷�鼭 ���ֺ��� �Ǵµ�,
      // �ֻ����� 3���� ���̴� ��� ������ �ֿ��� �ϳ��� �鸸 ���δ�.
      // ���� ������ �ֿ��� ���� ������ ���� �����ش�.
      for(int i = 0 ; i < 3 ; i ++) {
         sum += Math.min(arr[i], arr[5-i]);
      }
      return sum;
   }
   // 2���� ���̴� ���, 2�� ������ ���� ���� �ּҰ��� ���ϴ� �Լ�
   public static int min_2(int[] arr) {
      int sum = 0;
      int[] arr_2 = new int[3];
      // ����������, �� ��쵵 �������� ���ؼ� (A,F), (B,F), (C,D)
      // ���� ���� ¦�� �̷�鼭 ���ֺ��� �Ǵµ�, �ֻ����� 2���� ���̴� ���
      // 3���� �ֿ��� 2���� ���� ���̰� �ȴ�.
      // ���� ������ �ֿ��� ���� ������ ���� �ڿ� ���� ū ���� ���� �����ָ� �ּҰ��� �����Եȴ�.
      for(int i = 0 ; i < 3 ; i++) {
         arr_2[i] = Math.min(arr[i], arr[5-i]);
      }
      Arrays.sort(arr_2);
      for(int i = 0 ; i < 2 ; i++) {
         sum += arr_2[i];
      }
      return sum;
   }
   // 1���� ���̴� ���, 1�� ������ ���� ���� �ּҰ��� ���ϴ� �Լ�
   public static int min_1(int[] arr) {
      // ������ �� �迭�� ���� �հ��� �����Ѵ�.
      Arrays.sort(arr);
      return arr[0];
   }
}
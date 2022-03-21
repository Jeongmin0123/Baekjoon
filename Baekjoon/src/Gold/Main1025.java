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
            // 2���� �迭�� ���� �־��� ��, number[i][j] = s.charAt(j)�� �־��ָ�
            // ���ϴ� ���ڰ� �ƴ� ���� ���ڿ� 48�� ������ ���ڰ� ����.
            // �� ������ s.charAt()�� return ���� char ���̸�, �ƽ�Ű �ڵ带 ������ �����̴�.
            // �ƽ�Ű�ڵ� ǥ�� ���� �� �� �� �ִ�.
            number[i][j] = s.charAt(j) - '0';
         }
      }
      int result = max_square(number);
      System.out.println(result);
      sc.close();
   }
   
   // 2���� �迭�� �޾Ƽ� ���� ū �������� return ���ִ� �Լ�
   public static int max_square(int[][] arr) {
      // �������� ���� ��� return ���� -1�̹Ƿ� �� ó�� max���� -1���� �����Ѵ�.
      int max = -1;
      for(int i = 0 ; i < arr.length ; i++) {
         for(int j = 0 ; j < arr[0].length ; j++) {
            // 2���� �迭���� ���� �ϳ��� ����µ�, �� ���ڰ� �������� ���
            // �� ���ڰ� max������ ũ�� max���� �������Ѵ�.
            if(square(arr[i][j]) && arr[i][j] > max) {
               max = arr[i][j];
            }
            // d_i�� 2���� �迭���� ���� ������, ��, ���� ������� �����ϸ� ���ϴ�.
            // ���ÿ� d_j�� 2���� �迭���� ���� ������, ��, ���� ������� �����ϸ� ���ϴ�.
            // �� ��, �迭�� i,j��°�� �ִ� ���ڿ��� ������ �� �ִ� �Ÿ���
            // -i < d_i < �迭�� ���� ���� - i, j < d_j < �迭�� ���� ���� - j�̴�.
            // �� �������� ����� ��� �迭 �ȿ� ������ �� ����.
            for(int d_i = -i; d_i < arr.length-i ; d_i++) {
               for(int d_j = -j ; d_j < arr[0].length - j ; d_j++) {
                  // ������ �Ѵ� 0�� ��� �������� �ʱ� ������ ��ŵ�ϰ� ���� for���� �����Ѵ�.
                  if(d_i == 0 && d_j == 0) {
                     continue;
                  }
                  int num = 0;
                  int a = i;
                  int b = j;
                  // �迭�ȿ� ���ڰ� �����ؾ� �ϹǷ� a,b�� ������ �Ʒ��� ����.
                  while (a >= 0 && b >= 0 && a < arr.length && b < arr[0].length) {
                     // num�� ���ڰ� �ϳ��� �߰��ɼ��� �ǵڿ� ���ڰ� �ϳ��� �ٴ� �����̹Ƿ�
                     // �Ʒ��� ���� ������ ǥ���ȴ�.
                     num = num*10 + arr[a][b];
                     // num�� �������鼭 max������ Ŭ ���, max���� ��ü�Ѵ�.
                     if(square(num) && num > max) {
                        max = num;
                     }
                     // ������ �����ָ鼭 ��ǥ�� �̵��Ѵ�.
                     a = a + d_i;
                     b = b + d_j;
                  }
               }
            }
         }
      }
      return max;
   }
   // ��� ���ڰ� ���������� �ƴ����� �Ǵ��ϴ� �Լ��̴�.
   public static boolean square(int N) {
      // �����佺�׳׽��� ü�� ���Ͽ� Math.sqrt(N)������ ����ϸ� �ȴ�.
      for(int i = 0 ; i <= Math.sqrt(N) ; i++) {
         if(N == i*i) {
            return true;
         }
      }
      return false;
   }

}
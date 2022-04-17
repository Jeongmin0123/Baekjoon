package Gold;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main1339 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      // Arrays.sort�� Collection.reverseOrder�� ����ϱ� ����
      // int �迭�� �ƴ� Integer �迭�� �����Ѵ�.
      Integer[] alphabet = new Integer[26];
      // ���ĺ��� �޾ƿ� �����ϴ� �迭�ν� 0�� �����ؾ� ������ ���� �ʴ´�.
      Arrays.fill(alphabet, 0);
      for (int i = 0; i < N ; i++) {
         // �Է¹��� ���� char �迭�� �����Ѵ�.
         char[] input = sc.next().toCharArray();
         // �ڿ��� ù ��° �ڸ����� ������ �����Ѵ�.
         int position = 1;
         for (int j = input.length - 1; j >= 0; j--) {
            alphabet[input[j] - 'A'] += Integer.valueOf(position);
            position *= 10;
            }
         } 
      Arrays.sort(alphabet, Collections.reverseOrder());
      int num = 9;
      int answer = 0;
      for (int i = 0; i < alphabet.length; i++) {
         // 0�� ������ ���� ������� ���� �����̹Ƿ� ������ �����Ѵ�.
         if (alphabet[i] == 0) break;
         answer += alphabet[i] * num;
         num--;
         } 
      System.out.println(answer);
      sc.close();

   }
}
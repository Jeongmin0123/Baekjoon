package Gold;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main1339 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      // Arrays.sort와 Collection.reverseOrder를 사용하기 위해
      // int 배열이 아닌 Integer 배열로 선언한다.
      Integer[] alphabet = new Integer[26];
      // 알파벳을 받아와 저장하는 배열로써 0을 저장해야 오류가 나지 않는다.
      Arrays.fill(alphabet, 0);
      for (int i = 0; i < N ; i++) {
         // 입력받은 값을 char 배열로 저장한다.
         char[] input = sc.next().toCharArray();
         // 뒤에서 첫 번째 자리부터 연산을 시작한다.
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
         // 0이 나오는 순간 사용하지 않은 문자이므로 연산을 종료한다.
         if (alphabet[i] == 0) break;
         answer += alphabet[i] * num;
         num--;
         } 
      System.out.println(answer);
      sc.close();

   }
}
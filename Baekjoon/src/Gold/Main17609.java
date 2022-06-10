package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main17609 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String s = "";
		int result = 0;
		for(int i = 0 ; i < T ; i++) {
			s = br.readLine();
			result = check(s);
			
			// 36�� ���ο��� +1�� ���־����Ƿ� ��½� -1�� ���ش�.
			if(result >= 2) {
				System.out.println(result-1);
			} else {
				System.out.println(result);
			}
		}
	}
	public static int check(String s) {
		// �� ���ڸ��� ���ڸ��� ���� �޾ƿ´�.
		int min = 0;
		int max = s.length() - 1;
		int result = 0;
		
		while(min <= max) {
			// ���� ������ ���� ������ ���� �����ʿ� �ش��ϴ� index ���� ���� 1����, 1���� ��Ų��.
			if(s.charAt(min) == s.charAt(max)) {
				min++;
				max--;
			// �ٸ� ��� ���ʸ� +1, �Ǵ� �����ʸ� -1 ���صڿ� �ٽ� ���� �����ش�.
			} else {
				result++;
				int min2 = min;
				int max2 = max;
				min2++;
				while(min2 <= max2) {
					if(s.charAt(min2) == s.charAt(max2)) {
						min2++;
						max2--;
					} else {
						result++;
						break;
					}
				}
				min2 = min;
				max2 = max;
				max2--;
				while(min2 <= max2) {
					if(s.charAt(min2) == s.charAt(max2)) {
						min2++;
						max2--;
					} else {
						result++;
						break;
					}
				}
				return result;
			}
		}
		return result;
	}

}

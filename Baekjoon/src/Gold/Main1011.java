package Gold;

import java.util.Scanner;

public class Main1011 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] ans = new int[T];
		for(int i = 0 ; i < T ; i++) {
			int day = 0;
			int pos = sc.nextInt();
			// 현재 지점
			int ob_pos = sc.nextInt();
			// 목표 지점
			int max=(int)Math.sqrt(ob_pos-pos);
			// 한번에 갈수 있는 최대 광년은 (int)Math.sqrt(ob_pos-pos)다.
			// 그 이유는 1,2,3 .... 광년순으로 증가하면서 이동하다가 중간지점에서 max값을 세번 가지고 이후
			// 이후 도착지점 바로 직전의 이동거리 값이 1이 되기 위해서 max, max-1, max-2 ..... 3,2,1 이런 식으로 이동하게 되는데
			// 등차수열의 합 공식을 이용하여 그 값을 구하면 이동할 수 있는 최대값은 Math.sqrt(max^2 + 2max)나온다. ★
			// 이때 이동할 수 있는 최대 값은 정수값만 가능하므로 뒤의 소수점 자리를 뗀 (int)Math.sqrt(ob_pos-pos)이 되게된다. 
			if(max == Math.sqrt(ob_pos-pos)) day = 2*max - 1;
			// max == Math.sqrt(ob_pos-pos) 면 등차수열의 합 공식에 의해서 중간에서 정확히 max값을 한번 가진 이후에 
			// 이동하는 거리가 줄어들기 때문에 걸리는 날은 1부터 max까지의 개수를 더하고 max-1부터 1까지의 개수를 더한 2*max - 1이 된다.
			else if ((ob_pos-pos) <= Math.pow(max, 2) + max) day = 2*max;
			// (ob_pos-pos) <= Math.pow(max, 2) + max) 면 중간에서 max값을 두번 가지고 이후에 이동하는 거리가 줄어든다.
			// 따라서 걸리는 날은 1부터 max까지의 개수를 더하고 max부터 1까지의 개수를 더한 2max가 된다.
			else day = 2*max + 1;
			// 마지막 경우는 ★과 같은 경우이므로 max값이 중간에 3번이기 때문에 걸리는 날이 2*max + 1이 된다.
			ans[i] = day;
			}
		sc.close();
		
		for(int i = 0 ; i < ans.length ; i++) {
			System.out.print(ans[i] + " ");
			// 각각 test case에 대한 답을 출력한다.
		}
			
	}
	
}
	

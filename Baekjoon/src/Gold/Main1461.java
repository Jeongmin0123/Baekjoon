package Gold;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main1461 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<Integer> num = new ArrayList<Integer>();
		for(int i = 0 ; i < N ; i++) {
			int temp = sc.nextInt();
			num.add(temp);
		}
		int result = 0;
		Collections.sort(num);
		// 책의 개수가 한번에 들고 다닐 수 있는 책의 개수보다 큰 경우
		if(N > M) {
			// 0에서부터 가장 멀리 떨어져있는 곳을 마지막으로 가야 최소로 걸을 수 있다.
			// 따라서 다른 지점들은 책을 놓고 다시 원점으로 돌아오는 반면, 가장 멀리 떨어진 곳은
			// 놓고난 뒤 돌아오지 않기 때문에 1번만 더해줘야 하므로 미리 결과값에서 빼준다.
			if(Math.abs(num.get(0)) > Math.abs(num.get(num.size()-1))) {
				result -= Math.abs(num.get(0));
			} else {
				result -= Math.abs(num.get(num.size()-1));
			}
			// 이동할 때, M개의 책을 들고 간다고 가정하면 현재 가장 멀리있는 곳에 갔다 오면서
			// 그 지점과 가까운 M-1 개 지점에 책을 두고올 수 있으므로, 가장 멀리있는 곳의 2배 거리를
			// 결과값에 더하고, M개의 지점을 ArrayList에서 제거한다.
			while(num.size() > M) {
				if(Math.abs(num.get(0)) > Math.abs(num.get(num.size()-1))) {
					result += 2*Math.abs(num.get(0));
					for(int i = 0 ; i < M ; i++) {
						num.remove(0);
					}
				} else {
					result += 2*Math.abs(num.get(num.size()-1));
					for(int i = 0 ; i < M ; i++) {
						num.remove(num.size()-1);
					}
				}
			}
			// 남은 책 위치가 다 양수인 경우
			if(num.get(0) > 0) {
				result += 2*Math.abs(num.get(num.size()-1));
				// 남은 책 위치가 다 음수인 경우
			} else if(num.get(num.size()-1) < 0) {
				result += 2*Math.abs(num.get(0));
				// 남은 책 위치가 양수, 음수 섞인 경우
			} else {
				result += 2*Math.abs(num.get(num.size()-1)) + 2*Math.abs(num.get(0));
			}
		// 책의 개수가 한번에 들고 다닐 수 있는 책의 개수보다 작은 경우
		} else {
			if(num.get(0) > 0) {
				result += Math.abs(num.get(num.size()-1));
			} else if(num.get(num.size()-1) < 0) {
				result += Math.abs(num.get(0));
			} else {
				result = 2*Math.abs(num.get(num.size()-1)) + 2*Math.abs(num.get(0));
				if(Math.abs(num.get(0)) > Math.abs(num.get(num.size()-1))) {
					result -= Math.abs(num.get(0));
				} else {
					result -= Math.abs(num.get(num.size()-1));
				}
			}
		}
		
		System.out.println(result);
		sc.close();
	}

}

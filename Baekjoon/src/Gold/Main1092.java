package Gold;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main1092 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Integer> crain = new ArrayList<Integer>();
		for(int i = 0 ; i < N ; i++) {
			crain.add(sc.nextInt());
		}
		int M = sc.nextInt();
		ArrayList<Integer> box = new ArrayList<Integer>();
		for(int i = 0 ; i < M ; i++) {
			box.add(sc.nextInt());
		}
		int result = time(crain, box, N);
		System.out.println(result);
		sc.close();
	}
	
	public static int time(ArrayList<Integer> crain, ArrayList<Integer> box, int N) {
		int time = 0;
		Collections.sort(crain, Collections.reverseOrder());
		Collections.sort(box, Collections.reverseOrder());
		if(box.get(0) > crain.get(0)) {
			return -1;
		}
		while(box.size() != 0) {
			int crain_idx = 0;
			int box_idx = 0;
			while(crain_idx < N) {
				if(box_idx == box.size()) break;
				if(crain.get(crain_idx) >= box.get(box_idx)) {
					crain_idx++;
					box.remove(box_idx);
				} else if(crain.get(crain_idx) < box.get(box_idx)) {
					box_idx++;
				}
			}
			time++;
		}
		return time;
	}
}

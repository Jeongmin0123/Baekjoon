package Gold;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main1092 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 크레인의 무게 제한 리스트를 ArrayList로 두는 이유는 한 크레인을 이용해서 박스를 들 경우
		// 박스를 제거하거나 사용하지 못하게 해야되는데 일반 배열로 사용할 시 어려움이 있기 때문에
		// 박스 리스트를 ArrayList로 사용했다. 그러는 김에 크레인 무게 제한도 ArrayList로
		// 사용한다.
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
		// 크레인과 박스의 무게 리스트를 정렬하되 내림차순 정렬해준다
		// 그 이유는 추후에 설명하겠다.
		Collections.sort(crain, Collections.reverseOrder());
		Collections.sort(box, Collections.reverseOrder());
		// 만약 가장 무거운 박스의 무게가 크레인의 무게 제한중에서 최대값보다 크면 어떤 박스는 들 수 없으므로
		// -1를 리턴한다.
		if(box.get(0) > crain.get(0)) {
			return -1;
		}
		// 남는 박스가 없을 때까지 연산을 수행한다.
		while(box.size() != 0) {
			// 크레인의 인덱스
			int crain_idx = 0;
			int box_idx = 0;
			// 크레인의 인덱스가 N보다 작을 때까지만 연산을 수행한다.
			while(crain_idx < N) {
				// 아래의 경우 이미 모든 박스를 훑고 지나간 상태이므로 연산을 종료한다.
				if(box_idx == box.size()) break;
				// 아래의 경우 현재 크레인으로 박스를 들 수 있으므로 crain의 인덱스를 증가시키고
				// 그 위치의 박스는 제거한다.
				if(crain.get(crain_idx) >= box.get(box_idx)) {
					crain_idx++;
					box.remove(box_idx);
				// 아래의 경우 현재 크레인으로 박스를 들 수 없으므로 현재 박스는 다음 수행 때 생각하고
				// 다음 박스에 대한 연산을 수행한다.
				} else if(crain.get(crain_idx) < box.get(box_idx)) {
					box_idx++;
				}
			}
			// 위 과정이 다 수행되었을 경우 1분이 지났으므로 시간을 증가시키고 다시 다음수행을 한다.
			time++;
		}
		return time;
	}
}

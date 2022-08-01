package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1244 {

	public static int[] button;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 스위치의 상태
		button = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < N ; i++) {
			button[i] = Integer.parseInt(st.nextToken());
		}
		// 사람의 수
		int person = Integer.parseInt(br.readLine());
		// 사람의 성별과 위치를 받아와 메서드에 넣어준다.
		for(int i = 0 ; i < person ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			change(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		for(int i = 0 ; i < N ; i++) {
			System.out.print(button[i] + " ");
			if((i+1) % 20 == 0)
				System.out.println();
		}
	}
	
	// 성별과 위치를 받아와 스위치의 상태를 바꿔주는 메서드
	public static void change(int gender, int location) {
		// 남자일시
		if(gender == 1) {
			for(int i = location - 1 ; i < button.length ; i += location) {
				if(button[i] == 0) {
					button[i] = 1;
				} else {
					button[i] = 0;
				}
			}
		// 여자일시
		} else {
			int start = location - 1;
			int end = location - 1;
			while(true) {
				if(start - 1 >= 0 && end + 1 < button.length && button[start-1] == button[end+1]) {
					start--;
					end++;
				} else {
					break;
				}
			}
			for(int i = start ; i <= end ; i++) {
				if(button[i] == 0) {
					button[i] = 1;
				} else {
					button[i] = 0;
				}
			}
		}
	}

}


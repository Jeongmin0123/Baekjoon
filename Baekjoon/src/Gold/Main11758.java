package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11758 {

	public static int x1,x2,x3,y1,y2,y3;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		x1 = Integer.parseInt(st.nextToken());
		y1 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		x2 = Integer.parseInt(st.nextToken());
		y2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		x3 = Integer.parseInt(st.nextToken());
		y3 = Integer.parseInt(st.nextToken());
		int result = CCW();
		System.out.println(result);
	}
	
	// 신발끈 공식을 이용하여 반시계 방향인지, 시계 방향인지 반환해주는 메서드
	public static int CCW() {
		int result = x1*y2 + x2*y3 + x3*y1 - x2*y1 - x3*y2 - x1*y3;
		if(result > 0) {
			return 1;
		} else if(result < 0) {
			return -1;
		} else {
			return 0;
		}
	}

}

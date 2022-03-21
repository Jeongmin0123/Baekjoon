package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2869 {

	public static void main(String[] args) throws IOException {
		// 시간 제한을 맞추기 위하여 BufferedReader를 사용한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// 각각의 변수들을 입력받는다.
		int up = Integer.parseInt(st.nextToken());
		int down = Integer.parseInt(st.nextToken());
		int length = Integer.parseInt(st.nextToken());
		// 걸린 일수는 올라가야하는 길이를 하루에 올라갈 수 있는 거리로 나눈 값의 몫이다.
		// 이 때, 올라가야 하는 길이에서 미끄러지는 길이를 빼준 이유는 마지막 날은 올라가기만 하므로 결국 총 올라가야되는 길이는 length - down 이 된다.
		int day = (length - down)/(up - down);
		if((length - down)%(up - down) != 0) day++;
		System.out.println(day);
	}
}

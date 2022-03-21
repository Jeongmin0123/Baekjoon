package Gold;

import java.util.Arrays;
import java.util.Scanner;

public class Main1027 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 각 빌딩의 길이
		int[] build = new int[N];
		// 각 빌딩에서 보이는 건물의 갯수
		int[] visible = new int[N];
		for(int i = 0 ; i < N ; i++) {
			build[i] = sc.nextInt();
		}
		visible = count(build, visible);
		// visible 배열을 정렬한다.
		Arrays.sort(visible);
		System.out.println(visible[N-1]);
		sc.close();
	}
	// 각각의 건물마다 보이는 건물 수를 return 하는 배열을 반환한다.
	public static int[] count(int[] build, int[] visible) {
		for(int i = 0 ; i < build.length - 1 ; i++) {
			// 각각의 i번째 건물과 i+1 건물에서 양옆에 건물은 무조건 보이기
			// 때문에 확정적으로 보이는 건물수를 1개씩 증가시켜준다.
			visible[i]++;
			visible[i+1]++;
			// 붙어있는 건물들의 위 지점을 한 점으로 봤을 때, 두 점을 잇는 직선의 기울기
			double slope = (double) build[i+1] - build[i];
			for(int j = i+2 ; j < build.length ; j++) {
				// i번째 건물과 j번째 건물들의 위 지점을 한 점으로 봤을 때, 두 점을 잇는 직선의 기울기
				double slope2 = (double)(build[j]-build[i])/(j-i);
				// 만약 slope >= slope2일 경우 i번째 건물에서 j번째 건물이 보이지 않게 된다.
				// 따라서 밑에 문장을 수행하지 않고 다시 for문으로 돌아간다.
				if(slope >= slope2) continue;
				// 반대의 경우는 건물이 보이기 때문에 vsible[i]와 visible[j]를 증가시키고
				// 더 큰 기울기를 slope로 바꿔준 후 다시 for문을 진행하여
				// 다음 시행에서 나온 slope2가 slope보다 클 경우에만 visible을 증가시킨다.
				// 그 이유는 두 건물 사이에 있는 건물보다 기울기가 커야지만 i번째 건물에서 j번째 건물이 보이기 때문이다.
				slope = slope2;
				visible[i]++;
				visible[j]++;
			}
		}
		return visible;
	}

	public static int count(int[] arr) {
		// 보이는 건물의 최대값을 max로 둔다.
		int max = 0;
		for(int i = 0 ; i < arr.length ; i++) {
			// 각 건물마다에서 보이는 건물의 수를 count로 둔다.
			int count = 0;
			// i번째 건물의 앞부분의 건물들에 대한 식이다.
			for(int j = 0 ; j < i ; j++) {
				// j번째 건물과 i번째 건물의 윗 지점을 지나는 직선의 방정식을 구한다.
				float a = (arr[j] - arr[i]) /(float) (j - i);
				float b = (j*arr[i] - i*arr[j])/ (float) (j - i);
				boolean visible = true;
				// 만약 i번째 건물과 j번째 건물 사이에서 건물의 윗지점이 직선 위에 존재한다면 두 건물은 서로 안 보이므로
				// 보이지 않는다고 보고 for문을 종료한다.
				for(int k = j + 1 ; k < i ; k++) {
					if(a*k+b <= arr[k]) {
						visible = false;
						break;
					}
				}
				if(visible) count++;
			}
			// i번째 건물의 뒷부분의 건물들에 대한 식이다.
			for(int j = i + 1 ; j < arr.length ; j++) {
				float a = (arr[j] - arr[i]) /(float) (j - i);
				float b = (j*arr[i] - i*arr[j])/ (float) (j - i);
				boolean visible = true;
				for(int k = i + 1 ; k < j ; k++) {
					if(a*k+b <= arr[k]) {
						visible = false;
						break;
					}
				}
				if(visible) count++;
			}
			// 만약 i번째 건물에서 보이는 건물의 수가 max보다 크면 max값을 교체한다.
			if(count > max) max = count;
		}
		return max;
	}
}

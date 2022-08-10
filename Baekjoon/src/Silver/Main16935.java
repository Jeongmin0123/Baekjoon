package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16935 {
	public static int N, M, R;
	public static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < M ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] cal = new int[R];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < R ; i++) {
			cal[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0 ; i < R ; i++) {
			Rotation(cal[i]);
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void Rotation(int type) {
		if(type == 1) {
			for(int i = 0 ; i < N/2 ; i++) {
				for(int j = 0 ; j < M ; j++) {
					int temp = arr[i][j];
					arr[i][j] = arr[N-i-1][j];
					arr[N-i-1][j] = temp;
				}
			}
		} else if(type == 2) {
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < M/2 ; j++) {
					int temp = arr[i][j];
					arr[i][j] = arr[i][M-j-1];
					arr[i][M-j-1] = temp;
				}
			}
		} else if(type == 3) {
			int[][] trans_arr = new int[M][N];
			int C = N - 1;
			for(int j = 0 ; j < M ; j++) {
				for(int i = 0 ; i < N ; i++) {
					trans_arr[j][N-1-i] = arr[i][j];
				}
			}
			int temp = N;
			N = M;
			M = temp;
			arr = trans_arr;
		} else if(type == 4) {
			int[][] trans_arr = new int[M][N];
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					trans_arr[M-1-j][i] = arr[i][j];
				}
			}
			int temp = N;
			N = M;
			M = temp;
			arr = trans_arr;
		} else if(type == 5) {
			int[][] trans_arr = new int[N][M];
			int x_idx = N/2;
			int y_idx = M/2;
			for(int i = 0 ; i < x_idx ; i++) {
				for(int j = 0 ; j < y_idx ; j++) {
					trans_arr[i][j] = arr[i+x_idx][j];
				}
			}
			for(int i = 0 ; i < x_idx ; i++) {
				for(int j = y_idx ; j < M ; j++) {
					trans_arr[i][j] = arr[i][j-y_idx];
				}
			}
			for(int i = x_idx ; i < N ; i++) {
				for(int j = 0 ; j < y_idx ; j++) {
					trans_arr[i][j] = arr[i][j+y_idx];
				}
			}
			for(int i = x_idx ; i < N ; i++) {
				for(int j = y_idx ; j < M ; j++) {
					trans_arr[i][j] = arr[i-x_idx][j];
				}
			}
			arr = trans_arr;
		} else if(type == 6) {
			int[][] trans_arr = new int[N][M];
			int x_idx = N/2;
			int y_idx = M/2;
			for(int i = 0 ; i < x_idx ; i++) {
				for(int j = 0 ; j < y_idx ; j++) {
					trans_arr[i][j] = arr[i][j+y_idx];
				}
			}
			for(int i = 0 ; i < x_idx ; i++) {
				for(int j = y_idx ; j < M ; j++) {
					trans_arr[i][j] = arr[i+x_idx][j];
				}
			}
			for(int i = x_idx ; i < N ; i++) {
				for(int j = 0 ; j < y_idx ; j++) {
					trans_arr[i][j] = arr[i-x_idx][j];
				}
			}
			for(int i = x_idx ; i < N ; i++) {
				for(int j = y_idx ; j < M ; j++) {
					trans_arr[i][j] = arr[i][j-y_idx];
				}
			}
			arr = trans_arr;
		}
	}

}

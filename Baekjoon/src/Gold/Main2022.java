package Gold;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2022 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		double x = Double.parseDouble(st.nextToken());
		double y = Double.parseDouble(st.nextToken());
		double c = Double.parseDouble(st.nextToken());
		
		double low = 0;
		double high = Math.min(x, y);
		while(high - low > 0.001) {
			double width = (low+high)/2.0;
			double h1 = Math.sqrt(x*x - width*width);
			double h2 = Math.sqrt(y*y - width*width);
			double result = h1*h2/(h1+h2);
			if(result >= c) {
				low = width;
			} else {
				high = width;
			}
		}
		System.out.printf("%.3f",high);
	}
	
}


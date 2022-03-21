package Bronze;

import java.util.Scanner;

public class Main4344 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		double result[] = new double[C];
		for(int i = 0 ; i < C ; i++ ) {
			int num_stu = sc.nextInt();
			int score[] = new int[num_stu];
			double sum = 0;
			double count = 0;
			for(int j = 0 ; j < num_stu ; j++ ) {
				score[j] = sc.nextInt();
				sum += score[j];
			}
			for(int k = 0 ; k <num_stu ; k++ ) {
				if(score[k] > (sum/num_stu)) count++;
			}
			for(int a = 0 ; a < C ; a++) {
				result[a] = (count/num_stu);
			}
			System.out.println(String.format("%.3f", result[i]*100) + "%");
			sc.close();
		}
	}
}

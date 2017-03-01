package melwin.hackerrank.practice.ai.StatisticsAndMachineLearning;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LaptopBatteryLife {

	private static String PREFIX = "src\\melwin\\hackerrank\\practice\\ai\\StatisticsAndMachineLearning\\";
	//private static String PREFIX = "";
	private static String FILE = PREFIX+"trainingdata.txt";
	private static int DEBUG = 0;
	
	private static int n = 100;

	private static ArrayList<Float> y;
	private static float y_sum, y_mean;

	private static ArrayList<Float> x;
	private static float x_sum, x_mean;

	private static float xy_sum, xy_mean;
	private static float x_2_sum, x_2_mean;
	private static float x_mean_2;

	private static float alpha, beta;

	private static void readData() throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
			String line;
			float temp_x, temp_y;
			while ((line = br.readLine()) != null) {
				String[] inputs = line.split(",");
				
				temp_x = Float.parseFloat(inputs[0]);
				// Plot the x-y graph to see reason for 
				// this condition
				if(temp_x>=4){
					n--;
					continue;
				}
				x.add(temp_x);
				x_sum += temp_x;

				temp_y = Float.parseFloat(inputs[1]);
				y.add(temp_y);
				y_sum += temp_y;

				xy_sum += (temp_x * temp_y);
				x_2_sum += Math.pow(temp_x, 2);
			}
		}
	}

	private static void calculateEstimate() {
		y_mean = y_sum / n;
		x_mean = x_sum / n;
		x_mean_2 = (float) Math.pow(x_mean, 2);
		xy_mean = xy_sum / n;
		x_2_mean = x_2_sum / n;

		if(DEBUG==1){
			System.out.println("N:"+n);
			System.out.println("SUM(x):"+x_sum);
			System.out.println("SUM(y):"+y_sum);
			System.out.println("MEAN(xy):"+xy_mean);
			System.out.println("MEAN(x):"+x_mean);
			System.out.println("MEAN(y):"+y_mean);
			System.out.println("MEAN(x_2):"+x_2_mean);
			System.out.println("MEAN(x)_2):"+x_mean_2);
		}
		
		beta = (xy_mean - (x_mean * y_mean)) / (x_2_mean - x_mean_2);
		alpha = y_mean - (beta * x_mean);

		if(DEBUG==1) System.out.println("Y = "+alpha+" + "+beta+"X");
	}
	
	private static void predict(){
		Scanner reader = new Scanner(System.in);
		float new_x = reader.nextFloat();
		
		if(new_x>=4) System.out.println("8");
		else	System.out.println(alpha+(beta*new_x));
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		x = new ArrayList<>();
		y = new ArrayList<>();
		y_sum = x_sum = y_mean = x_mean = xy_sum = x_2_sum = 0;

		readData();
		calculateEstimate();
		predict();
	}

}

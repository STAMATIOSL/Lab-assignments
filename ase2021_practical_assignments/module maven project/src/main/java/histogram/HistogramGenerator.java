package histogram;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
* The HistogramGenerator class simply displays 
* a histogram for all grades that have been given 
* from the cmd as a txt file.
*
* @author  Liakos Stamatis
* @version 1.0
* @since   2021-090-04
*/

public class HistogramGenerator {
	
	public static void main(String[] args) {
		
		File f = new File(args[0]);
		int[] grs = getGrades(f);
		int[] grades = frequency(grs);
		generateChart(grades);
		
	}
	
   /**
   * This method is used to read the txt file with the 
   * grades from the cmd.
   * @param File f This is the txt file that has been given
   * from the cmd.
   * @return int[] This returns all the Grades (0-10) 
   * in an integer array.
   */
	
	public static int[] getGrades(File f) {
		
		int[] a = new int[149];
		int i = 0;
		
		try {
			
			Scanner myReader = new Scanner(f);
			while (myReader.hasNextLine()) {
				String gr = myReader.nextLine();
				int grade = Integer.parseInt(gr);
				a[i] = grade;
				i = i + 1;
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
	    	}
		return a;
	}
	
   /**
   * This method is used to take the int array with all 
   * grades and return the frequency of each grade.
   * @param int a This is the integer array with all grades.
   * @return int[] This returns the frequency of each grade.
   */
	
	public static int[] frequency(int[] a) {
		
		int[] fr = new int[11];
		for(int i = 0; i < fr.length; i++) {
			fr[i] = 0;
		}
		
		for(int i = 0; i < a.length; i++) {
			fr[a[i]] = fr[a[i]] + 1;
		}
		
		return fr;
	}
	
   /**
   * This method is used to draw the histogram with the 
   * frequency of each grade (0-10).
   * The x_axis title renamed "Grades" to display all grades (0-10).
   * The y_axis title renamed "Frequency" to display the frequency 
   * of all grades.
   * The Chart Title is renamed "Histogram of all Grades" in order 
   * to display the purpose of the histogram.
   */
	
	public static void generateChart(int[] dataValues) {
		/*
		 * The XYSeriesCollection object is a set XYSeries series (dataset) that
		 * can be visualized in the same chart
		 */
		XYSeriesCollection dataset = new XYSeriesCollection();
		/*
		 * The XYSeries that are loaded in the dataset. There might be many
		 * series in one dataset.
		 */
		XYSeries data = new XYSeries("random values");

		/*
		 * Populating the XYSeries data object from the input Integer array
		 * values.
		 */
		for (int i = 0; i < dataValues.length; i++) {
			data.add(i, dataValues[i]);
		}

		// add the series to the dataset
		dataset.addSeries(data);

		boolean legend = false; // do not visualize a legend
		boolean tooltips = false; // do not visualize tooltips
		boolean urls = false; // do not visualize urls

		// Declare and initialize a createXYLineChart JFreeChart
		JFreeChart chart = ChartFactory.createXYLineChart("Histogram of all Grades", "Grades", "Frequency", dataset,
				PlotOrientation.VERTICAL, legend, tooltips, urls);

		/*
		 * Initialize a frame for visualizing the chart and attach the
		 * previously created chart.
		 */
		ChartFrame frame = new ChartFrame("First", chart);
		frame.pack();
		// makes the previously created frame visible
		frame.setVisible(true);
	}
}

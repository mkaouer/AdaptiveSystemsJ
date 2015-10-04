 package jmetal.problems.AdaptiveInterface;


/**
 * 
 */


import java.util.Random;
import java.util.Vector;

/**
 * @author User
 *
 */
public class Input {

	/**
	 * @param args
	 * @return 
	 * @return 
	 */
	public static  String[] Context() {
		String [] Context= { "Age","Motivation","Education Level","User Experience","Interest"};
	
		return Context;
	}
	public static  String[] ValuesOfContext() {
		String [] Values= { "Low","Meduim","High"};
	
	
		return Values;

	}
	public static  String[] Metrics() {
		String [] Metrics= { "Regularity","Grouping","Sequence","Simplicity","Unity","Density"} ;//,"Symmetry","Homogeneity"};
	
		
		return Metrics;

	}
	public static  String[] Operator() {
		String [] Operator= { "<=",">="};
	
		
		return Operator;

	}
	public static  String Val_Metric() {
		Random number_generator = new Random();
		double source_indx = number_generator.nextDouble();
    	double sourc_index=(double)((int)( source_indx *100))/100;
	    String Val_Metric = Double.toString(sourc_index);
		
		return Val_Metric;

	}

	public static  String[] Problem() {
		String [] Problem= { "Interface chargé","Interface non chargé","Guidage fort","Guidage faible","Interface non ordonné","Interface ordonné","Interface complexe","Interface simple","Interface centré","Interface non centré","Interface regulié","Interface irregulié","Problem71","Problem72","Problem81","Problem82"};
	
		
		return Problem;

	}
	

}

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
		String [] Problem= { "Interface charg�","Interface non charg�","Guidage fort","Guidage faible","Interface non ordonn�","Interface ordonn�","Interface complexe","Interface simple","Interface centr�","Interface non centr�","Interface reguli�","Interface irreguli�","Problem71","Problem72","Problem81","Problem82"};
	
		
		return Problem;

	}
	

}

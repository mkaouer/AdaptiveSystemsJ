package jmetal.util.wrapper;

import jmetal.core.Solution;
import jmetal.core.SolutionType;
import jmetal.encodings.solutionType.ArrayRealAndBinarySolutionType;
import jmetal.encodings.solutionType.ArrayRealSolutionType;
import jmetal.encodings.solutionType.ArrayRuleSolutionType;
import jmetal.encodings.solutionType.BinaryRealSolutionType;
import jmetal.encodings.solutionType.RealSolutionType;
import jmetal.encodings.solutionType.Rule;
import jmetal.encodings.variable.ArrayReal;
import jmetal.encodings.variable.ArrayRule;
import jmetal.util.Configuration;
import jmetal.util.JMException;

public class XRule {

	private Solution solution_ ;
	private SolutionType type_ ;

	/**
	 * Constructor
	 */
	public XRule() {
	} // Constructor

	/**
	 * Constructor
	 * @param solution
	 */
	public XRule(Solution solution) {
		this() ;
		type_ = solution.getType() ;
		solution_ = solution ;
	}

	/**
	 * Gets value of a encodings.variable
	 * @param index Index of the encodings.variable
	 * @return The value of the encodings.variable
	 * @throws JMException
	 */
	public Rule getValue(int index) throws JMException {
		if (type_.getClass() == ArrayRuleSolutionType.class){
			return ((ArrayRule)(solution_.getDecisionVariables()[0])).array_[index] ;		
		} 
		else {
			Configuration.logger_.severe("jmetal.util.wrapper.XReal.getValue, solution type " +
					type_ + "+ invalid") ;		
		}
		return null ;
	}

	/**
	 * Sets the value of a encodings.variable
	 * @param index Index of the encodings.variable
	 * @param value Value to be assigned
	 * @throws JMException
	 */
	public void setValue(int index, double value) throws JMException {
		if (type_.getClass() ==  ArrayRuleSolutionType.class)
			solution_.getDecisionVariables()[index].setValue(value) ;
		else
			Configuration.logger_.severe("jmetal.util.wrapper.XReal.setValue, solution type " +
					type_ + "+ invalid") ;		
	} // setValue	

	/**
	 * Gets the lower bound of a encodings.variable
	 * @param index Index of the encodings.variable
	 * @return The lower bound of the encodings.variable
	 * @throws JMException
	 */
	public double getLowerBound(int index) throws JMException {
		if (type_.getClass() ==  ArrayRuleSolutionType.class) 
			return solution_.getDecisionVariables()[index].getLowerBound() ;
		else {
			Configuration.logger_.severe("jmetal.util.wrapper.XReal.getLowerBound, solution type " +
					type_ + "+ invalid") ;		

		}
		return 0.0 ;
	} // getLowerBound

	/**
	 * Gets the upper bound of a encodings.variable
	 * @param index Index of the encodings.variable
	 * @return The upper bound of the encodings.variable
	 * @throws JMException
	 */
	public double getUpperBound(int index) throws JMException {
		if (type_.getClass() ==  ArrayRuleSolutionType.class)			
			return solution_.getDecisionVariables()[index].getUpperBound() ;
		else
			Configuration.logger_.severe("jmetal.util.wrapper.XReal.getUpperBound, solution type " +
					type_ + "+ invalid") ;		

		return 0.0 ;
	} // getUpperBound

	/**
	 * Returns the number of variables of the solution
	 * @return
	 */
	public int getNumberOfDecisionVariables() {
		if (type_.getClass() ==  ArrayRuleSolutionType.class) 	
			return solution_.getDecisionVariables().length ;
		else
			Configuration.logger_.severe("jmetal.util.wrapper.XReal.size, solution type " +
					type_ + "+ invalid") ;		
		return 0 ;
	} // getNumberOfDecisionVariables
	
	/**
	 * Returns the number of variables of the solution
	 * @return
	 */
	public int size() {
		if (type_.getClass().equals( ArrayRuleSolutionType.class)) 		
			return solution_.getDecisionVariables().length ;
		
		else
			Configuration.logger_.severe("jmetal.util.wrapper.XReal.size, solution type " +
					type_ + "+ invalid") ;		
		return 0 ;
	} // size


}

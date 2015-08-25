package jmetal.encodings.solutionType;

import jmetal.core.Problem;
import jmetal.core.SolutionType;
import jmetal.core.Variable;
import jmetal.encodings.variable.ArrayReal;
import jmetal.encodings.variable.ArrayRule;

public class ArrayRuleSolutionType extends SolutionType {
	Rule R = new Rule ();
	Input input = new Input();
	/**
	 * Constructor
	 * @param problem Problem to solve
	 */
	public ArrayRuleSolutionType(Problem problem) {
		super(problem) ;
	}

	@Override
	public Variable[] createVariables() throws ClassNotFoundException {
		Variable [] variables = new Variable[1];
	    
		variables[0] = new ArrayRule(problem_.getNumberOfVariables(), problem_); 
	    return variables ;
	}

}

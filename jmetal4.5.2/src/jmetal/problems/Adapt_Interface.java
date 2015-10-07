 package jmetal.problems;

import jmetal.core.Problem;
import jmetal.core.Solution;
import jmetal.core.Variable;
import jmetal.encodings.solutionType.IntSolutionType;
import jmetal.problems.AdaptiveInterface.MySolution;
import jmetal.util.JMException;

public class Adapt_Interface extends Problem {
	 int lower_rules_size= 50;
	 int upper_rules_size= 100;
	 
	public Adapt_Interface(String solutionType) throws ClassNotFoundException {
	    this(solutionType, 1);
	
	  } // Adapt_Interface

	public Adapt_Interface(String solutionType, Integer numberOfVariables) {
		
		  numberOfVariables_   =  100 ;         //S.SolutionSize(min_rules_size, max_rules_size) ;    //
		    numberOfObjectives_  = 2                            ;
		    numberOfConstraints_ = 0                            ;
		    problemName_         = "Adapt_Interface"                    ;
		    lowerLimit_ =new double[numberOfVariables_];
		    upperLimit_ = new double[numberOfVariables_];
		   for(int i= 0; i<numberOfVariables;i++)
		    {
		    	lowerLimit_ [i]= IntSolutionType.min_rules_size ;//lower_rules_size;
			    upperLimit_ [i]= IntSolutionType.min_rules_size ; //upper_rules_size; 
		    }
		    if (solutionType.compareTo("Int") == 0)
		    	solutionType_ = new IntSolutionType(this) ;
		    else {
		    	System.out.println("Error: solution type " + solutionType + " invalid") ;
		    	System.exit(-1) ;
		    }
	}

	@Override
	public void evaluate(Solution solution) throws JMException {

              MySolution S = new MySolution();
	     Variable[] variable  = solution.getDecisionVariables();
	     double [] f = new double[numberOfObjectives_];
	     
     /* for(int i=0;i< variable.length;i++)
          { f[0] = variable[i].getValue();   } */
	     
	    System.out.println(" Size of solution : "+ IntSolutionType.rules_size);
	     
	 f[0] = IntSolutionType.Listrules.size() ;//S.fitness_1() ; 
     f[1] = S.fitness_2();        
     
    solution.setObjective(0,f[0]);
    solution.setObjective(1,1-f[1]);
  
		
	}
	 /* public void evaluateConstraints(Solution solution) throws JMException {
		    double  constraint;
		    MySolution S = new MySolution();
		    Variable[] x1 = solution.getDecisionVariables();
		    int x2 = S.rules.size();
		    //double x2 = solution.getDecisionVariables()[1].getValue();
		        
		    constraint =  ;
		        
		    int number = 0;
		    double total = 0.0;
		    for (int i = 0; i < this.getNumberOfConstraints(); i++)
		      if (constraint[i]<0.0){
		        number++;
		        total+=constraint[i];
		      }
		        
		    solution.setOverallConstraintViolation(total);    
		    solution.setNumberOfViolatedConstraint(number);
		  } // evaluateConstraints */

}

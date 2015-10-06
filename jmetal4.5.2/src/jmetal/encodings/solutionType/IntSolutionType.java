//  IntSolutionType.java
//
//  Author:
//       Antonio J. Nebro <antonio@lcc.uma.es>
//       Juan J. Durillo <durillo@lcc.uma.es>
// 
//  Copyright (c) 2011 Antonio J. Nebro, Juan J. Durillo
//
//  This program is free software: you can redistribute it and/or modify
//  it under the terms of the GNU Lesser General Public License as published by
//  the Free Software Foundation, either version 3 of the License, or
//  (at your option) any later version.
//
//  This program is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  GNU Lesser General Public License for more details.
// 
//  You should have received a copy of the GNU Lesser General Public License
//  along with this program.  If not, see <http://www.gnu.org/licenses/>.

package jmetal.encodings.solutionType;

import java.util.ArrayList;
import java.util.Random;

import jmetal.core.Problem;
import jmetal.core.SolutionType;
import jmetal.core.Variable;
import jmetal.encodings.variable.Int;
import jmetal.problems.AdaptiveInterface.Input;
import jmetal.problems.AdaptiveInterface.MySolution;
import jmetal.problems.AdaptiveInterface.Rule;

/**
 * Class representing the solution type of solutions composed of Int variables 
 */
public class IntSolutionType extends SolutionType {
	MySolution S = new MySolution ();
	public static ArrayList<Rule> rules ; //= new ArrayList<Rule> ();
	 Input input = new Input ();
	 public static int min_rules_size = 50 ;
	 public static int max_rules_size =100;
	 public static int rules_size ;
	 int h =0;

	/**
	 * Constructor
	 * @param problem  Problem to solve
	 */
	public IntSolutionType(Problem problem) {
		super(problem) ;
	} // Constructor

	/**
	 * Creates the variables of the solution
	 */
	public Variable[] createVariables() {
		Variable[] variables = new Variable[problem_.getNumberOfVariables()];
		rules = new ArrayList<Rule> ();
		Random number_generator = new Random();
		rules_size = min_rules_size+ (int) (Math.random() * ((max_rules_size - min_rules_size) + 1));
	    rules_size = number_generator.nextInt(max_rules_size);
		 if (rules_size < min_rules_size) rules_size = min_rules_size;
        System.out.println("\n number of rules to create : "+rules_size);
		//for (int var = 0; var < problem_.getNumberOfVariables(); var++)
           h++;
		  System.out.println("********** Solution X************ " +h );
		   for (int var = 0; var <rules_size; var++)
			{variables[var] = new Int((int)problem_.getLowerLimit(var),(int)problem_.getUpperLimit(var)); 
			        rules.add(S.create_rule(input));
			        //S.create_rule(input);
			      
		       /*try {
		    	   S.create_rules(input);
				S.create_solution(input, (int)variables[var].getValue());
			} catch (JMException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/}
		    
		  

		return variables ;
	} // createVariables
} // IntSolutionType

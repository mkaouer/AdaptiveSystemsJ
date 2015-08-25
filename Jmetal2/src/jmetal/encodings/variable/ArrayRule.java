package jmetal.encodings.variable;

import jmetal.core.Problem;
import jmetal.core.Variable;
import jmetal.encodings.solutionType.Input;
import jmetal.encodings.solutionType.Rule;
import jmetal.util.Configuration;
import jmetal.util.JMException;
import jmetal.util.PseudoRandom;

public class ArrayRule extends Variable {
	Rule R = new Rule ();
	Input input = new Input ();
	 /**
	   * Problem using the type
	   */
	  private Problem problem_;

	  /**
	   * Stores an array of real values
	   */
	  public Rule[] array_;

	  /**
	   * Stores the length of the array
	   */
	  private int size_;

	  /**
	   * Constructor
	   */
	  public ArrayRule() {
	    problem_ = null;
	    size_ = 0;
	    array_ = null;
	  } // Constructor

	  /**
	   * Constructor
	   *
	   * @param size Size of the array
	   */
	  public ArrayRule(int size, Problem problem) {
	    problem_ = problem;
	    size_ = size;
	    array_ = new Rule[size_];

	    for (int i = 0; i < size_; i++) {
	      array_[i] = R.create_rules(input) ;
	    } // for
	  } // Constructor

	  /**
	   * Copy Constructor
	   *
	   * @param arrayReal The arrayReal to copy
	   */
	  private ArrayRule(ArrayRule arrayRule) {
	    problem_ = arrayRule.problem_;
	    size_ = arrayRule.size_;
	    array_ = new Rule[size_];

	    System.arraycopy(arrayRule.array_, 0, array_, 0, size_);
	  } // Copy Constructor

	  @Override
	  public Variable deepCopy() {
	    return new ArrayRule(this);
	  } // deepCopy

	  /**
	   * Returns the length of the arrayReal.
	   *
	   * @return The length
	   */
	  public int getLength() {
	    return size_;
	  } // getLength

	  /**
	   * getValue
	   *
	   * @param index Index of value to be returned
	   * @return the value in position index
	   */
	  public Rule getValue(int index) throws JMException {
	    if ((index >= 0) && (index < size_))
	      return array_[index];
	    else {
	      Configuration.logger_.severe(jmetal.encodings.variable.ArrayRule.class + ".getValue(): index value (" + index + ") invalid");
	      throw new JMException(jmetal.encodings.variable.ArrayRule.class + ".ArrayRule: index value (" + index + ") invalid");
	    } // if
	  } // getValue

	  /**
	   * setValue
	   *
	   * @param index Index of value to be returned
	   * @param value The value to be set in position index
	   */
	  public void setValue(int index, Rule value) throws JMException {
	    if ((index >= 0) && (index < size_))
	      array_[index] = value;
	    else {
	      Configuration.logger_.severe(jmetal.encodings.variable.ArrayRule.class + ".setValue(): index value (" + index + ") invalid");
	      throw new JMException(jmetal.encodings.variable.ArrayRule.class + ": index value (" + index + ") invalid");
	    } // else
	  } // setValue

	  /**
	   * Get the lower bound of a value
	   *
	   * @param index The index of the value
	   * @return the lower bound
	   */
	  public double getLowerBound(int index) throws JMException {
	    if ((index >= 0) && (index < size_))
	      return problem_.getLowerLimit(index);
	    else {
	      Configuration.logger_.severe(jmetal.encodings.variable.ArrayRule.class + ".getLowerBound(): index value (" + index + ") invalid");
	      throw new JMException(jmetal.encodings.variable.ArrayRule.class + ".getLowerBound: index value (" + index + ") invalid");
	    } // else
	  } // getLowerBound

	  /**
	   * Get the upper bound of a value
	   *
	   * @param index The index of the value
	   * @return the upper bound
	   */
	  public double getUpperBound(int index) throws JMException {
	    if ((index >= 0) && (index < size_))
	      return problem_.getUpperLimit(index);
	    else {
	      Configuration.logger_.severe(jmetal.encodings.variable.ArrayRule.class + ".getUpperBound(): index value (" + index + ") invalid");
	      throw new JMException(jmetal.encodings.variable.ArrayRule.class + ".getUpperBound: index value (" + index + ") invalid");
	    } // else
	  } // getLowerBound

	  /**
	   * Returns a string representing the object
	   *
	   * @return The string
	   */
	  public String toString() {
	    String string;

	    string = "";
	    for (int i = 0; i < (size_ - 1); i++)
	      string += array_[i] + " ";

	    string += array_[size_ - 1];
	    return string;
	  } // toString

}

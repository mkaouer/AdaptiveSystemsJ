package jmetal.encodings.solutionType;

import java.lang.*;

import java.util.ArrayList;
import java.util.Random;


public class Rule
{ 
  
	public String src;
    public  String src0;
    public String src2;
    public String src3;
    public String src4;
    public String trg;
    public String rule_text ;
    public ArrayList<Integer> ind1 =new ArrayList<Integer>(); 
    public ArrayList<Integer> ind2 =new ArrayList<Integer>();
    public ArrayList<Integer>  ind3 =new ArrayList<Integer>();
    public ArrayList<Rule> rules ;
    public Rule()
    { 
    	rules = new  ArrayList<Rule>();
       rule_text = new String();
    }
    public Rule(Rule Rl)
    { 
    	rules = new ArrayList<Rule>(Rl.rules);
       //rule_text = new String();
    }
    
    public void print_rule( )
    { Random number_generator = new Random();
    	//double source_index = number_generator.nextDouble();
    	//double sourc_index=(double)((int)( source_index *100))/100;
        String temp = new String("IF (");
        temp = temp.concat(src);
        temp = temp.concat("=");
        temp = temp.concat(src0);
        temp = temp.concat(") and ( ");
        temp = temp.concat(src2);
        temp = temp.concat(src3);
        temp = temp.concat(src4 );   //Double.toString(sourc_index));
        temp = temp.concat(" ) THEN ( ");
        temp = temp.concat(trg);
        temp = temp.concat(" )");
        rule_text = temp ;
    }
    public Rule create_rules(Input r)
    { 

		int rules_size;
		int source_index;
		int source_index0;
		int source_index1;
		int source_index2;
		int target_index;
		Random number_generator = new Random();
			source_index = number_generator.nextInt(Input.Context().length);
			ind1.add(source_index);
			source_index0 = number_generator.nextInt(Input.ValuesOfContext().length);
			source_index1 = number_generator.nextInt(Input.Metrics().length);
			ind2.add(source_index1);
			source_index2 = number_generator.nextInt(Input.Operator().length);
			target_index = number_generator.nextInt(Input.Problem().length);
			ind3.add(target_index);
			// System.out.println(source_index1);
			Rule temp = new Rule();
			temp.src = Input.Context()[source_index];
			temp.src0 = Input.ValuesOfContext()[source_index0];
			temp.src2 = Input.Metrics()[source_index1];
			temp.src3 = Input.Operator()[source_index2];
			temp.src4 = Input.Val_Metric();
			temp.trg = Input.Problem()[target_index];
			// print_metamodel(temp.src,temp.src0,temp.src2,temp.trg);

			temp.print_rule();
			this.rules.add(temp);
			System.out.println(temp.rule_text);
		
	
	return temp;
        
    }
    public void print_rules()
    {
        //System.out.println("**********solution******** ");
        for (int i=0; i<rules.size();i++)
        {
            System.out.println("\n"+(i+1)+" : "+rules.get(i).rule_text);
        }
    }}

    



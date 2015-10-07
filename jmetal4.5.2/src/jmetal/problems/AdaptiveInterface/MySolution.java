package jmetal.problems.AdaptiveInterface;

import java.io.File;




import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import jmetal.core.Solution;
import jmetal.core.SolutionSet;
import jmetal.encodings.solutionType.IntSolutionType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class MySolution {
	//public static ArrayList<Rule> rules = new ArrayList<Rule> ();
	// test commit
	// second commit 
	public static ArrayList<Integer> ind1 = new ArrayList<Integer>();
	public static ArrayList<Integer> ind2 = new ArrayList<Integer>();
	public static ArrayList<Integer> ind3 = new ArrayList<Integer>();
	public static int NumberOfVaraibles ;
	int min_rules_size = 5;
	int max_rules_size = 10; 
	//public static int rules_size = 0;
	/*public int SolutionSize ( int min_rules_size , int max_rules_size )
	
	{   rules_size = 0;
		Random number_generator = new Random();
		rules_size = min_rules_size+ (int) (Math.random() * ((max_rules_size - min_rules_size) + 1));
	    rules_size = number_generator.nextInt(max_rules_size);
		 if (rules_size < min_rules_size) rules_size = min_rules_size;
        System.out.println("\n number of rules to create : "+rules_size);
		return rules_size;
		
	}*/
	 
	/*public static ArrayList<Rule> getRules() {
		return rules;
	}

	public static void setRules(ArrayList<Rule> rules) {
		MySolution.rules = rules;
	}*/

	public Rule create_rule(Input input)
	{int source_index;
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
		//rules.add(temp);
		
		System.out.println(temp.rule_text);
		return temp;
		
	}
	public Rule create_rule2(Input input)
	{int source_index;
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
		//rules.add(temp);
		
		System.out.println(temp.rule_text);
		return temp;
		
	}
	
	
	public void create_solution(Input r, int value) {
		int rules_size;
		int source_index;
		int source_index0;
		int source_index1;
		int source_index2;
		int target_index;
		Random number_generator = new Random();
		for (int i = 0; i < value; i++) {
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
			//rules.add(temp);
			System.out.println(temp.rule_text);
		}
	
	}
	/*public void print_rules() {
		System.out.println("\n Tree decomposition into leaves : ");
		for (int i = 0; i < rules.size(); i++) {
			System.out.println("\n leaf number " + (i + 1) + " : "
					+ rules.get(i).rule_text);
		}
	}*/
	
	public void Mymutation(int value , Rule rule)
	 {   
		  Random number_generator = new Random();
	      int nb =1;
	    nb = (int) (Math.random() * 2 ); 
	     // System.out.println("nombre à choisir : "+nb);
	      System.out.println("mutation point: "+value);
	      //System.out.println("size of list : "+IntSolutionType.rules.size());
	   if (nb==0)
	      {System.out.println("#####################"+rule.rule_text);
	      Rule temp = new Rule();
	      int source_index1 = number_generator.nextInt(Input.ValuesOfContext().length);
	      int source_index3 = number_generator.nextInt(Input.Operator().length);
	      int source_index4 = number_generator.nextInt(Input.Val_Metric().length());  
	     rule.src0 = Input.ValuesOfContext()[source_index1];
	      rule.src3 = Input.Operator()[source_index3];
	      rule.src4 = Input.Val_Metric();
	      IntSolutionType.Listrules.set(value, rule);
	     // IntSolutionType.rules.set(value,rule);
	      //Rules[value] = temp ;
	     // System.out.println("*******"+IntSolutionType.rules.get(value).rule_text);
	      }
	      if ( nb==1)
	    	  
	      {System.out.println("*******************"+rule.rule_text);
	    	  
	    	  //IntSolutionType.rules.remove(IntSolutionType.rules.get(value))  ;
	      IntSolutionType.Listrules.remove(rule);
	     // IntSolutionType.rules_size=IntSolutionType.rules_size-1;
	 //     IntSolutionType.rules_size=IntSolutionType.rules_size-1;
	    	//  IntSolutionType.rules.set(value, null);
	    	//System.out.println("size of list after remove : "+IntSolutionType.rules.size());
	    	/*for(int i= 0; i<rules.size();i++)
	    	{
	    		System.out.println("after mutation \n ");
	    		System.out.println(rules.get(i).rule_text);
	    	}*/
	      }
	      //for(int i=0;i<rules.size();i++){System.out.println("*******"+rules.get(i).rule_text);}
	 } 
	public Rule [] MyCrossover (ArrayList<Rule> parent1, ArrayList<Rule> parent2 , int min_rules_size )
	{
			
			
			/*for (int i = 0; i <parent1.size(); i++) {
				
				parent1.get(i).print_rules();		}
			
			for (int i = 0; i <parent2.size(); i++) {
				parent2.get(i).print_rules();		}*/
		    Rule Tab [] = new  Rule [2] ;
			
			Rule temp_rule = new Rule();
			ArrayList<Rule> Array_temp = new ArrayList<Rule>();
			ArrayList<Rule> Array_temp2 = new ArrayList<Rule>();
			//temp_rule = parents.get(i).rules.get(first_rule_index);
			//temp_rule = parents.get(i).rules.get(1);
			for (int j = 0; j < min_rules_size-1 ; j++){ 
				temp_rule = parent1.get(j);
				Array_temp.add(temp_rule);
				}
			for (int j = 0; j < min_rules_size-1 ; j++){ 
				temp_rule = parent2.get(j);
				Array_temp2.add(temp_rule);
				}
			for(int h= 0; h<min_rules_size-1;h++)
			{parent1.set(h, Array_temp2.get(h));
			//System.out.println("parent 1 : "+parent1.get(h).rule_text);
			} 
			
			for(int h= 0; h<min_rules_size-1;h++)
			{parent2.set(h, Array_temp.get(h));
			//System.out.println("parent 2 : "+parent2.get(h).rule_text);
			}
			/*for (int i = 0; i <parent1.size(); i++) {
				System.out.println("parent 1 : "+parent1.get(i).rule_text );		}
		     System.out.println("*********************");
		    for (int i = 0; i <parent2.size(); i++) {
			System.out.println("parent 2 : "+parent2.get(i).rule_text );		}*/
		return null;
	}
	public double fitness_1()
	{   
		double fitt = 0.0 ;
	    fitt = IntSolutionType.rules.size();     //(double)((int)rules.size())/((int)100);
		 System.out.println("fit1"+IntSolutionType.rules.size());
		//System.out.println("fitness 1 = "+fitt);
	    
	   // fitt = 1 - fitt ;
		return fitt ;
		
	}
	public double fitness_2()
	{
		double fit2 = 0.0;
		double []  Nbr_Occ_Trace =new double[16];
		double []  Nbr_Occ_Solution = new double[16]; 
		                                           //density unity regularity sequence  grouping  simplicity
		String [][]  Interface_Metric = {{"InterfaceA","0.23","0.55","0.78","0.52","0.47","0.98"},
		                                 {"InterfaceB","0.41","0.76","0.54","0.45","0.19","0.72"},
		                                 {"InterfaceC","0.65","0.82","0.50","0.51","0.72","0.44"},
		                                 {"InterfaceD","0.56","0.18","0.42","0.48","0.54","0.50"},
		                                 {"InterfaceE","0.18","0.56","0.87","0.71","0.23","0.90"},
		                                 {"InterfaceF","0.85","0.46","0.27","0.21","0.67","0.28"},
		                                 {"InterfaceG","0.93","0.64","0.35","0.67","0.38","0.14"},
		                                 {"InterfaceH","0.71","0.15","0.20","0.36","0.23","0.14"},
		                                 {"InterfaceI","0.63","0.70","0.89","0.04","0.21","0.26"},
		                                 {"InterfaceJ","0.48","0.15","0.64","0.38","0.84","0.90"},
		                                 {"InterfaceK","0.03","0.54","0.72","0.49","0.32","0.55"},
		                                 {"InterfaceL","0.32","0.29","0.01","0.37","0.04","0.79"},
		                                 {"InterfaceM","0.12","0.45","0.24","0.50","0.70","0.44"},
		                                 {"InterfaceN","0.30","0.15","0.52","0.58","0.33","0.54"},
		                                 {"InterfaceO","0.54","0.24","0.67","0.20","0.85","0.90"}};       //new double[7][];
		//System.out.println( Interface_Metric[1][6]);
		//System.out.println( Interface_Metric[6][1]);
	
		int Nbr_prob =0;
		 int k=1;
		 int t=1;
		 String nomFichier = "D:/perfect_rules.txt";
		 String val01 = null  ;
		 Workbook workbook = null;
		 
			/* Récupération du classeur Excel (en lecture) */
			try {
				workbook = Workbook.getWorkbook(new File("Trace/Trace2.xls"));
			} catch (BiffException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			/* Un fichier excel est composé de plusieurs feuilles, on y accède de la manière suivante*/
			Sheet sheet =  workbook.getSheet(0);
			
			// Nombre d'occurence de chaque problem dans le trace 
			  for(int f= 0 ; f<= 250; f++)    // Nombre initiale 66
			  {
				 
				  jxl.Cell cell21 =  sheet.getCell(5, f);
				  String Pro1 =  cell21.getContents();
              	if( (Pro1.equalsIgnoreCase("Interface chargé")))
              	      {  Nbr_Occ_Trace[0]++; }
              	if(  (Pro1.equalsIgnoreCase("Interface non chargé")))
        	              {  Nbr_Occ_Trace[1]++; }
              	if( (Pro1.equalsIgnoreCase("Guidage fort")))
        	              {   Nbr_Occ_Trace[2]++; }
              	if((Pro1.equalsIgnoreCase("Guidage faible")))
        	              {   Nbr_Occ_Trace[3]++; }
              	if( (Pro1.equalsIgnoreCase("Interface non ordonné")))
        	              {   Nbr_Occ_Trace[4]++; }
              	if( (Pro1.equalsIgnoreCase("Interface ordonné")))
        	              {   Nbr_Occ_Trace[5]++; }
              	if( (Pro1.equalsIgnoreCase("Interface complexe")))
        	              {   Nbr_Occ_Trace[6]++; }
              	if( (Pro1.equalsIgnoreCase("Interface simple")))
        	              {   Nbr_Occ_Trace[7]++; }
              	if((Pro1.equalsIgnoreCase("Interface centré")))
        	              {   Nbr_Occ_Trace[8]++; }
              	if((Pro1.equalsIgnoreCase("Interface non centré")))
        	              {   Nbr_Occ_Trace[9]++; }
              	if( (Pro1.equalsIgnoreCase("Interface regulié")))
        	              {   Nbr_Occ_Trace[10]++; }
              	if( (Pro1.equalsIgnoreCase("Interface irregulié")))
        	              {   Nbr_Occ_Trace[11]++; }
              	if( (Pro1.equalsIgnoreCase("Problem71")))
        	              {   Nbr_Occ_Trace[12]++; }
              	if( (Pro1.equalsIgnoreCase("Problem72")))
        	              {   Nbr_Occ_Trace[13]++; }
              	if((Pro1.equalsIgnoreCase("Problem81")))
        	              {   Nbr_Occ_Trace[14]++; }
              	if((Pro1.equalsIgnoreCase("Problem82")))
  	              {   Nbr_Occ_Trace[15]++; }
              
	         
       }
		  for (int i=0; i<IntSolutionType.rules.size();i++){
			  
			  String Context =IntSolutionType.rules.get(i).src ;
			  String Problem=IntSolutionType.rules.get(i).trg ;
			  String operateur = IntSolutionType.rules.get(i).src3 ; 
			  String Metric=IntSolutionType.rules.get(i).src2 ;
			  String Perfect =IntSolutionType.rules.get(i).rule_text ;
			  String Val_Metric = IntSolutionType.rules.get(i).src4;
			  double Metric1 = 0.0 ;
			  double Metric2 = 0.0 ;
			  //System.out.println("///////////////////"+Val_Metric);
			  k =1;
			  boolean bol = false;
			//  System.out.println("Context:"+Context);
			         
			  for(int j=0;j<5;j++)
				  
			  {
			  jxl.Cell cell =  sheet.getCell(j, 0);
				String Cont =  cell.getContents();
             
	          if((Context.equalsIgnoreCase(Cont))){
			     // int index_context = j;
			    
				  String  Valeur =IntSolutionType.rules.get(i).src0 ;
				 
				  while (k<250 && bol == false ){
					 
					  jxl.Cell cell21 =  sheet.getCell(5, k);
					  String Pro1 =  cell21.getContents();
					  
					
	                	jxl.Cell Valeurs =  sheet.getCell(j, k);
	                	String Val =  Valeurs.getContents();
	                	//System.out.println("Valeur = "+Valeur+"   "+"Val = "+Val);
	                	//System.out.println("Problem = "+Problem+"   "+"Pro1 = "+Pro1);
	                	if((Valeur.equalsIgnoreCase(Val) &&(Problem.equalsIgnoreCase(Pro1))))
	                	{    //System.out.println("--------------------------Thats right--------------------------");
	                	     if ((  Context =="Age" && ((Metric=="Regularity" && (Problem=="Interface regulié"||Problem=="Interface irregulié")) || (Metric=="Grouping"&& (Problem=="Guidage fort"||Problem=="Guidage faible"))||(Metric=="Sequence"&& (Problem=="Interface ordonné"||Problem=="Interface non ordonné"))||(Metric=="Simplicity"&& (Problem=="Interface complexe"||Problem=="Interface simple"))))
	                			 ||(Context=="Motivation" && ((Metric=="Unity"&& (Problem=="Interface centré"||Problem=="Interface non centré"))||(Metric=="Grouping"&& (Problem=="Guidage fort"||Problem=="Guidage faible"))||(Metric=="Density"&& (Problem=="Interface chargé"||Problem=="Interface non chargé"))||(Metric=="Homogeneity"&& (Problem=="Problem"||Problem=="Problem"))))
	                			 ||(Context=="Education Level" && ((Metric=="Regularity"&& (Problem=="Interface regulié"||Problem=="Interface irregulié"))||(Metric=="Density"&& (Problem=="Interface chargé"||Problem=="Interface non chargé"))||(Metric=="Symmetry"&& (Problem=="Problem"||Problem=="Problem"))||(Metric=="Simplicity"&& (Problem=="Interface simple"||Problem=="Interface complexe"))))
	                			 ||(Context=="User Experience" && ((Metric=="Regularity"&& (Problem=="Interface regulié"||Problem=="Interface irregulié"))||(Metric=="Sequence"&& (Problem=="Interface ordonné"||Problem=="Interface non ordonné"))||(Metric=="Simplicity"&& (Problem=="Interface simple"||Problem=="Interface complexe"))))
	                			 ||(Context=="Interest" && ((Metric=="Density"&& (Problem=="Interface chargé"||Problem=="Interface non chargé"))||(Metric=="Symmetry"&& (Problem=="Problem"||Problem=="Problem"))||(Metric=="Sequence")&& (Problem=="Interface ordonné"||Problem=="Interface non ordonné"))))
	                		      {  jxl.Cell cell23 =  sheet.getCell(6, k);
	        					     String Interface =  cell23.getContents();
	        					             if (Interface.equalsIgnoreCase("InterfaceA"))
	        					               { 
	        					            	 System.out.println("****************************");
	        					            	 if (Metric=="Regularity") {  val01 =  Interface_Metric[0][3];}
	        					            	  if (Metric=="Grouping")   {  val01 =  Interface_Metric[0][5];}
	        					                  if (Metric=="Sequence")   {  val01 =  Interface_Metric[0][4];}
	        					                  if (Metric=="Simplicity") {  val01 =  Interface_Metric[0][6];}
	        					                  if (Metric=="Density")    {  val01 =  Interface_Metric[0][1];} 
		        					              if (Metric=="Unity")      {  val01 =  Interface_Metric[0][2];}
	        					            	 
	        					                  /*if (Metric=="Homogeneity") {  val01 =   Interface_Metric[1][7];}
	        					                     if (Metric=="Symmetry") {  val01 =   Interface_Metric[1][8];}*/
	        					                
	        					               }
	        					       
	        					            else if (Interface.equalsIgnoreCase("InterfaceB"))
				        					    { 
				        					         if (Metric=="Regularity") {  val01 =  Interface_Metric[1][3];}
					        					     if (Metric=="Grouping")   {  val01 =  Interface_Metric[1][5];}
					        					     if (Metric=="Sequence")   {  val01 =  Interface_Metric[1][4];}
					        					     if (Metric=="Simplicity") {  val01 =  Interface_Metric[1][6];}
					        					     if (Metric=="Density")    {  val01 =  Interface_Metric[1][1];} 
						        					 if (Metric=="Unity")      {  val01 =  Interface_Metric[1][2];}
		        					                  /*if (Metric=="Homogeneity") {  val01 =   Interface_Metric[2][7];}
		        					                    if (Metric=="Symmetry") { val01 =   Interface_Metric[2][8];}*/
		        					                
				        					     }
				        					            	 
				        					           
	        					             
	        					             else  if (Interface.equalsIgnoreCase("InterfaceC"))
				        					    { 
			        					         if (Metric=="Regularity") {  val01 =  Interface_Metric[2][3];}
				        					     if (Metric=="Grouping")   {  val01 =  Interface_Metric[2][5];}
				        					     if (Metric=="Sequence")   {  val01 =  Interface_Metric[2][4];}
				        					     if (Metric=="Simplicity") {  val01 =  Interface_Metric[2][6];}
				        					     if (Metric=="Density")    {  val01 =  Interface_Metric[2][1];} 
					        					 if (Metric=="Unity")      {  val01 =  Interface_Metric[2][2];}
	        					                  /*if (Metric=="Homogeneity") {  val01 =   Interface_Metric[2][7];}
	        					                    if (Metric=="Symmetry") { val01 =   Interface_Metric[2][8];}*/
	        					                
			        					     }
	        					             else if (Interface.equalsIgnoreCase("Interfaced"))
				        					    { 
				        					         if (Metric=="Regularity") {  val01 =  Interface_Metric[3][3];}
					        					     if (Metric=="Grouping")   {  val01 =  Interface_Metric[3][5];}
					        					     if (Metric=="Sequence")   {  val01 =  Interface_Metric[3][4];}
					        					     if (Metric=="Simplicity") {  val01 =  Interface_Metric[3][6];}
					        					     if (Metric=="Density")    {  val01 =  Interface_Metric[3][1];} 
						        					 if (Metric=="Unity")      {  val01 =  Interface_Metric[3][2];}
		        					                  /*if (Metric=="Homogeneity") {  val01 =   Interface_Metric[2][7];}
		        					                    if (Metric=="Symmetry") { val01 =   Interface_Metric[2][8];}*/
		        					                
				        					     }

	        					             else if (Interface.equalsIgnoreCase("InterfaceE"))
				        					    { 
				        					         if (Metric=="Regularity") {  val01 =  Interface_Metric[4][3];}
					        					     if (Metric=="Grouping")   {  val01 =  Interface_Metric[4][5];}
					        					     if (Metric=="Sequence")   {  val01 =  Interface_Metric[4][4];}
					        					     if (Metric=="Simplicity") {  val01 =  Interface_Metric[4][6];}
					        					     if (Metric=="Density")    {  val01 =  Interface_Metric[4][1];} 
						        					 if (Metric=="Unity")      {  val01 =  Interface_Metric[4][2];}
		        					                  /*if (Metric=="Homogeneity") {  val01 =   Interface_Metric[2][7];}
		        					                    if (Metric=="Symmetry") { val01 =   Interface_Metric[2][8];}*/
		        					                
				        					     }
				        					            	 
				        					            	 
	        					             else if (Interface.equalsIgnoreCase("InterfaceF"))
					        				   { 
					        					     if (Metric=="Regularity") {  val01 =  Interface_Metric[5][3];}
						        					 if (Metric=="Grouping")   {  val01 =  Interface_Metric[5][5];}
						        					 if (Metric=="Sequence")   {  val01 =  Interface_Metric[5][4];}
						        					 if (Metric=="Simplicity") {  val01 =  Interface_Metric[5][6];}
						        					 if (Metric=="Density")    {  val01 =  Interface_Metric[5][1];} 
							        				 if (Metric=="Unity")      {  val01 =  Interface_Metric[5][2];}
		        					                  /*if (Metric=="Homogeneity") {  val01 =   Interface_Metric[2][7];}
		        					                    if (Metric=="Symmetry") { val01 =   Interface_Metric[2][8];}*/
		        					               
					        				   }
					        					            	
	        					             else if (Interface.equalsIgnoreCase("InterfaceG"))
						        			  { 
						        					  if (Metric=="Regularity") {  val01 =  Interface_Metric[6][3];}
							        				  if (Metric=="Grouping")   {  val01 =  Interface_Metric[6][5];}
							        				  if (Metric=="Sequence")   {  val01 =  Interface_Metric[6][4];}
							        				  if (Metric=="Simplicity") {  val01 =  Interface_Metric[6][6];}
							        				  if (Metric=="Density")    {  val01 =  Interface_Metric[6][1];} 
								        			  if (Metric=="Unity")      {  val01 =  Interface_Metric[6][2];}         	 
		        					                  /*if (Metric=="Homogeneity") {  val01 =   Interface_Metric[2][7];}
		        					                    if (Metric=="Symmetry") { val01 =   Interface_Metric[2][8];}*/
                                                }
	        					             else if (Interface.equalsIgnoreCase("InterfaceH"))
						        			  { 
						        					  if (Metric=="Regularity") {  val01 =  Interface_Metric[7][3];}
							        				  if (Metric=="Grouping")   {  val01 =  Interface_Metric[7][5];}
							        				  if (Metric=="Sequence")   {  val01 =  Interface_Metric[7][4];}
							        				  if (Metric=="Simplicity") {  val01 =  Interface_Metric[7][6];}
							        				  if (Metric=="Density")    {  val01 =  Interface_Metric[7][1];} 
								        			  if (Metric=="Unity")      {  val01 =  Interface_Metric[7][2];}         	 
		        					                  /*if (Metric=="Homogeneity") {  val01 =   Interface_Metric[2][7];}
		        					                    if (Metric=="Symmetry") { val01 =   Interface_Metric[2][8];}*/
                                               }
	        					             else if (Interface.equalsIgnoreCase("InterfaceI"))
						        			  { 
						        					  if (Metric=="Regularity") {  val01 =  Interface_Metric[8][3];}
							        				  if (Metric=="Grouping")   {  val01 =  Interface_Metric[8][5];}
							        				  if (Metric=="Sequence")   {  val01 =  Interface_Metric[8][4];}
							        				  if (Metric=="Simplicity") {  val01 =  Interface_Metric[8][6];}
							        				  if (Metric=="Density")    {  val01 =  Interface_Metric[8][1];} 
								        			  if (Metric=="Unity")      {  val01 =  Interface_Metric[8][2];}         	 
		        					                  /*if (Metric=="Homogeneity") {  val01 =   Interface_Metric[2][7];}
		        					                    if (Metric=="Symmetry") { val01 =   Interface_Metric[2][8];}*/
                                               }
	        					             else if (Interface.equalsIgnoreCase("InterfaceJ"))
						        			  { 
						        					  if (Metric=="Regularity") {  val01 =  Interface_Metric[9][3];}
							        				  if (Metric=="Grouping")   {  val01 =  Interface_Metric[9][5];}
							        				  if (Metric=="Sequence")   {  val01 =  Interface_Metric[9][4];}
							        				  if (Metric=="Simplicity") {  val01 =  Interface_Metric[9][6];}
							        				  if (Metric=="Density")    {  val01 =  Interface_Metric[9][1];} 
								        			  if (Metric=="Unity")      {  val01 =  Interface_Metric[9][2];}         	 
		        					                  /*if (Metric=="Homogeneity") {  val01 =   Interface_Metric[2][7];}
		        					                    if (Metric=="Symmetry") { val01 =   Interface_Metric[2][8];}*/
                                               }
	        					             else if (Interface.equalsIgnoreCase("InterfaceK"))
						        			  { 
						        					  if (Metric=="Regularity") {  val01 =  Interface_Metric[10][3];}
							        				  if (Metric=="Grouping")   {  val01 =  Interface_Metric[10][5];}
							        				  if (Metric=="Sequence")   {  val01 =  Interface_Metric[10][4];}
							        				  if (Metric=="Simplicity") {  val01 =  Interface_Metric[10][6];}
							        				  if (Metric=="Density")    {  val01 =  Interface_Metric[10][1];} 
								        			  if (Metric=="Unity")      {  val01 =  Interface_Metric[10][2];}         	 
		        					                  /*if (Metric=="Homogeneity") {  val01 =   Interface_Metric[2][7];}
		        					                    if (Metric=="Symmetry") { val01 =   Interface_Metric[2][8];}*/
                                               }
	        					             else if (Interface.equalsIgnoreCase("InterfaceL"))
						        			  { 
						        					  if (Metric=="Regularity") {  val01 =  Interface_Metric[11][3];}
							        				  if (Metric=="Grouping")   {  val01 =  Interface_Metric[11][5];}
							        				  if (Metric=="Sequence")   {  val01 =  Interface_Metric[11][4];}
							        				  if (Metric=="Simplicity") {  val01 =  Interface_Metric[11][6];}
							        				  if (Metric=="Density")    {  val01 =  Interface_Metric[11][1];} 
								        			  if (Metric=="Unity")      {  val01 =  Interface_Metric[11][2];}         	 
		        					                  /*if (Metric=="Homogeneity") {  val01 =   Interface_Metric[2][7];}
		        					                    if (Metric=="Symmetry") { val01 =   Interface_Metric[2][8];}*/
                                               }
	        					             else if (Interface.equalsIgnoreCase("InterfaceM"))
						        			  { 
						        					  if (Metric=="Regularity") {  val01 =  Interface_Metric[12][3];}
							        				  if (Metric=="Grouping")   {  val01 =  Interface_Metric[12][5];}
							        				  if (Metric=="Sequence")   {  val01 =  Interface_Metric[12][4];}
							        				  if (Metric=="Simplicity") {  val01 =  Interface_Metric[12][6];}
							        				  if (Metric=="Density")    {  val01 =  Interface_Metric[12][1];} 
								        			  if (Metric=="Unity")      {  val01 =  Interface_Metric[12][2];}         	 
		        					                  /*if (Metric=="Homogeneity") {  val01 =   Interface_Metric[2][7];}
		        					                    if (Metric=="Symmetry") { val01 =   Interface_Metric[2][8];}*/
                                               }
	        					             else if (Interface.equalsIgnoreCase("InterfaceN"))
						        			  { 
						        					  if (Metric=="Regularity") {  val01 =  Interface_Metric[13][3];}
							        				  if (Metric=="Grouping")   {  val01 =  Interface_Metric[13][5];}
							        				  if (Metric=="Sequence")   {  val01 =  Interface_Metric[13][4];}
							        				  if (Metric=="Simplicity") {  val01 =  Interface_Metric[13][6];}
							        				  if (Metric=="Density")    {  val01 =  Interface_Metric[13][1];} 
								        			  if (Metric=="Unity")      {  val01 =  Interface_Metric[13][2];}         	 
		        					                  /*if (Metric=="Homogeneity") {  val01 =   Interface_Metric[2][7];}
		        					                    if (Metric=="Symmetry") { val01 =   Interface_Metric[2][8];}*/
                                               }
	        					             else if (Interface.equalsIgnoreCase("InterfaceO"))
						        			  { 
						        					  if (Metric=="Regularity") {  val01 =  Interface_Metric[14][3];}
							        				  if (Metric=="Grouping")   {  val01 =  Interface_Metric[14][5];}
							        				  if (Metric=="Sequence")   {  val01 =  Interface_Metric[14][4];}
							        				  if (Metric=="Simplicity") {  val01 =  Interface_Metric[14][6];}
							        				  if (Metric=="Density")    {  val01 =  Interface_Metric[14][1];} 
								        			  if (Metric=="Unity")      {  val01 =  Interface_Metric[14][2];}         	 
		        					                  /*if (Metric=="Homogeneity") {  val01 =   Interface_Metric[2][7];}
		        					                    if (Metric=="Symmetry") { val01 =   Interface_Metric[2][8];}*/
                                               }
	        					             else 
	        					                     {  val01 = "0.0";  }
	        					                     
	        					           Metric1 = Double.parseDouble(Val_Metric);
	        					           Metric2 = Double.parseDouble(val01);
	        					           
	        					              if ((Problem.equalsIgnoreCase("Interface chargé")||Problem.equalsIgnoreCase("Interface regulié")||Problem.equalsIgnoreCase("Interface ordonné")||Problem.equalsIgnoreCase("Guidage fort")||Problem.equalsIgnoreCase("Interface centré")||Problem.equalsIgnoreCase("Interface simple") )
	        					            		  && (operateur.equalsIgnoreCase(">=")) && (Metric1 >= Metric2))
	        					                  //if (Val_Metric.equalsIgnoreCase(val01))
	        					                  {//System.out.println("--------------------------Thats right--------------------------");
	        					        	             // System.out.println("(((())))))))"+val01+"    "+Metric+"        "+Interface);
	        					        	            Nbr_prob++  ;
	        					        	           //perfect_rule.add(Perfect);
		                			             
	             			                          if( (Problem.equalsIgnoreCase("Interface chargé")))
	                         	                                {  //System.out.println("--------------------------");
	             			                        	             Nbr_Occ_Solution[0] =  Nbr_Occ_Solution[0]+1; }
	                         	                      if(  (Problem.equalsIgnoreCase("Interface non chargé")))
	                   	                                        {  Nbr_Occ_Solution[1]= Nbr_Occ_Solution[1]+1 ; }
	                         	                      if( (Problem.equalsIgnoreCase("Guidage fort")))
	                   	                                        {   Nbr_Occ_Solution[2] =  Nbr_Occ_Solution[2] + 1 ;}
	                         	                      if((Problem.equalsIgnoreCase("Guidage faible")))
	                   	                                          {  Nbr_Occ_Solution[3] =  Nbr_Occ_Solution[3]+1;}
	                         	                      if( (Problem.equalsIgnoreCase("Interface non ordonné")))
	                   	                                           {   Nbr_Occ_Solution[4] = Nbr_Occ_Solution[4]+1 ; }
	                         	                      if( (Problem.equalsIgnoreCase("Interface ordonné")))
	                   	                                       {   Nbr_Occ_Solution[5] = Nbr_Occ_Solution[5]+1; }
	                         	                      if( (Problem.equalsIgnoreCase("Interface complexe")))
	                   	                                        {   Nbr_Occ_Solution[6] = Nbr_Occ_Solution[6]+1; }
	                         	                      if( (Problem.equalsIgnoreCase("Interface simple")))
	                   	                                        {   Nbr_Occ_Solution[7] = Nbr_Occ_Solution[7]+1;}
	                         	                      if((Problem.equalsIgnoreCase("Interface centré")))
	                   	                                         {   Nbr_Occ_Solution[8] = Nbr_Occ_Solution[8]+1; }
	                         	                      if((Problem.equalsIgnoreCase("Interface non centré")))
	                   	                                       {  Nbr_Occ_Solution[9] = Nbr_Occ_Solution[9]+1; }
	                         	                      if( (Problem.equalsIgnoreCase("Interface regulié")))
	                   	                                        {   Nbr_Occ_Solution[10] =  Nbr_Occ_Solution[10]+1; }
	                         	                      if( (Problem.equalsIgnoreCase("Interface irregulié")))
	                   	                                        {   Nbr_Occ_Solution[11] = Nbr_Occ_Solution[11]+1; }
	                         	                      if( (Problem.equalsIgnoreCase("Problem71")))
	                   	                                      {   Nbr_Occ_Solution[12] = Nbr_Occ_Solution[12]+1; }
	                         	                      if( (Problem.equalsIgnoreCase("Problem72")))
	                   	                                       {   Nbr_Occ_Solution[13] = Nbr_Occ_Solution[13]+1; }
	                         	                      if((Problem.equalsIgnoreCase("Problem81")))
	                   	                                      {   Nbr_Occ_Solution[14] = Nbr_Occ_Solution[14]+1; }
	                         	                      if((Problem.equalsIgnoreCase("Problem82")))
	             	                                          {   Nbr_Occ_Solution[15] = Nbr_Occ_Solution[15]+1; }  
	        					           
	        					           }

	        					            if ((Problem.equalsIgnoreCase("Interface non chargé")||Problem.equalsIgnoreCase("Interface irrregulié")||Problem.equalsIgnoreCase("Interface non ordonné")||Problem.equalsIgnoreCase("Guidage faible")||Problem.equalsIgnoreCase("Interface non centré")||Problem.equalsIgnoreCase("Interface complexe") )
	        					            		  && (operateur.equalsIgnoreCase("<=")) && (Metric1 <=  Metric2))
	        					              {//System.out.println("--------------------------Thats right--------------------------");
		        					        	  // System.out.println("(((())))))))"+val01+"    "+Metric+"        "+Interface);
		        					        	     Nbr_prob++  ;
		        					        	     //perfect_rule.add(Perfect);
			                			             
		             			                          if( (Problem.equalsIgnoreCase("Interface chargé")))
		                         	                                {  System.out.println("--------------------------");
		             			                        	             Nbr_Occ_Solution[0] =  Nbr_Occ_Solution[0]+1; }
		                         	                      if(  (Problem.equalsIgnoreCase("Interface non chargé")))
		                   	                                        {  Nbr_Occ_Solution[1]= Nbr_Occ_Solution[1]+1 ; }
		                         	                      if( (Problem.equalsIgnoreCase("Guidage fort")))
		                   	                                        {   Nbr_Occ_Solution[2] =  Nbr_Occ_Solution[2] + 1 ;}
		                         	                      if((Problem.equalsIgnoreCase("Guidage faible")))
		                   	                                          {  Nbr_Occ_Solution[3] =  Nbr_Occ_Solution[3]+1;}
		                         	                      if( (Problem.equalsIgnoreCase("Interface non ordonné")))
		                   	                                           {   Nbr_Occ_Solution[4] = Nbr_Occ_Solution[4]+1 ; }
		                         	                      if( (Problem.equalsIgnoreCase("Interface ordonné")))
		                   	                                       {   Nbr_Occ_Solution[5] = Nbr_Occ_Solution[5]+1; }
		                         	                      if( (Problem.equalsIgnoreCase("Interface complexe")))
		                   	                                        {   Nbr_Occ_Solution[6] = Nbr_Occ_Solution[6]+1; }
		                         	                      if( (Problem.equalsIgnoreCase("Interface simple")))
		                   	                                        {   Nbr_Occ_Solution[7] = Nbr_Occ_Solution[7]+1;}
		                         	                      if((Problem.equalsIgnoreCase("Interface centré")))
		                   	                                         {   Nbr_Occ_Solution[8] = Nbr_Occ_Solution[8]+1; }
		                         	                      if((Problem.equalsIgnoreCase("Interface non centré")))
		                   	                                       {  Nbr_Occ_Solution[9] = Nbr_Occ_Solution[9]+1; }
		                         	                      if( (Problem.equalsIgnoreCase("Interface regulié")))
		                   	                                        {   Nbr_Occ_Solution[10] =  Nbr_Occ_Solution[10]+1; }
		                         	                      if( (Problem.equalsIgnoreCase("Interface irregulié")))
		                   	                                        {   Nbr_Occ_Solution[11] = Nbr_Occ_Solution[11]+1; }
		                         	                      if( (Problem.equalsIgnoreCase("Problem71")))
		                   	                                      {   Nbr_Occ_Solution[12] = Nbr_Occ_Solution[12]+1; }
		                         	                      if( (Problem.equalsIgnoreCase("Problem72")))
		                   	                                       {   Nbr_Occ_Solution[13] = Nbr_Occ_Solution[13]+1; }
		                         	                      if((Problem.equalsIgnoreCase("Problem81")))
		                   	                                      {   Nbr_Occ_Solution[14] = Nbr_Occ_Solution[14]+1; }
		                         	                      if((Problem.equalsIgnoreCase("Problem82")))
		             	                                          {   Nbr_Occ_Solution[15] = Nbr_Occ_Solution[15]+1; }  
		        					           
		        					           }
	        					           /* try {
	                						   PrintWriter writer = new PrintWriter(new FileWriter(nomFichier));
	                						  try {
	                			 
	                							for (int u=0;u<perfect_rule.size();u++) {
	                								writer.println(perfect_rule.get(u));
	                							}
	                						} finally {
	                							writer.close();
	                						}
	                					   } catch (IOException e) {
	                						// TODO Auto-generated catch block
	                						e.printStackTrace();
	                					      }*/
	        					       
	        					      
	                			       bol = true;
	                			        
		           	                   

	                	}
	                	}
		            k++; 
	                	}
				  // k =1;
				  
	             }}
			  
	}	 
		  
		  for(int i=0 ;i<Nbr_Occ_Trace.length;i++){
			 //System.out.println("le problem dans le trace "+i+" repeter "+Nbr_Occ_Trace[i]);
			  //System.out.println("le problem dans la solution "+i+" repeter "+Nbr_Occ_Solution[i]);
				fit2 =(fit2 + (Nbr_Occ_Solution[i] / Nbr_Occ_Trace[i])); 
			  }
		  //System.out.println(perfect_rule);
		      fit2= fit2/16 ;
		   double fitness2 = fit2;
		   System.out.println(" fit2 "+ fitness2);
		   return fitness2= ((double)((int)( fitness2*100))/100);
		
	    //System.out.println(" Resultat2 "+ fitness2);
		// System.out.println("Ma liste "+perfect_rule);
		  //this.individual_NbPro= fitness2;   //Nbr_prob;
		  //System.out.println("@@@@@@@@@"+Nbr_prob);
		 
		
	}
	public static void main(String[] args) throws FileNotFoundException,
	IOException {
		Input r = new Input ();
		int value = 1;
		int value2 = 20 ;
		int  min_rules_size = 5;
		int  max_rules_size = 100 ;
		Rule[] Rules = null;
		/*for( int i= 0 ; i< IntSolutionType.rules.length ; i++)
		{Rules[i]=IntSolutionType.rules[i];}*/
		ArrayList <Rule> parent1 = new ArrayList <Rule>();
		ArrayList <Rule> parent2 = new ArrayList <Rule>();
	    
		MySolution S = new  MySolution ();
		for(int i = 0 ; i< 5 ;i++)
		{parent1.add(S.create_rule2(r));}
		for(int i = 0 ; i< 5 ;i++)
		{System.out.println("parent 1 : "+parent1.get(i).rule_text);
		//S.Mymutation(value, parent1.get(value));
		}
		
		for(int i = 0 ; i< 5 ;i++)
		{parent2.add(S.create_rule2(r));}
		for(int i = 0 ; i< 5 ;i++)
		{System.out.println("parent 2 : "+parent2.get(i).rule_text);}
		//S.create_solution(r, value2);
		
		//S.fitness_1();
		S.MyCrossover(parent1, parent2, min_rules_size);
		//S. SolutionSize ( min_rules_size , max_rules_size );
		
	}
}

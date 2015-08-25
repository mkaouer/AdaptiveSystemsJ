package jmetal.problems;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;

import jmetal.core.Problem;
import jmetal.core.Solution;
import jmetal.core.Variable;
import jmetal.encodings.solutionType.ArrayRealSolutionType;
import jmetal.encodings.solutionType.ArrayRuleSolutionType;
import jmetal.encodings.solutionType.Input;
import jmetal.encodings.solutionType.Rule;
import jmetal.util.JMException;
import jmetal.util.wrapper.XReal;
import jmetal.util.wrapper.XRule;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Adapt_Interface extends Problem {
	//ArrayList<Rule> rules;
	Input input = new Input();
	Rule R = new Rule ();
	public Adapt_Interface(String solutionType) throws ClassNotFoundException {
	    this(solutionType, 3);
	  } // Adapt_Interface

	public Adapt_Interface(String solutionType, Integer numberOfVariables) {
		 numberOfVariables_   = numberOfVariables ;    //
		    numberOfObjectives_  = 2                            ;
		    numberOfConstraints_ = 0                            ;
		    problemName_         = "Kursawe"                    ;
		    if (solutionType.compareTo("ArrayRule") == 0)
		    	solutionType_ = new ArrayRuleSolutionType(this) ;
		    else {
		    	System.out.println("Error: solution type " + solutionType + " invalid") ;
		    	System.exit(-1) ;
		    }
	}

	@Override
	public void evaluate(Solution solution) throws JMException {


	     Variable[] variable  = solution.getDecisionVariables();
	     double [] f = new double[numberOfObjectives_];
	     for (int i= 0; i<variable.length;i++)
	     { System.out.println("*************"+variable[i]); }
    double fit2 = 0.0;
	double []  Nbr_Occ_Trace =new double[16];
	double []  Nbr_Occ_Solution = new double[16]; 
	 // this.rules.addAll(R.create_rules(input).rules) ;
	String [][]  Interface_Metric = {{"InterfaceA","0.23","0.55","0.78","0.52","0.47","0.98"},
	                                 {"InterfaceB","0.41","0.76","0.54","0.45","0.19","0.72"},
	                                 {"InterfaceC","0.65","0.82","0.50","0.51","0.72","0.44"},
	                                 {"InterfaceD","0.56","0.18","0.42","0.48","0.54","0.50"},
	                                 {"InterfaceE","0.18","0.56","0.87","0.71","0.23","0.90"},
	                                 {"InterfaceF","0.85","0.46","0.27","0.21","0.67","0.28"},
	                                 {"InterfaceG","0.93","0.64","0.35","0.67","0.38","0.14"}} ;       //new double[7][];
	

	int Nbr_prob =0;
	 int k=1;
	 int t=1;
	 String val01 = null  ;
	 Workbook workbook = null;
	 
		/* Récupération du classeur Excel (en lecture) */
		try {
			workbook = Workbook.getWorkbook(new File("Trace/Trace.xls"));
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
		  for(int v = 0 ; v<= 277; v++)    // Nombre initiale 66
		  {
			 
			  jxl.Cell cell21 =  sheet.getCell(5, v);
			  String Pro1 =  cell21.getContents();
          	if( (Pro1.equalsIgnoreCase("Problem11")))
          	      {  Nbr_Occ_Trace[0]++; }
          	if(  (Pro1.equalsIgnoreCase("Problem12")))
    	              {  Nbr_Occ_Trace[1]++; }
          	if( (Pro1.equalsIgnoreCase("Problem21")))
    	              {   Nbr_Occ_Trace[2]++; }
          	if((Pro1.equalsIgnoreCase("Problem22")))
    	              {   Nbr_Occ_Trace[3]++; }
          	if( (Pro1.equalsIgnoreCase("Problem31")))
    	              {   Nbr_Occ_Trace[4]++; }
          	if( (Pro1.equalsIgnoreCase("Problem32")))
    	              {   Nbr_Occ_Trace[5]++; }
          	if( (Pro1.equalsIgnoreCase("Problem41")))
    	              {   Nbr_Occ_Trace[6]++; }
          	if( (Pro1.equalsIgnoreCase("Problem42")))
    	              {   Nbr_Occ_Trace[7]++; }
          	if((Pro1.equalsIgnoreCase("Problem51")))
    	              {   Nbr_Occ_Trace[8]++; }
          	if((Pro1.equalsIgnoreCase("Problem52")))
    	              {   Nbr_Occ_Trace[9]++; }
          	if( (Pro1.equalsIgnoreCase("Problem61")))
    	              {   Nbr_Occ_Trace[10]++; }
          	if( (Pro1.equalsIgnoreCase("Problem62")))
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
	  for (int i=0; i<R.rules.size();i++){
		  String Context =R.rules.get(i).src ;
		  String Problem=R.rules.get(i).trg ;
		  String Metric=R.rules.get(i).src2 ;
		  String Perfect =R.rules.get(i).rule_text ;
		  String Val_Metric = R.rules.get(i).src4;
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
		    
			  String  Valeur =R.rules.get(i).src0 ;
			 
			  while (k<277 && bol == false ){
				 
				  jxl.Cell cell21 =  sheet.getCell(5, k);
				  String Pro1 =  cell21.getContents();
				  
				
                	jxl.Cell Valeurs =  sheet.getCell(j, k);
                	String Val =  Valeurs.getContents();
                	//System.out.println("Valeur = "+Valeur+"   "+"Val = "+Val);
                	//System.out.println("Problem = "+Problem+"   "+"Pro1 = "+Pro1);
                	if((Valeur.equalsIgnoreCase(Val) &&(Problem.equalsIgnoreCase(Pro1))))
                	{    //System.out.println("--------------------------Thats right--------------------------");
                	     if ((  Context =="Age" && (Metric=="Regularity"||Metric=="Grouping"||Metric=="Sequence"||Metric=="Simplicity"))
                			 ||(Context=="Motivation" && (Metric=="Unity"||Metric=="Grouping"||Metric=="Density"||Metric=="Homogeneity"))
                			 ||(Context=="Education Level" && (Metric=="Regularity"||Metric=="Density"||Metric=="Symmetry"||Metric=="Simplicity"))
                			 ||(Context=="User Experience" && (Metric=="Regularity"||Metric=="Sequence"||Metric=="Simplicity"))
                			 ||(Context=="Interest" && (Metric=="Density"||Metric=="Symmetry"||Metric=="Sequence")))
                		      {  jxl.Cell cell23 =  sheet.getCell(6, k);
        					     String Interface =  cell23.getContents();
        					             if (Interface.equalsIgnoreCase("InterfaceA"))
        					               { 
        					            	 System.out.println("****************************");
        					            	 if (Metric=="Regularity") 
        					                    { 
        					            		  val01 =  Interface_Metric[0][3];
        					            	      //val01 =  cell01.getContents();
        					                    }
        					            	 
        					            	 if (Metric=="Grouping") 
        					                     { 
        					            	      val01 =  Interface_Metric[0][5];
        					                      }
        					            	 
        					                  if (Metric=="Sequence") 
        					                     { 
        					                       val01 =   Interface_Metric[0][4];
        					                       }
        					                 
        					                  if (Metric=="Simplicity") 
        					                       { 
        					            	           val01 =   Interface_Metric[0][6];
        					                        }
        					                  if (Metric=="Density") 
        					                      { 
        					            	       
        					            	        val01 =   Interface_Metric[0][1];
        					                      } 
        					                  /*if (Metric=="Homogeneity") 
        					                     { 
        					            	    
        					            	       val01 =   Interface_Metric[1][7];
        					                     }
        					                 if (Metric=="Symmetry") 
        					                    { 
        					                       val01 =   Interface_Metric[1][8];
        					                      }*/
        					                 
        					                 if (Metric=="Unity") 
        					                     {
        					                         val01 =   Interface_Metric[0][2];
        					                     }
        					               }
        					            
        					              if (Interface.equalsIgnoreCase("InterfaceB"))
        					               { 
        					            	 if (Metric=="Regularity") 
        					                    { 
        					            		  val01 =  Interface_Metric[1][3];
        					            	      //val01 =  cell01.getContents();
        					                    }
        					                    
        					            	 if (Metric=="Grouping") 
        					                     { 
        					            	      val01 =  Interface_Metric[1][5];
        					                      }
        					                  if (Metric=="Sequence") 
        					                     { 
        					                       val01 =   Interface_Metric[1][4];
        					                       }
        					                  if (Metric=="Simplicity") 
        					                       { 
        					            	           val01 =   Interface_Metric[1][6];
        					                        }
        					                  if (Metric=="Density") 
        					                      { 
        					            	       
        					            	        val01 =   Interface_Metric[1][1];
        					                      } 
        					                  /*if (Metric=="Homogeneity") 
        					                     { 
        					            	    
        					            	       val01 =   Interface_Metric[1][7];
        					                     }
        					                 if (Metric=="Symmetry") 
        					                    { 
        					                       val01 =   Interface_Metric[1][8];
        					                      }*/
        					                 if (Metric=="Unity") 
        					                     {
        					                         val01 =   Interface_Metric[1][2];
        					                     }
        					               }
        					            
        					           
        					            	 
	        					            	 if (Interface.equalsIgnoreCase("InterfaceC"))
	        					               { 
	        					            	 if (Metric=="Regularity") 
	        					                    { 
	        					            		  val01 =  Interface_Metric[2][3];
	        					            	      //val01 =  cell01.getContents();
	        					                    }
	        					                    
	        					            	 if (Metric=="Grouping") 
	        					                     { 
	        					            	      val01 =  Interface_Metric[2][5];
	        					                      }
	        					                  if (Metric=="Sequence") 
	        					                     { 
	        					                       val01 =   Interface_Metric[2][4];
	        					                       }
	        					                  if (Metric=="Simplicity") 
	        					                       { 
	        					            	           val01 =   Interface_Metric[2][6];
	        					                        }
	        					                  if (Metric=="Density") 
	        					                      { 
	        					            	       
	        					            	        val01 =   Interface_Metric[2][1];
	        					                      } 
	        					                  /*if (Metric=="Homogeneity") 
	        					                     { 
	        					            	    
	        					            	       val01 =   Interface_Metric[2][7];
	        					                     }
	        					                 if (Metric=="Symmetry") 
	        					                    { 
	        					                       val01 =   Interface_Metric[2][8];
	        					                      }*/
	        					                 if (Metric=="Unity") 
	        					                     {
	        					                         val01 =   Interface_Metric[2][2];
	        					                     }
	        					               }
        					             
        					             
		        					            	 if (Interface.equalsIgnoreCase("InterfaceD"))
		        					               { 
		        					            	 if (Metric=="Regularity") 
		        					                    { 
		        					            		  val01 =  Interface_Metric[3][3];
		        					            	      //val01 =  cell01.getContents();
		        					                    }
		        					                    
		        					            	 if (Metric=="Grouping") 
		        					                     { 
		        					            	      val01 =  Interface_Metric[3][5];
		        					                      }
		        					                  if (Metric=="Sequence") 
		        					                     { 
		        					                       val01 =   Interface_Metric[3][4];
		        					                       }
		        					                  if (Metric=="Simplicity") 
		        					                       { 
		        					            	           val01 =   Interface_Metric[3][6];
		        					                        }
		        					                  if (Metric=="Density") 
		        					                      { 
		        					            	       
		        					            	        val01 =   Interface_Metric[3][1];
		        					                      } 
		        					                  /*if (Metric=="Homogeneity") 
		        					                     { 
		        					            	    
		        					            	       val01 =   Interface_Metric[3][7];
		        					                     }
		        					                 if (Metric=="Symmetry") 
		        					                    { 
		        					                       val01 =   Interface_Metric[3][8];
		        					                      }*/
		        					                 if (Metric=="Unity") 
		        					                     {
		        					                         val01 =   Interface_Metric[3][2];
		        					                     }
		        					               }
		        					            	
			        					            	 if (Interface.equalsIgnoreCase("InterfaceE"))
			        					               { 
			        					            	 if (Metric=="Regularity") 
			        					                    { 
			        					            		  val01 =  Interface_Metric[4][3];
			        					            	      //val01 =  cell01.getContents();
			        					                    }
			        					                    
			        					            	 if (Metric=="Grouping") 
			        					                     { 
			        					            	      val01 =  Interface_Metric[4][5];
			        					                      }
			        					                  if (Metric=="Sequence") 
			        					                     { 
			        					                       val01 =   Interface_Metric[4][4];
			        					                       }
			        					                  if (Metric=="Simplicity") 
			        					                       { 
			        					            	           val01 =   Interface_Metric[4][6];
			        					                        }
			        					                  if (Metric=="Density") 
			        					                      { 
			        					            	       
			        					            	        val01 =   Interface_Metric[4][1];
			        					                      } 
			        					                  /*if (Metric=="Homogeneity") 
			        					                     { 
			        					            	    
			        					            	       val01 =   Interface_Metric[4][7];
			        					                     }
			        					                 if (Metric=="Symmetry") 
			        					                    { 
			        					                       val01 =   Interface_Metric[4][8];
			        					                      }*/
			        					                 if (Metric=="Unity") 
			        					                     {
			        					                         val01 =   Interface_Metric[4][2];
			        					                     }
			        					               }
			        					            	 
			        					            	 
				        					            	 if (Interface.equalsIgnoreCase("InterfaceF"))
				        					               { 
				        					            	 if (Metric=="Regularity") 
				        					                    { 
				        					            		  val01 =  Interface_Metric[5][3];
				        					            	      //val01 =  cell01.getContents();
				        					                    }
				        					                    
				        					            	 if (Metric=="Grouping") 
				        					                     { 
				        					            	      val01 =  Interface_Metric[5][5];
				        					                      }
				        					                  if (Metric=="Sequence") 
				        					                     { 
				        					                       val01 =   Interface_Metric[5][4];
				        					                       }
				        					                  if (Metric=="Simplicity") 
				        					                       { 
				        					            	           val01 =   Interface_Metric[5][6];
				        					                        }
				        					                  if (Metric=="Density") 
				        					                      { 
				        					            	       
				        					            	        val01 =   Interface_Metric[5][1];
				        					                      } 
				        					                  /*if (Metric=="Homogeneity") 
				        					                     { 
				        					            	    
				        					            	       val01 =   Interface_Metric[5][7];
				        					                     }
				        					                 if (Metric=="Symmetry") 
				        					                    { 
				        					                       val01 =   Interface_Metric[5][8];
				        					                      }*/
				        					                 if (Metric=="Unity") 
				        					                     {
				        					                         val01 =   Interface_Metric[5][2];
				        					                     }
				        					               }
				        					            	
					        					            	 if (Interface.equalsIgnoreCase("InterfaceG"))
					        					               { 
					        					            	 if (Metric=="Regularity") 
					        					                    { 
					        					            		  val01 =  Interface_Metric[6][3];
					        					            	      //val01 =  cell01.getContents();
					        					                    }
					        					                    
					        					            	 if (Metric=="Grouping") 
					        					                     { 
					        					            	      val01 =  Interface_Metric[6][5];
					        					                      }
					        					                  if (Metric=="Sequence") 
					        					                     { 
					        					                       val01 =   Interface_Metric[6][4];
					        					                       }
					        					                  if (Metric=="Simplicity") 
					        					                       { 
					        					            	           val01 =   Interface_Metric[6][6];
					        					                        }
					        					                  if (Metric=="Density") 
					        					                      { 
					        					            	       
					        					            	        val01 =   Interface_Metric[6][1];
					        					                      } 
					        					                  /*if (Metric=="Homogeneity") 
					        					                     { 
					        					            	    
					        					            	       val01 =   Interface_Metric[6][7];
					        					                     }
					        					                     if (Metric=="Symmetry") 
					        					                    { 
					        					                       val01 =   Interface_Metric[6][8];
					        					                      }*/
					        					                 if (Metric=="Unity") 
					        					                     {
					        					                         val01 =   Interface_Metric[6][2];
					        					                     }
					        					               }
        					           if (Val_Metric.equalsIgnoreCase(val01))
        					           {//System.out.println("--------------------------Thats right--------------------------");
                			               Nbr_prob++  ;
                			      // perfect_rule.add(Perfect);
             			       if( (Problem.equalsIgnoreCase("Problem11")))
                         	      {  Nbr_Occ_Solution[0]++; }
                         	if(  (Problem.equalsIgnoreCase("Problem12")))
                   	              {  Nbr_Occ_Solution[1]++; }
                         	if( (Problem.equalsIgnoreCase("Problem21")))
                   	              {   Nbr_Occ_Solution[2]++; }
                         	if((Problem.equalsIgnoreCase("Problem22")))
                   	              {  Nbr_Occ_Solution[3]++; }
                         	if( (Problem.equalsIgnoreCase("Problem31")))
                   	              {   Nbr_Occ_Solution[4]++; }
                         	if( (Problem.equalsIgnoreCase("Problem32")))
                   	              {   Nbr_Occ_Solution[5]++; }
                         	if( (Problem.equalsIgnoreCase("Problem41")))
                   	              {   Nbr_Occ_Solution[6]++; }
                         	if( (Problem.equalsIgnoreCase("Problem42")))
                   	              {   Nbr_Occ_Solution[7]++; }
                         	if((Problem.equalsIgnoreCase("Problem51")))
                   	              {   Nbr_Occ_Solution[8]++; }
                         	if((Problem.equalsIgnoreCase("Problem52")))
                   	              {  Nbr_Occ_Solution[9]++; }
                         	if( (Problem.equalsIgnoreCase("Problem61")))
                   	              {   Nbr_Occ_Solution[10]++; }
                         	if( (Problem.equalsIgnoreCase("Problem62")))
                   	              {   Nbr_Occ_Solution[11]++; }
                         	if( (Problem.equalsIgnoreCase("Problem71")))
                   	              {   Nbr_Occ_Solution[12]++; }
                         	if( (Problem.equalsIgnoreCase("Problem72")))
                   	              {   Nbr_Occ_Solution[13]++; }
                         	if((Problem.equalsIgnoreCase("Problem81")))
                   	              {   Nbr_Occ_Solution[14]++; }
                         	if((Problem.equalsIgnoreCase("Problem82")))
             	              {   Nbr_Occ_Solution[15]++; }  
        					           }
        					          
        					        
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
		 // System.out.println("le problem dans la solution "+i+" repeter "+Nbr_Occ_Solution[i]);
			fit2 =((fit2 + (Nbr_Occ_Solution[i] / Nbr_Occ_Trace[i])))/16; 

		  }
	   double fitness2 = fit2;
	   // pour avoir 2 chiffre apré le virgule 
	   fitness2=(double)((int)( fitness2*100))/100;


     double fit = fitness2;

     f[0] = variable.length;        
     f[1] = fitness2;        
     
     solution.setObjective(0,f[0]);
     solution.setObjective(1,f[1]);
  
		
	}

}

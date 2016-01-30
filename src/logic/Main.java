package logic;

import java.util.Vector;


public class Main 
{ 
    public static void main(String[] args) 
    {
        example1();
        
        //example2();
    }

    //An example of the resolution between two clauses
    public static void example1()
    {
        CNFSubClause c1 = new CNFSubClause();
        CNFSubClause c2 = new CNFSubClause();

        //Constructing the clause (l1 OR l2 OR l3)
        c1.getLiterals().add(new Literal("l1", false));
        c1.getLiterals().add(new Literal("l2", false));
        c1.getLiterals().add(new Literal("l3", false));

        //Constructing the close (m1 OR !l1 OR m3 OR !m4)
        c2.getLiterals().add(new Literal("l3", true));
        c2.getLiterals().add(new Literal("l1", true));
        c2.getLiterals().add(new Literal("m3", false));
        c2.getLiterals().add(new Literal("m4", true));

        System.out.println("This is c1...");
        c1.print();

        System.out.println("This is c2...");
        c2.print();

        System.out.println("This is the result of resolution (c1,c2)");
        //We apply resolution on the two clauses
        Vector<CNFSubClause> newClauses = CNFSubClause.resolution(c1, c2);

        for(int i = 0; i < newClauses.size(); i++)
        {
            newClauses.get(i).print();
        }

        System.out.println("----------------------------------------------------");
        System.out.println();
    }

    //An example of applying resolution to see whether we can infer a literal from our knowledge base
    public static void example2()
    {
        //The clause that are in our knowledge base
        CNFSubClause A1 = new CNFSubClause();
        CNFSubClause A2 = new CNFSubClause();
        CNFSubClause A3 = new CNFSubClause();
        CNFSubClause A4 = new CNFSubClause();

        A1.getLiterals().add(new Literal("P21", true));
        A1.getLiterals().add(new Literal("B11", false));

        System.out.println("This is a sub clause...");
        A1.print();

        A2.getLiterals().add(new Literal("B11", true));
        A2.getLiterals().add(new Literal("P12", false));
        A2.getLiterals().add(new Literal("P21", false));

        System.out.println("This is a sub clause...");
        A2.print();

        A3.getLiterals().add(new Literal("P12", true));
        A3.getLiterals().add(new Literal("B11", false));

        System.out.println("This is a sub clause...");
        A3.print();

        A4.getLiterals().add(new Literal("B11", true));

        System.out.println("This is a sub clause...");
        A4.print();

        CNFClause KB = new CNFClause();

        KB.getSubclauses().add(A1);
        KB.getSubclauses().add(A2);
        KB.getSubclauses().add(A3);
        KB.getSubclauses().add(A4);

        Literal a = new Literal("P12", true);

        System.out.println("----------------------------------------------------");
        System.out.println();

        //Running resolution
        boolean b = PL_Resolution(KB, a);
        a.print();
        System.out.println("is " + b);
    }

    //The resolution algorithm
    public static boolean PL_Resolution(CNFClause KB, Literal a)
    {
        //We create a CNFClause that contains all the clauses of our Knowledge Base
        CNFClause clauses = new CNFClause();
        clauses.getSubclauses().addAll(KB.getSubclauses());
        
        //...plus a clause containing the negation of the literal we want to prove
        Literal aCopy = new Literal(a.getName(), !a.getNeg());
        CNFSubClause aClause = new CNFSubClause();
        aClause.getLiterals().add(aCopy);
        clauses.getSubclauses().add(aClause);

        System.out.println("We want to prove...");
        a.print();

        boolean stop = false;
        int step = 1;
        //We will try resolution till either we reach a contradiction or cannot produce any new clauses
        while(!stop)
        {
            Vector<CNFSubClause> newsubclauses = new Vector<CNFSubClause>();
            Vector<CNFSubClause> subclauses = clauses.getSubclauses();

            System.out.println("Step:" + step);
            step++;
            //For every pair of clauses Ci, Cj...
            for(int i = 0; i < subclauses.size(); i++)
            {
                CNFSubClause Ci = subclauses.get(i);

                for(int j = i+1; j < subclauses.size(); j++)
                {
                    CNFSubClause Cj = subclauses.get(j);

                    //...we try to apply resolution and we collect any new clauses
                    Vector<CNFSubClause> new_subclauses_for_ci_cj = CNFSubClause.resolution(Ci, Cj);

                    //We check the new subclauses...
                    for(int k = 0; k < new_subclauses_for_ci_cj.size(); k++)
                    {
                        CNFSubClause newsubclause = new_subclauses_for_ci_cj.get(k);

                        //...and if an empty subclause has been generated we have reached contradiction; and the literal has been proved
                        if(newsubclause.isEmpty()) 
                        {   
                            System.out.println("----------------------------------");
                            System.out.println("Resolution between");
                            Ci.print();
                            System.out.println("and");
                            Cj.print();
                            System.out.println("produced:");
                            System.out.println("Empty subclause!!!");
                            System.out.println("----------------------------------");
                            return true;
                        }
                        
                        //All clauses produced that don't exist already are added
                        if(!newsubclauses.contains(newsubclause) && !clauses.contains(newsubclause))
                        {
                            System.out.println("----------------------------------");
                            System.out.println("Resolution between");
                            Ci.print();
                            System.out.println("and");
                            Cj.print();
                            System.out.println("produced:");
                            newsubclause.print();
                            newsubclauses.add(newsubclause);
                            System.out.println("----------------------------------");
                        }
                    }                           
                }
            }
            
            boolean newClauseFound = false;

            //Check if any new clauses were produced in this loop
            for(int i = 0; i < newsubclauses.size(); i++)
            {
                if(!clauses.contains(newsubclauses.get(i)))
                {
                    clauses.getSubclauses().addAll(newsubclauses);                    
                    newClauseFound = true;
                }                        
            }

            //If not then Knowledge Base does not logically infer the literal we wanted to prove
            if(!newClauseFound)
            {
                System.out.println("Not found new clauses");
                stop = true;
            }   
        }
        return false;
    }    

}

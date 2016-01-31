/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interprol;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import logic.CNFSubClause;
import logic.Constant;
//import logic.Constant;
import logic.KnowledgeBase;
import logic.Literal;
import logic.Relation;
import logic.Rule;
import logic.Unifier;
import logic.Variable;

/**
 *
 * @author tsipiripo
 */
public class InterProl
{
    
    public static KnowledgeBase kb= new KnowledgeBase();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        
        // TODO code application logic here
        (new window.MainWindow()).setVisible(true);
        Constant c1=new Constant("sally");
         Constant c2=new Constant("erica");
         Relation r1=new Relation("mother_child");
         r1.addArgument(c1);
          r1.addArgument(c2);
          Variable v1=new Variable("X");
          Variable v2=new Variable("Y");
          Relation r2=new Relation("mother_child");
             r2.addArgument(v1);
             r2.addArgument(v2);
             Unifier u=new Unifier();
        
             System.out.println(u.unify(r1, r2));
             System.out.println("-------------------------------------");
             Constant c4=new Constant("sally");
         Constant c5=new Constant("erica");
         Relation r3=new Relation("mother_child");
         r3.addArgument(c4);
         r3.addArgument(c5);
         
             Constant c6=new Constant("sally1");
         Constant c7=new Constant("erica2");
         Relation r4=new Relation("mother_child");
         r4.addArgument(c6);
         r4.addArgument(c7);
         
         
        CNFSubClause s1 = new CNFSubClause();
        CNFSubClause s2 = new CNFSubClause();
        s1.getLiterals().add(new Literal(r3, false));
        s1.getLiterals().add(new Literal(r4, false));
        s2.getLiterals().add(new Literal(r3, true));
        Vector<CNFSubClause> v = CNFSubClause.resolution(s1, s2);
         for(int i = 0; i < v.size(); i++)
        {
            v.get(i).print();
        }
        
    }
    
}

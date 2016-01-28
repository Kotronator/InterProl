/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interprol;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import logic.Constant;
import logic.KnowledgeBase;
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
        
        
    }
    
}

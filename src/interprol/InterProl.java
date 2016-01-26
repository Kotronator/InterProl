/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interprol;

import logic.Fact;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logic.KnowledgeBase;

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
    }
    
}

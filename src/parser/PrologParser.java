/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logic.Constant;
import logic.Relation;
import logic.Rule;
import logic.Term;
import logic.Variable;
import window.MainWindow;

/**
 *
 * @author tsipiripo
 */
public class PrologParser
{
    public static void parseFile(File file)
    {
        try
        {
            RandomAccessFile text = new RandomAccessFile(file, "r");
            String line;
            while((line=text.readLine())!=null)
            {
                StringTokenizer commandTokenizer = new StringTokenizer(line, ".");
                while (commandTokenizer.hasMoreElements())
                {
                    String command = commandTokenizer.nextElement().toString();
                    if(command.trim().equals(""))
                        continue;
                    if(command.contains(":-"))
                    {   //System.out.println("mpainwwww");
                        StringTokenizer ruleTokenizer = new StringTokenizer(command, ":-");
                        String leftPartString = ruleTokenizer.nextElement().toString();
                        Relation leftPart = null;
                        String rightPartString = ruleTokenizer.nextElement().toString();
                       //  System.out.println("leftpartstring = "+leftPartString);
                       // System.out.println("rightpartstring = "+rightPartString);
                        ArrayList<Relation> rightPart= new ArrayList<Relation>();
                        //aristero komati
                        int firstPar = leftPartString.indexOf("(");
                        int lastPar = leftPartString.indexOf(")");
                        String ruleName = leftPartString.substring(0, firstPar).trim();
                        String variablesString = leftPartString.substring(firstPar+1, lastPar).trim();
                       // System.out.println(variablesString);
                        StringTokenizer parametersTokenizer = new StringTokenizer(variablesString, ",");
                        ArrayList<Term> variableList = new ArrayList<Term>();
                        while (parametersTokenizer.hasMoreElements())
                        {
                            String nextElement = parametersTokenizer.nextElement().toString();
                            variableList.add(new Variable(nextElement));
                           // System.out.println(argumentList.get(0));

                        }
                        if(variableList.size()>0)
                        {
                          leftPart = new Relation(ruleName,variableList);
                          // interprol.InterProl.facts.add(relation);
                          
                        }else
                        {
                            JOptionPane.showMessageDialog(null, "Rule with no arguments", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        
                        
                        
                        //////////////////////////////
                        //deksio komati
                        /////////////////////////////
                        String[] parts = rightPartString.split("\\)\\,");
                        int i;
                        for (i = 0; i < parts.length-1; i++) {
                            parts[i]+=")";
                            //System.out.println("part"+ parts[i]);
                            
                        }
                       //System.out.println("part"+ parts[i]);
                        //while(relationsTokenizer.hasMoreTokens()) 
                        for (int j = 0; j < parts.length; j++)
                        {
                            String relation = parts[j];// relationsTokenizer.nextToken();
                            firstPar = relation.indexOf("(");
                            lastPar = relation.indexOf(")");
                            

                            String relationName = relation.substring(0, firstPar).trim();
                            variablesString = relation.substring(firstPar+1, lastPar).trim();
                            StringTokenizer relationVariableTokenizer = new StringTokenizer(variablesString, ",");
                            //System.out.println(variablesString);
                            ArrayList<Term> relationVariableList = new ArrayList<Term>();
                            while (relationVariableTokenizer.hasMoreElements())
                            {
                                
                                String nextElement = relationVariableTokenizer.nextElement().toString();
                               // System.out.println("nextEl:"+nextElement);
                                relationVariableList.add(new Variable(nextElement));
                               // System.out.println(argumentList.get(0));

                            }
                            if(relationVariableList.size()>0)
                            {
                              rightPart.add( new Relation(relationName,relationVariableList));
                              // interprol.InterProl.facts.add(relation);

                            }else
                            {
                                JOptionPane.showMessageDialog(null, "Rule with no arguments", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        if(leftPart != null && !rightPart.isEmpty())
                        {
                            Rule rule = new Rule(leftPart, rightPart);
                            interprol.InterProl.kb.add(rule);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Rule with no arguments", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else
                    {
                        int firstPar = command.indexOf("(");
                        int lastPar = command.indexOf(")");
                        String factName = command.substring(0, firstPar).trim();
                        String facts = command.substring(firstPar+1, lastPar).trim();
                        //System.out.println(facts);
                        StringTokenizer parametersTokenizer = new StringTokenizer(facts, ",");
                        ArrayList<Term> argumentList = new ArrayList<Term>();
                        while (parametersTokenizer.hasMoreElements())
                        {
                            String nextElement = parametersTokenizer.nextElement().toString();
                            char c = nextElement.charAt(0);
                            Character.isUpperCase(c);
                            argumentList.add(new Constant(nextElement));
                           // System.out.println(argumentList.get(0));

                        }
                        if(argumentList.size()>0)
                        {
                          Relation fact= new Relation(factName,argumentList);
                          interprol.InterProl.kb.add(fact);
                        }else
                        {
                            JOptionPane.showMessageDialog(null, "Fact with no arguments", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(PrologParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(PrologParser.class.getName()).log(Level.SEVERE, null, ex);
        }

        MainWindow.printlnToPrompt(interprol.InterProl.kb.toString());
    }
}

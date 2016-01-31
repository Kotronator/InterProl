/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;

/**
 *
 * @author TOSHIBA
 */
public class KnowledgeBase 
{
    ArrayList<Rule> rules;
    //ArrayList<Relation> facts;
    
    public KnowledgeBase()
    {
        rules = new ArrayList<Rule>();
        //facts = new ArrayList<Relation>();
    }
    
    public void addRule(Rule rule)
    {
        rules.add(rule);
    }
    
//    public void addFact(Relation fact)
//    {
//        facts.add(fact);
//    }
    
    public void add(Object o)
    {
        if(o instanceof Relation)
            throw new UnsupportedOperationException("mono rule sto KB ");
        else if(o instanceof Rule)
            rules.add((Rule)o);
        
    }

    @Override
    public String toString() 
    {
        String message = "";
//        for (Relation fact : facts) 
//        {
//            message += fact.toString();
//            message +="\n";
//        }
        
        message += "\n";
        
        for (Rule rule : rules) 
        {
            message += rule.toString();
            message +="\n";
        }
        return message;
    }
    
    
    
    
}

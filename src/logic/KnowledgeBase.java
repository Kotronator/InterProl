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
    ArrayList<Fact> facts;
    
    public KnowledgeBase()
    {
        rules = new ArrayList<Rule>();
        facts = new ArrayList<Fact>();
    }
    
    public void addRule(Rule rule)
    {
        rules.add(rule);
    }
    
    public void addFact(Fact fact)
    {
        facts.add(fact);
    }
    
    public void add(Object o)
    {
        if(o instanceof Fact)
            facts.add((Fact)o);
        else if(o instanceof Rule)
            rules.add((Rule)o);
        
    }

    @Override
    public String toString() 
    {
        String message = "";
        for (Fact fact : facts) 
        {
            message += fact.toString();
        }
        
        message += "\n";
        
        for (Rule rule : rules) 
        {
            message += rule.toString();
        }
        return message;
    }
    
    
    
    
}

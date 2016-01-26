/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.LinkedList;

/**
 *
 * @author tsipiripo
 */
public class Fact
{
    String relation;
    LinkedList<Constant> arguments;
    
    public Fact(String relation)
    {
        this.relation=relation;
        arguments = new LinkedList<Constant>();
    }
    
    public Fact(String relation, LinkedList arguments)
    {
        this(relation);
        this.arguments=arguments;
        
    }
    
    public void addArguments(Constant arg)
    {
        arguments.add(arg);
    }
    
    public String getFactName()
    {
        return relation;
    }
    
    public LinkedList<Constant> getArguments()
    {
        return arguments;
    }
    
    public Constant getArgumentAtIndex(int index)
    {
        return arguments.get(index);
    }

    @Override
    public String toString()
    {
        String str =relation+"(";
        for (int i = 0; i < arguments.size(); i++)
        {
            str+=arguments.get(i);
            if(i!=arguments.size()-1)
            str+=",";
            
        }
        str+=")";
        return str;
  
    }
    
    
    
    
}

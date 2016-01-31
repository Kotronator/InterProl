package logic;

import java.util.ArrayList;

public class Relation extends Term
{
	
	public String nameOfRelation;
	public ArrayList<Term> arguments;
	
	public Relation(String name)
	{
		nameOfRelation = name;
		arguments = new ArrayList<Term>();
	}
	
	public Relation(String name, ArrayList<Term> list)
	{
		nameOfRelation = name;
		arguments = list;
	}
	
	public void addArgument(Term argument)
	{
		arguments.add(argument);
	}

    @Override
    public String toString() {
        String message="";
        message+=nameOfRelation;
        message+="(";
        for (Term argument : arguments) {
            message+=argument.toString()+",";
        }
         message+=")";
         return message;
    }

    @Override
    public String getName() {
        return nameOfRelation;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isConstant() {
        
        for (Term argument : arguments) {
            if(!argument.isConstant())
                return false;
        }
        return true;
    }

    @Override
    public boolean isCompound() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if(! (o instanceof Relation))
            return false;
        Relation rel = (Relation) o;
        if(!rel.nameOfRelation.equals(nameOfRelation))
            return false;
        return arguments.equals(rel.arguments);
    }

    @Override
    public Object clone() 
    {
        ArrayList<Term> copy = new ArrayList<Term>();
        for (Term term : arguments) 
        {
            copy.add((Term)term.clone());
            
        }
        return new Relation(nameOfRelation, copy);
    }
	
	
    

}

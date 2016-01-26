package logic;

import java.util.ArrayList;

public class Relation 
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
	
	
	

}

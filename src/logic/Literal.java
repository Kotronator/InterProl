package logic;

/*
 * Represents a literal; a variable
 */
public class Literal implements Comparable<Literal>
{
    //The name of the literal
    private Relation relation;
    //Whether or not the literal is negated; if negation is true then it is negated
    private boolean negation;

 
    
    public Literal(Relation rel, boolean neg)
    {
        this.relation = rel;
        this.negation = neg;
    }
    
    public void print()
    {
        if(negation)
            System.out.println("NOT_" + relation.toString());
        else
            System.out.println(relation.toString());
    }
        
    public void setRelation(Relation rel)
    {
        this.relation = rel;
    }
    
    public Relation getRelation()
    {
        return this.relation;
    }
    
    public void setNeg(boolean b)
    {
        this.negation = b;
    }
    
    public boolean getNeg()
    {
        return this.negation;
    }
    
    
   //Override
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Literal))
            return false;
        Literal l = (Literal)obj;

        if(!l.relation.isConstant()&&!this.relation.isConstant())
            throw new UnsupportedOperationException("Literal equal not const");
        
        return l.relation.equals(this.relation);
//        if(l.relation().compareTo(this.Name) ==0 && l.getNeg() == this.negation)
//        {
//            return true;
//        }
//        else
//        {
//            return false;
//        }

    }
	
    //@Override
    public int hashCode()
    {
            if(this.negation)
            {
                return relation.nameOfRelation.hashCode() + 1;
            }
            else
            {
                return relation.nameOfRelation.hashCode() + 0;                        
            }
    }
	
    //@Override
    public int compareTo(Literal x)
    {
            int a = 0;
            int b = 0;
            
            if(x.getNeg())
                a = 1;
            
            if(this.getNeg())
                b = 1;
            
            return x.relation.nameOfRelation.compareTo(relation.nameOfRelation)+ a-b;
    }    
}

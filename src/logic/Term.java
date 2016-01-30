package logic;

public abstract class Term 
{
	public abstract String getName();
	
	public abstract boolean isConstant();
        
        public abstract boolean isCompound();

   
        public abstract boolean equals(Object o);
        
        
}

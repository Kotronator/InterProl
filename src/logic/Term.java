package logic;

public abstract class Term 
{
	public abstract String getName();
	
	public abstract boolean isConstant();
        
        public abstract boolean isCompound();

        @Override
        public abstract boolean equals(Object o);
        @Override
        public abstract Object clone();
        
        
        
        
}

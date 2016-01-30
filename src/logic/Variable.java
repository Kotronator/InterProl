package logic;

public class Variable extends Term
{
	String nameOfVariable;
	int id = -1;
	
	public Variable(String name)
	{
		nameOfVariable = name;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return nameOfVariable;
	}

	@Override
	public boolean isConstant() {
		// TODO Auto-generated method stub
		return false;
	}

    @Override
    public String toString() {
        return nameOfVariable;
    }
        
        
    @Override
    public boolean isCompound() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if(! (o instanceof Variable))
            return false;
        Variable var = (Variable) o;
        return nameOfVariable.equals(var.nameOfVariable)&&id==var.id;
    }
    

}

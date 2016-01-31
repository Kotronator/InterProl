package logic;

public class Constant extends Term 
{

	String nameOfConstnat;
	
	public Constant(String name)
	{
		nameOfConstnat = name;
	}
	
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return nameOfConstnat;
	}

	@Override
	public boolean isConstant() {
		// TODO Auto-generated method stub
		return true;
	}

        @Override
        public String toString() {
            return nameOfConstnat;
        }

    @Override
    public boolean isCompound() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if(! (o instanceof Constant))
            return false;
        Constant var = (Constant) o;
        return nameOfConstnat.equals(var.nameOfConstnat);
    }

    @Override
    public Object clone() 
    {
        return new Constant(nameOfConstnat);
    }

        

}

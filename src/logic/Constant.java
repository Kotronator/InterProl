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

        

}

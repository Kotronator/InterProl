package logic;

import java.util.ArrayList;

public class Rule 
{

	private Relation leftPart;
	private ArrayList<Relation> rightPart;
	
	public Rule(Relation leftPart, ArrayList<Relation> rightPart)
	{
		this.leftPart = leftPart;
		this.rightPart = rightPart;
	}
	
	public Relation getLeftPart()
	{
		return leftPart;
	}
	
	public ArrayList<Relation> getRightPart()
	{
		return rightPart;
	}
	
	
	
	
	
}

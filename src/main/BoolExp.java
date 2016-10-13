package main;

public class BoolExp extends Expression {

	public BoolExp(boolean value)
	{
		this.boolValue = value;
	}

	@Override
	public boolean reduciable()
	{
		return false;
	}

	@Override
	public Expression reduce()
	{
		return this;
	}

	@Override
	public String toString()
	{
		return String.valueOf(boolValue);
	}

}

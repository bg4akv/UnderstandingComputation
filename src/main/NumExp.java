package main;

public class NumExp extends Expression {

	public NumExp(int value)
	{
		this.numValue = value;
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
		return String.valueOf(numValue);
	}
}

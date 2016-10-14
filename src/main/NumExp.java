package main;

import java.util.Map;

public class NumExp extends Expression {
	public int value;

	public NumExp(int value)
	{
		this.value = value;
	}

	@Override
	public boolean reduciable()
	{
		return false;
	}

	@Override
	public Expression reduce(Map<String, NumExp> enviroment)
	{
		return this;
	}

	@Override
	public String toString()
	{
		return String.valueOf(value);
	}
}

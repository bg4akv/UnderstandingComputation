package main;

import java.util.Map;


public class VarExp extends Expression {
	public String name;

	public VarExp(String name)
	{
		this.name = name;
	}

	@Override
	public boolean reduciable()
	{
		return true;
	}

	@Override
	public Expression reduce(Map<String, Expression> enviroment)
	{
		return enviroment.get(name);
	}

	@Override
	public String toString()
	{
		return name;
	}

	public Expression evaluate(Map<String, Expression> enviroment)
	{
		return enviroment.get(name);
	}
}

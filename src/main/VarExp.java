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
	public Expression reduce(Map<String, NumExp> enviroment)
	{
		try {
			return new NumExp(enviroment.get(name).value);
		} catch (Exception e) {
			//return new VarExp(name);
			return new NumExp(0);
		}
	}

	@Override
	public String toString()
	{
		return name;
	}
}

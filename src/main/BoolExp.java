package main;

import java.util.Map;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

public class BoolExp extends Expression {
	public boolean value;

	public BoolExp(boolean value)
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

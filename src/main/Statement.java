package main;

import java.util.Map;

public abstract class Statement {
	public Map<String, NumExp> currEnv;

	public void print()
	{
		System.out.println(this);
	}

	abstract public boolean reduciable();
	abstract public Statement reduce(Map<String, NumExp> enviroment);
	abstract public String toString();
}

package main;

import java.util.HashMap;
import java.util.Map;

public abstract class Expression {
	public enum ExpType {  
		ADD, MUL, LESS, NUM, BOOL
	};

	public final Map<String, NumExp> enviroment = new HashMap<String, NumExp>();


	public void print()
	{
		System.out.println(this);
	}

	abstract public boolean reduciable();
	abstract public Expression reduce(Map<String, NumExp> enviroment);
	abstract public String toString();

}

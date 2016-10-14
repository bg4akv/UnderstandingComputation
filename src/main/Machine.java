package main;

import java.util.Map;


public class Machine {
	private Expression exp;
	private Map<String, NumExp> enviroment;

	public Machine(Expression exp, Map<String, NumExp> enviroment)
	{
		this.exp = exp;
		this.enviroment = enviroment;
	}

	public void step()
	{
		exp = exp.reduce(enviroment);
	}

	public void run()
	{
		exp.print();
		while (exp.reduciable()) {
			step();
			exp.print();
		}
	}
}

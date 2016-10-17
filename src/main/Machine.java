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

	public void run()
	{
		exp.print();
		System.out.println(exp.getEnv(enviroment));
		while (exp.reduciable()) {
			exp = exp.reduce(enviroment);
			exp.print();
			System.out.println(exp.getEnv(enviroment));
		}
	}
}

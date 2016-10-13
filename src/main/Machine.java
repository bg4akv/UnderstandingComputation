package main;

public class Machine {
	private Expression exp;

	public Machine(Expression exp)
	{
		this.exp = exp;
	}

	public void step()
	{
		exp = exp.reduce();
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

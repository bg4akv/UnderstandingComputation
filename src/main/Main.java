package main;

public class Main {

	public static void main(String[] args)
	{
		Expression exp = new LessExp(
					new AddExp(
						new AddExp(new NumExp(1), new NumExp(2)),
						new AddExp(new NumExp(4), new NumExp(5))),
					new MulExp(new NumExp(6), new NumExp(7)));
		//exp.print();

		//exp = exp.reduce();

		//exp.print();
		exp = new LessExp(new BoolExp(true), new NumExp(2));
		new Machine(exp).run();
		
		//exp = new BoolExp(false);
		//exp.print();
	}
}

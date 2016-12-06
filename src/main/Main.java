package main;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args)
	{
		Map<String, Expression> enviroment = new HashMap<String, Expression>();
		enviroment.put("a", new NumExp(10));
		enviroment.put("b", new NumExp(20));
		//enviroment.put("c", new NumExp(30));


		Expression exp = new LessExp(
				new AddExp(
					new AddExp(new NumExp(1), new NumExp(2)),
					new AddExp(new NumExp(4), new NumExp(5))),
				new MulExp(new VarExp("a"), new VarExp("b")));
		exp.print();

		Statement statement = new AssignSta(
						new VarExp("x"),
						new AddExp(new VarExp("a"), new VarExp("b")));
		statement.print();

		statement = new IfSta(new LessExp(
					new VarExp("a"), new VarExp("b")),
					new AssignSta(new VarExp("x"), new VarExp("a")),
					new AssignSta(new VarExp("x"), new VarExp("b")));
		//statement.print();
		//System.out.println(statement.getEnv(enviroment));
		//statement = statement.evaluate(enviroment);
		//statement.print();
		//System.out.println(statement.getEnv(enviroment));

		statement = new SequenceSta(
				new AssignSta(new VarExp("e"), new VarExp("b")),
				new AssignSta(new VarExp("f"), new VarExp("a")));
		statement = statement.evaluate(enviroment);
		//statement.print();
		//System.out.println(statement.getEnv(enviroment));

		enviroment.clear();
		enviroment.put("a", new NumExp(1));
		statement = new WhileSta(
					new LessExp(new VarExp("a"), new NumExp(10)),
					new AssignSta(
						new VarExp("a"),
						new AddExp(new VarExp("a"), new NumExp(1))));
		System.out.println(statement.getEnv(enviroment));
		statement = statement.evaluate(enviroment);
		System.out.println(statement.getEnv(enviroment));


	}
}

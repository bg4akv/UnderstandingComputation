package main;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args)
	{
		Expression exp = new LessExp(
					new AddExp(
						new AddExp(new NumExp(1), new NumExp(2)),
						new AddExp(new NumExp(4), new NumExp(5))),
					new MulExp(new VarExp("a"), new VarExp("b")));

		Map<String, NumExp> enviroment = new HashMap<String, NumExp>();
		enviroment.put("a", new NumExp(10));
		enviroment.put("b", new NumExp(20));
		//enviroment.put("c", new NumExp(30));

		new Machine(exp, enviroment).run();
		
		Statement statement = new AssignSta(
						new VarExp("x"),
						new AddExp(new VarExp("a"), new VarExp("b")),
						enviroment);
		statement.print();
		statement.reduce(statement.currEnv);
		statement.print();

	}
}

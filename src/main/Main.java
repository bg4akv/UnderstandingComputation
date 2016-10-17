package main;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args)
	{
		Map<String, NumExp> enviroment = new HashMap<String, NumExp>();
		enviroment.put("a", new NumExp(1));
		enviroment.put("b", new NumExp(20));
		//enviroment.put("c", new NumExp(30));

		
		Expression exp = new AddExp(
				new AddExp(
					new AddExp(new NumExp(1), new NumExp(2)),
					new AddExp(new NumExp(4), new NumExp(5))),
				new MulExp(new VarExp("a"), new VarExp("b")));
		
		
		//new Machine(exp, enviroment).run();



		Statement statement = new AssignSta(
						new VarExp("x"),
						new AddExp(new VarExp("a"), new VarExp("b")));
		
		//statement = new IfSta(new LessExp(
					//new VarExp("a"), new VarExp("b")),
					//new AssignSta(new VarExp("x"), new VarExp("a")),
					//new AssignSta(new VarExp("x"), new VarExp("b")));
		
		
		//statement = new SequenceSta(
			//	new AssignSta(new VarExp("c"), new VarExp("a")),
			//	new AssignSta(new VarExp("d"), new VarExp("c")));
		statement = new WhileSta(
					new LessExp(new VarExp("a"), new NumExp(10)),
					new AssignSta(
						new VarExp("a"),
						new AddExp(new VarExp("a"), new NumExp(1))));

		statement.print();
		System.out.println(statement.getEnv(enviroment));
		while (statement.reduciable()) {
			statement = statement.reduce(enviroment);
			statement.print();
			if (statement instanceof DoNothingSta) {
				//enviroment = statement.newEnv;
				System.out.println(statement.getEnv(enviroment));
			} else {
				System.out.println(statement.getEnv(enviroment));
			}
		}

	}
}

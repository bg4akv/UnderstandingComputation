package main;

import java.util.Map;

public class WhileSta extends Statement {
	private Expression condition;
	private Statement body;


	public WhileSta(Expression condition, Statement body)
	{
		this.condition = condition;
		this.body = body;

	}

	@Override
	public boolean reduciable()
	{
		return true;
	}

	@Override
	public Statement reduce(Map<String, Expression> enviroment)
	{
		return new IfSta(condition, 
				new SequenceSta(body, this),
				new DoNothingSta());
	}

	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return String.format("while (%s) {%s}",
				condition.toString(),
				body.toString());
	}

	@Override
	public Statement evaluate(Map<String, Expression> enviroment)
	{
		if (((BoolExp) condition.evaluate(enviroment)).value) {
			body.evaluate(enviroment);
			return evaluate(enviroment);
		} else {
			return new DoNothingSta();
		}
	}
}

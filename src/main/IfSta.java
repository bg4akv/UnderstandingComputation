package main;

import java.util.Map;

import javax.swing.GroupLayout.Alignment;

public class IfSta extends Statement {
	private Expression condition;
	private Statement consequence;
	private Statement altinative;

	public IfSta(Expression condition, Statement consequence, Statement altinative)
	{
		this.condition = condition;
		this.consequence = consequence;
		this.altinative = altinative;
	}

	@Override
	public boolean reduciable()
	{
		return true;
	}

	@Override
	public Statement reduce(Map<String, Expression> enviroment)
	{
		if (condition.reduciable()) {
			return new IfSta(condition.reduce(enviroment), consequence, altinative);
		} else {
			if (((BoolExp) condition).value) {
				return consequence;
			} else {
				return altinative;
			}
		}
	}

	@Override
	public String toString()
	{
		return String.format("if (%s) {%s} else {%s}",
				condition.toString(),
				consequence.toString(),
				altinative.toString());
	}

	@Override
	public Statement evaluate(Map<String, Expression> enviroment)
	{
		if (((BoolExp) condition.evaluate(enviroment)).value) {
			return consequence.evaluate(enviroment);
		} else {
			return altinative.evaluate(enviroment);
		}
	}
}

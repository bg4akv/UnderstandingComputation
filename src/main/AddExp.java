package main;

import java.util.Map;

public class AddExp extends Expression {
	public Expression leftExp;
	public Expression rightExp;

	public AddExp(Expression leftExp, Expression rightExp)
	{
		this.leftExp = leftExp;
		this.rightExp = rightExp;
	}

	@Override
	public boolean reduciable()
	{
		return true;
	}

	@Override
	public Expression reduce(Map<String, NumExp> enviroment)
	{
		if (leftExp.reduciable()) {
			return new AddExp(leftExp.reduce(enviroment), rightExp);
		} else if (rightExp.reduciable()) {
			return new AddExp(leftExp, rightExp.reduce(enviroment));
		} else {
			return new NumExp(((NumExp) leftExp).value + ((NumExp) rightExp).value);
		}
	}

	@Override
	public String toString()
	{
		return String.format("(+ %s %s)", leftExp.toString(), rightExp.toString());
	}

}

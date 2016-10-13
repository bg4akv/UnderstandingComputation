package main;

public class LessExp extends Expression {

	public LessExp(Expression leftExp, Expression rightExp)
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
	public Expression reduce()
	{
		if (leftExp.reduciable()) {
			return new LessExp(leftExp.reduce(), rightExp);
		} else if (rightExp.reduciable()) {
			return new LessExp(leftExp, rightExp.reduce());
		} else {
			return new BoolExp(leftExp.numValue < rightExp.numValue);
		}
	}

	@Override
	public String toString()
	{
		return String.format("(< %s %s)", leftExp.toString(), rightExp.toString());
	}

}

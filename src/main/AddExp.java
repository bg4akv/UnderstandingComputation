package main;

public class AddExp extends Expression {

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
	public Expression reduce()
	{
		if (leftExp.reduciable()) {
			return new AddExp(leftExp.reduce(), rightExp);
		} else if (rightExp.reduciable()) {
			return new AddExp(leftExp, rightExp.reduce());
		} else {
			return new NumExp(leftExp.numValue + rightExp.numValue);
		}
	}

	@Override
	public String toString()
	{
		return String.format("(+ %s %s)", leftExp.toString(), rightExp.toString());
	}

}

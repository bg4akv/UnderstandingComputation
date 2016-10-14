package main;

import java.util.Map;

public class AssignSta extends Statement {
	public VarExp leftExp;
	public Expression rightExp;
	//public Map<String, NumExp> currEnv;

	public AssignSta(VarExp leftExp, Expression rightExp, Map<String, NumExp> enviroment)
	{
		this.leftExp = leftExp;
		this.rightExp = rightExp;
		this.currEnv = enviroment;
	}

	@Override
	public boolean reduciable()
	{
		return true;
	}

	@Override
	public Statement reduce(Map<String, NumExp> enviroment)
	{
		if (rightExp.reduciable()) {
			return new AssignSta(leftExp, rightExp.reduce(enviroment), enviroment);
		} else {
			return new DoNothingSta(enviroment);
		}
	}

	@Override
	public String toString()
	{
		return String.format("%s = %s", leftExp.name, rightExp.toString());
	}
}

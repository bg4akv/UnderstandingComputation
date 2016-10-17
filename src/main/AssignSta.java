package main;

import java.util.HashMap;
import java.util.Map;

public class AssignSta extends Statement {
	public VarExp varExp;
	public Expression rightExp;

	public AssignSta(VarExp leftExp, Expression rightExp)
	{
		this.varExp = leftExp;
		this.rightExp = rightExp;
	}

	@Override
	public boolean reduciable()
	{
		return true;
	}

	@Override
	public Statement reduce(Map<String, Expression> enviroment)
	{
		if (rightExp.reduciable()) {
			return new AssignSta(varExp, rightExp.reduce(enviroment));
		} else {			
			enviroment.put(varExp.name, rightExp);
			return new DoNothingSta();
		}
	}

	@Override
	public String toString()
	{
		return String.format("%s = %s", varExp.name, rightExp.toString());
	}

	@Override
	public Statement evaluate(Map<String, Expression> enviroment)
	{
		enviroment.put(varExp.name, rightExp.evaluate(enviroment));
		return new DoNothingSta();
	}
}

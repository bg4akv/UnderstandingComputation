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
	public Statement reduce(Map<String, NumExp> enviroment)
	{
		if (rightExp.reduciable()) {
			return new AssignSta(varExp, rightExp.reduce(enviroment));
		} else {
			//Map<String, NumExp> env = new HashMap<String, NumExp>(enviroment);
			//env.put(varExp.name, (NumExp) rightExp);
			//return new DoNothingSta(env);
			
			enviroment.put(varExp.name, (NumExp) rightExp);
			return new DoNothingSta();
			
		}
	}

	@Override
	public String toString()
	{
		return String.format("%s = %s", varExp.name, rightExp.toString());
	}
}

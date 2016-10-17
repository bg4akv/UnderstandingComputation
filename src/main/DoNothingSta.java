package main;

import java.util.Map;

public class DoNothingSta extends Statement {

	public DoNothingSta(Map<String, NumExp> enviroment)
	{
		//newEnv = enviroment;
	}

	public DoNothingSta()
	{
		
	}

	@Override
	public boolean reduciable()
	{
		return false;
	}

	@Override
	public Statement reduce(Map<String, NumExp> enviroment)
	{
		return null;
	}

	@Override
	public String toString()
	{
		return "do-nothing" ;
	}
}

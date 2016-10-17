package main;

import java.util.Map;

public class DoNothingSta extends Statement {

	@Override
	public boolean reduciable()
	{
		return false;
	}

	@Override
	public Statement reduce(Map<String, Expression> enviroment)
	{
		return this;
	}

	@Override
	public String toString()
	{
		return "do-nothing" ;
	}

	@Override
	public Statement evaluate(Map<String, Expression> enviroment)
	{
		return this;
	}
}

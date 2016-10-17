package main;

import java.util.HashMap;
import java.util.Map;

public class SequenceSta extends Statement {
	private Statement firstSta;
	private Statement secondSta;

	public SequenceSta( Statement firstSta,  Statement secondSta)
	{
		this.firstSta = firstSta;
		this.secondSta = secondSta;
	}

	@Override
	public boolean reduciable()
	{
		return true;
	}

	@Override
	public Statement reduce(Map<String, Expression> enviroment)
	{
		if (firstSta instanceof DoNothingSta) {
			return secondSta;
			
		} else {
			return new SequenceSta(firstSta.reduce(enviroment), secondSta);
		}
	}

	@Override
	public String toString()
	{
		return String.format("%s;%s",
				(firstSta != null)? firstSta.toString() : "",
				(secondSta != null)? secondSta.toString() : "");
	}

	@Override
	public Statement evaluate(Map<String, Expression> enviroment)
	{
		firstSta.evaluate(enviroment);
		return secondSta.evaluate(enviroment);
	}

}

package main;

import java.util.Iterator;
import java.util.Map;

public abstract class Expression {
	public enum ExpType {  
		ADD, MUL, LESS, NUM, BOOL
	};

	public void print()
	{
		System.out.println(this);
	}

	abstract public boolean reduciable();
	abstract public Expression reduce(Map<String, Expression> enviroment);
	abstract public Expression evaluate(Map<String, Expression> enviroment);
	abstract public String toString();


	public String getEnv(Map<String, Expression> enviroment)
	{
		if (enviroment == null) {
			return "null";
		}

		String envStr = "";
		for (Iterator<?> iter = enviroment.entrySet().iterator(); iter.hasNext();) {
			Map.Entry entry = (Map.Entry) iter.next();
			if (entry == null) {
				continue;
			}

			if (envStr.length() > 0) {
				envStr += ", ";
			}
	
			Expression exp = (Expression) entry.getValue();
			String value = "";
			if (exp instanceof NumExp) {
				value = String.valueOf(((NumExp) entry.getValue()).value);
			} else if (exp instanceof BoolExp) {
				value = ((BoolExp) entry.getValue()).value? "true" : "false";
			}
			envStr += String.format("%s:%s", (String) entry.getKey(), value);
		}

		return "{" + envStr + "}";
	}
}

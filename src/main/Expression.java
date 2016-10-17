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
	abstract public Expression reduce(Map<String, NumExp> enviroment);
	abstract public String toString();

	public String getEnv(Map<String, NumExp> enviroment)
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
			envStr += String.format("%s:%d", (String) entry.getKey(), ((NumExp) entry.getValue()).value);
		}

		return "{" + envStr + "}";
	}
}

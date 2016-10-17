package main;

import java.util.Iterator;
import java.util.Map;

public abstract class Statement {
	//public Map<String, NumExp> newEnv;

	public void print()
	{
		System.out.println(toString());
	}

	abstract public boolean reduciable();
	abstract public Statement reduce(Map<String, NumExp> enviroment);
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

package main;

public abstract class Expression {
	public enum ExpType {  
		ADD, MUL, LESS, NUM, BOOL
	};

	public Expression leftExp;
	public Expression rightExp;
	public int numValue;
	public boolean boolValue;

	public void print()
	{
		System.out.println(this);
	}

	abstract public boolean reduciable();
	abstract public Expression reduce();
	abstract public String toString();

}

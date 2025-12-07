package ast;

public class AstExpString extends AstExp
{
	public String value;

	public AstExpString(String value, int lineNumber)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.lineNumber = lineNumber;
		this.value = value;
	}

	public void printMe()
	{
		System.out.print("AST NODE STRING( " + value + " )\n");

		AstGraphviz.getInstance().logNode(
			serialNumber,
			"STRING\n(" + value + ")\n");
	}
}

package ast;

public class AstExpInt extends AstExp
{
	public int value;

	public AstExpInt(int value, int lineNumber)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.lineNumber = lineNumber;
		this.value = value;
	}

	public void printMe()
	{
		System.out.print("AST NODE INT( "  + value + " )\n");

		AstGraphviz.getInstance().logNode(
			serialNumber,
			"INT\n(" + value + ")\n");
	}
}

package ast;

public class AstExpNegInt extends AstExp
{
	public int value;

	public AstExpNegInt(int value, int lineNumber)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.lineNumber = lineNumber;
		this.value = -value;
	}

	public void printMe()
	{
		System.out.print("AST NODE NEG INT( "  + value + " )\n");

		AstGraphviz.getInstance().logNode(
			serialNumber,
			"NEG INT\n(" + value + ")\n");
	}
}

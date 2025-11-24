package ast;

public class AstExpInt extends AstExp
{
	public int value;

	public AstExpInt(int value)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.value = value;
	}

	public void printMe()
	{
		System.out.print("AST NODE INT( " + value + " )\n");

		AstGraphviz.getInstance().logNode(
			serialNumber,
			"INT\n(" + value + ")\n");
	}
}

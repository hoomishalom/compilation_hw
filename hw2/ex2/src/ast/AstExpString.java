package ast;

public class AstExpString extends AstExp
{
	public String value;

	public AstExpString(String value)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
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

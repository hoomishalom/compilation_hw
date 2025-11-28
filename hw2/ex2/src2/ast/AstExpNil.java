package ast;

public class AstExpNil extends AstExp
{
	public AstExpNil()
	{
		serialNumber = AstNodeSerialNumber.getFresh();
	}

	public void printMe()
	{
		System.out.print("AST NODE NIL\n");

		AstGraphviz.getInstance().logNode(
			serialNumber,
			"NIL\n");
	}
}

package ast;

public class AstExpNil extends AstExp
{
	public AstExpNil(int lineNumber)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.lineNumber = lineNumber;
	}

	public void printMe()
	{
		System.out.print("AST NODE NIL\n");

		AstGraphviz.getInstance().logNode(
			serialNumber,
			"NIL\n");
	}
}

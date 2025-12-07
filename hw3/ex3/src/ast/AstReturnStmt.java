package ast;

public class AstReturnStmt extends AstStmt
{
	public AstExp exp;

	public AstReturnStmt(AstExp exp, int lineNumber)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.lineNumber = lineNumber;
		this.exp = exp;
	}

	public void printMe()
	{
		System.out.print("AST NODE RETURN STMT\n");
		if (exp != null) exp.printMe();

		AstGraphviz.getInstance().logNode(
			serialNumber,
			"RETURN\n");
		
		if (exp != null) AstGraphviz.getInstance().logEdge(serialNumber, exp.serialNumber);
	}
}

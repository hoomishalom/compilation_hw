package ast;

public class AstExpVar extends AstExp
{
	public AstVar var;

	public AstExpVar(AstVar var)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.var = var;
	}

	public void printMe()
	{
		System.out.print("AST NODE EXP VAR\n");
		if (var != null) var.printMe();

		AstGraphviz.getInstance().logNode(
			serialNumber,
			"EXP\nVAR\n");
		
		if (var != null) AstGraphviz.getInstance().logEdge(serialNumber, var.serialNumber);
	}
}

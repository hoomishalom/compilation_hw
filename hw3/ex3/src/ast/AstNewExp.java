package ast;

public class AstNewExp extends AstExp
{
	public AstType type;
	public AstExp size;

	public AstNewExp(AstType type, AstExp size, int lineNumber)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.lineNumber = lineNumber;
		this.type = type;
		this.size = size;
	}

	public void printMe()
	{
		System.out.print("AST NODE NEW EXP\n");
		if (type != null) type.printMe();
		if (size != null) size.printMe();

		AstGraphviz.getInstance().logNode(
			serialNumber,
			"NEW\nEXP\n");
		
		if (type != null) AstGraphviz.getInstance().logEdge(serialNumber, type.serialNumber);
		if (size != null) AstGraphviz.getInstance().logEdge(serialNumber, size.serialNumber);
	}
}
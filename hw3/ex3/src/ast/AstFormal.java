package ast;

public class AstFormal extends AstNode
{
	public AstType type;
	public String name;

	public AstFormal(AstType type, String name, int lineNumber)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.lineNumber = lineNumber;
		this.type = type;
		this.name = name;
	}

	public void printMe()
	{
		System.out.print("AST NODE FORMAL( " + name + " )\n");
		if (type != null) type.printMe();
		
		AstGraphviz.getInstance().logNode(
			serialNumber,
			"FORMAL\n(" + name + ")\n");
		
		if (type != null) AstGraphviz.getInstance().logEdge(serialNumber, type.serialNumber);
	}
}

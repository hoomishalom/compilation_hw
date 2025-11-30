package ast;

public class AstArrayDecl extends AstDecl
{
	public AstType type;
	public String name;
	
	public AstArrayDecl(AstType type, String name)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.type = type;
		this.name = name;
	}
	
	public void printMe()
	{
		System.out.print("AST NODE ARRAY DECL( " + name + " )\n");
		if (type != null) type.printMe();

		AstGraphviz.getInstance().logNode(
			serialNumber,
			"ARRAY\n(" + name + ")\n");
		
		if (type != null) AstGraphviz.getInstance().logEdge(serialNumber, type.serialNumber);
	}
}

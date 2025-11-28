package ast;

public class AstType extends AstNode
{
	public String typeName;
	
	public AstType(String typeName)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		System.out.print("====================== type -> " + typeName + "\n");
		this.typeName = typeName;
	}

	public void printMe()
	{
		System.out.print("AST NODE TYPE( " + typeName + " )\n");
        AstGraphviz.getInstance().logNode(
            serialNumber,
            "TYPE\n(" + typeName + ")\n");
	}
}

package ast;

public class AstType extends AstNode
{
	public String typeName;
	
	public AstType(String typeName, int lineNumber)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.lineNumber = lineNumber;
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

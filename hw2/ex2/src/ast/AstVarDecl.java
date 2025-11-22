package ast;

public class AstVarDecl extends AstStmt
{
	public AstType type;
	public String name;
	public AstExp initialValue;
	
	public AstVarDecl(AstType type, String name, AstExp initialValue)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		if (initialValue != null)
			System.out.print("====================== varDecl -> type ID := exp;\n");
		else
			System.out.print("====================== varDecl -> type ID;\n");
			
		this.type = type;
		this.name = name;
		this.initialValue = initialValue;
	}
	
	public void printMe()
	{
		System.out.print("AST NODE VAR DECL( " + name + " )\n");
		if (type != null) type.printMe();
		if (initialValue != null) initialValue.printMe();
	}
}

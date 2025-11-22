package ast;

public class AstReturnStmt extends AstStmt
{
	public AstExp exp;
	
	public AstReturnStmt(AstExp exp)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		if (exp != null)
			System.out.print("====================== return -> return exp;\n");
		else
			System.out.print("====================== return -> return;\n");
			
		this.exp = exp;
	}
	
	public void printMe()
	{
		System.out.print("AST NODE RETURN\n");
		if (exp != null) exp.printMe();
	}
}

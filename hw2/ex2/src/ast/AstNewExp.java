package ast;

public class AstNewExp extends AstExp
{
	public AstType type;
	public AstExp sizeExp;
	
	public AstNewExp(AstType type, AstExp sizeExp)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		if (sizeExp != null)
			System.out.print("====================== new -> new type [ exp ]\n");
		else
			System.out.print("====================== new -> new type ( )\n");
			
		this.type = type;
		this.sizeExp = sizeExp;
	}
	
	public void printMe()
	{
		System.out.print("AST NODE NEW\n");
		if (type != null) type.printMe();
		if (sizeExp != null) sizeExp.printMe();
	}
}

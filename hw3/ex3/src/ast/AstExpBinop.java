package ast;

public class AstExpBinop extends AstExp
{
	public enum OP { PLUS, MINUS, TIMES, DIVIDE, LT, GT, EQ }
	
	public AstExp left;
	public AstExp right;
	public OP op;

	public AstExpBinop(AstExp left, AstExp right, OP op)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.left = left;
		this.right = right;
		this.op = op;
	}

	public void printMe()
	{
		System.out.print("AST NODE BINOP EXP\n");
		if (left != null) left.printMe();
		if (right != null) right.printMe();

		AstGraphviz.getInstance().logNode(
			serialNumber,
			"BINOP\n(" + op + ")\n");
		
		if (left != null) AstGraphviz.getInstance().logEdge(serialNumber, left.serialNumber);
		if (right != null) AstGraphviz.getInstance().logEdge(serialNumber, right.serialNumber);
	}
}

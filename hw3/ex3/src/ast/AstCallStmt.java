package ast;

public class AstCallStmt extends AstStmt
{
	public AstCall call;

	public AstCallStmt(AstCall call, int lineNumber)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.lineNumber = lineNumber;
		this.call = call;
	}

	public void printMe()
	{
		System.out.print("AST NODE CALL STMT\n");
		if (call != null) call.printMe();

		AstGraphviz.getInstance().logNode(
			serialNumber,
			"CALL\nSTMT\n");
		
		if (call != null) AstGraphviz.getInstance().logEdge(serialNumber, call.serialNumber);
	}
}

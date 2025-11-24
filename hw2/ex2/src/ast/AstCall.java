package ast;
import java.util.List;
import java.util.ArrayList;

public class AstCall extends AstExp
{
	public AstVar var;
	public String funcName;
	public List<AstExp> args;

	public AstCall(AstVar var, String funcName, List<AstExp> args)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.var = var;
		this.funcName = funcName;
		this.args = args;
	}

	public void printMe()
	{
		System.out.print("AST NODE CALL( " + funcName + " )\n");
		if (var != null) var.printMe();
		for (AstExp e : args)
		{
			e.printMe();
		}

		AstGraphviz.getInstance().logNode(
			serialNumber,
			"CALL\n(" + funcName + ")\n");
		
		if (var != null) AstGraphviz.getInstance().logEdge(serialNumber, var.serialNumber);
		for (AstExp e : args)
		{
			AstGraphviz.getInstance().logEdge(serialNumber, e.serialNumber);
		}
	}
}

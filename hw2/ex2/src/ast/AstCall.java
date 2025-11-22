package ast;
import java.util.List;

public class AstCall extends AstExp
{
	public AstExp caller;
	public String methodName;
	public List<AstExp> args;
	
	public AstCall(AstExp caller, String methodName, List<AstExp> args)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		if (caller != null)
			System.out.print("====================== call -> exp . ID ( args )\n");
		else
			System.out.print("====================== call -> ID ( args )\n");
			
		this.caller = caller;
		this.methodName = methodName;
		this.args = args;
	}
	
	public void printMe()
	{
		System.out.print("AST NODE CALL( " + methodName + " )\n");
		if (caller != null) caller.printMe();
		if (args != null) {
			for (AstExp e : args) {
				e.printMe();
			}
		}
	}
}

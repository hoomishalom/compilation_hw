package ast;
import java.util.List;
import java.util.ArrayList;

public class AstFuncDecl extends AstDecl
{
	public AstType returnType;
	public String name;
	public List<AstFormal> formals;
	public AstStmtList body;

	public AstFuncDecl(AstType returnType, String name, List<AstFormal> formals, AstStmtList body)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.returnType = returnType;
		this.name = name;
		this.formals = formals;
		this.body = body;
	}

	public void printMe()
	{
		System.out.print("AST NODE FUNC DECL( " + name + " )\n");
		if (returnType != null) returnType.printMe();
		for (AstFormal f : formals)
		{
			f.printMe();
		}
		if (body != null) body.printMe();

		AstGraphviz.getInstance().logNode(
			serialNumber,
			"FUNC\n(" + name + ")\n");
		
		if (returnType != null) AstGraphviz.getInstance().logEdge(serialNumber, returnType.serialNumber);
		for (AstFormal f : formals)
		{
			AstGraphviz.getInstance().logEdge(serialNumber, f.serialNumber);
		}
		if (body != null) AstGraphviz.getInstance().logEdge(serialNumber, body.serialNumber);
	}
}

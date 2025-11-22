package ast;
import java.util.List;

public class AstFuncDecl extends AstDecl
{
	public AstType returnType;
	public String name;
	public List<AstFormal> formals;
	public AstStmtList body;
	
	public AstFuncDecl(AstType returnType, String name, List<AstFormal> formals, AstStmtList body)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		System.out.print("====================== funcDecl -> type ID ( formals ) { body }\n");
		this.returnType = returnType;
		this.name = name;
		this.formals = formals;
		this.body = body;
	}
	
	public void printMe()
	{
		System.out.print("AST NODE FUNC DECL( " + name + " )\n");
		if (returnType != null) returnType.printMe();
		if (formals != null) {
			for (AstFormal f : formals) {
				f.printMe();
			}
		}
		if (body != null) body.printMe();
	}
}

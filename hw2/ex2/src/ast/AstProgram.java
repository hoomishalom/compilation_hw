package ast;
import java.util.List;

public class AstProgram extends AstNode
{
	public List<AstDecl> declarations;
	
	public AstProgram()
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		System.out.print("====================== program -> decls\n");
		declarations = new java.util.ArrayList<>();
	}

	public void add(AstDecl decl)
	{
		this.declarations.add(decl);
	}
	
	@Override
	public void printMe()
	{
		System.out.print("AST NODE PROGRAM\n");
		if (declarations != null) {
			for (AstDecl d : declarations) {
				d.printMe();
			}
		}
	}
}

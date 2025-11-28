package ast;
import java.util.List;

public class AstProgram extends AstNode
{
	public List<AstDecl> declarations;
	
	public AstProgram(List<AstDecl> declarations)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		System.out.print("====================== program -> decls\n");
		this.declarations = declarations;
	}

	public void add(AstDecl decl)
	{
		this.declarations.add(decl);
	}
	
	@Override
    public void printMe()
    {
        System.out.print("AST NODE PROGRAM\n");

        AstGraphviz.getInstance().logNode(
            serialNumber,
            "PROGRAM\n");

        if (declarations != null) {
            for (AstDecl d : declarations) {
                d.printMe();
                
                AstGraphviz.getInstance().logEdge(serialNumber, d.serialNumber);
            }
        }
    }
}

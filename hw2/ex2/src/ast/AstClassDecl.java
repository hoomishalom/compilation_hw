package ast;
import java.util.List;
import java.util.ArrayList;

public class AstClassDecl extends AstDecl
{
	public String name;
	public String superName;
	public List<AstDecl> fields;

	public AstClassDecl(String name, String superName, List<AstDecl> fields)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.name = name;
		this.superName = superName;
		this.fields = fields;
	}

	public void printMe()
	{
		System.out.print("AST NODE CLASS DECL( " + name + " )\n");
		for (AstDecl d : fields)
		{
			d.printMe();
		}

		AstGraphviz.getInstance().logNode(
			serialNumber,
			"CLASS\n(" + name + ")\n");
		
		for (AstDecl d : fields)
		{
			AstGraphviz.getInstance().logEdge(serialNumber, d.serialNumber);
		}
	}
}

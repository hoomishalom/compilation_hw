package ast;
import java.util.List;

public class AstClassDecl extends AstDecl
{
	public String name;
	public String superName;
	public List<AstDecl> members;
	
	public AstClassDecl(String name, String superName, List<AstDecl> members)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		if (superName != null)
			System.out.print("====================== classDecl -> class ID extends ID { members }\n");
		else
			System.out.print("====================== classDecl -> class ID { members }\n");
			
		this.name = name;
		this.superName = superName;
		this.members = members;
	}
	
	public void printMe()
	{
		System.out.print("AST NODE CLASS DECL( " + name + " )\n");
		if (superName != null) System.out.print("EXTENDS " + superName + "\n");
		if (members != null) {
			for (AstDecl d : members) {
				d.printMe();
			}
		}
	}
}

package ast;
import java.util.List;

import symboltable.SymbolTable;
import types.TypeClass;

public class AstClassDecl extends AstDecl
{
	public String name;
	public String superName;
	public List<AstDecl> fields;

	public AstClassDecl(String name, String superName, List<AstDecl> fields, int lineNumber)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.lineNumber = lineNumber;
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

	public Type semantMe()
	{	
		/*************************/
		/* [1] Begin Class Scope */
		/*************************/
		SymbolTable.getInstance().beginScope();

		/***************************/
		/* [2] Semant Data Members */
		/***************************/
		TypeClass t = new TypeClass(null,name, dataMembers.semantMe());

		/*****************/
		/* [3] End Scope */
		/*****************/
		SymbolTable.getInstance().endScope();

		/************************************************/
		/* [4] Enter the Class Type to the Symbol Table */
		/************************************************/
		SymbolTable.getInstance().enter(name,t);

		/*********************************************************/
		/* [5] Return value is irrelevant for class declarations */
		/*********************************************************/
		return null;		
	}
}

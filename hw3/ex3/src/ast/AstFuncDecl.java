package ast;
import java.util.List;

import symboltable.SymbolTable;
import types.TypeFunction;
import types.TypeList;

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

	public Type semantMe()
	{
		Type t;
		Type returnType = null;
		TypeList type_list = null;

		/*******************/
		/* [0] return type */
		/*******************/
		returnType = SymbolTable.getInstance().find(returnTypeName);
		if (returnType == null)
		{
			System.out.format(">> ERROR [%d:%d] non existing return type %s\n",6,6,returnType);				
		}
	
		/****************************/
		/* [1] Begin Function Scope */
		/****************************/
		SymbolTable.getInstance().beginScope();

		/***************************/
		/* [2] Semant Input Params */
		/***************************/
		for (AstTypeNameList it = params; it  != null; it = it.tail)
		{
			t = SymbolTable.getInstance().find(it.head.type);
			if (t == null)
			{
				System.out.format(">> ERROR [%d:%d] non existing type %s\n",2,2,it.head.type);				
			}
			else
			{
				type_list = new TypeList(t,type_list);
				SymbolTable.getInstance().enter(it.head.name,t);
			}
		}

		/*******************/
		/* [3] Semant Body */
		/*******************/
		body.semantMe();

		/*****************/
		/* [4] End Scope */
		/*****************/
		SymbolTable.getInstance().endScope();

		/***************************************************/
		/* [5] Enter the Function Type to the Symbol Table */
		/***************************************************/
		SymbolTable.getInstance().enter(name,new TypeFunction(returnType,name,type_list));

		/************************************************************/
		/* [6] Return value is irrelevant for function declarations */
		/************************************************************/
		return null;		
	}
}

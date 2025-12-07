package ast;

import symboltable.SymbolTable;

public class AstVarDecl extends AstDecl {
    public AstType type;
    public String name;
    public AstExp initialValue;

    public AstVarDecl(AstType type, String name, AstExp initialValue, int lineNumber) {
        serialNumber = AstNodeSerialNumber.getFresh();
        this.lineNumber = lineNumber;
        if (initialValue != null)
            System.out.print("====================== varDecl -> type ID := exp;\n");
        else
            System.out.print("====================== varDecl -> type ID;\n");

        this.type = type;
        this.name = name;
        this.initialValue = initialValue;
    }

    public void printMe() {
        System.out.print("AST NODE VAR DECL( " + name + " )\n");
        if (type != null)
            type.printMe();
        if (initialValue != null)
            initialValue.printMe();

        AstGraphviz.getInstance().logNode(
                serialNumber,
                "VAR DECL\n(" + name + ")\n");

        if (type != null) {
            AstGraphviz.getInstance().logEdge(serialNumber, type.serialNumber);
        }
        if (initialValue != null) {
            AstGraphviz.getInstance().logEdge(serialNumber, initialValue.serialNumber);
        }
    }
    public Type semantMe()
	{
		Type t;
	
		/****************************/
		/* [1] Check If Type exists */
		/****************************/
		t = SymbolTable.getInstance().find(type);
		if (t == null)
		{
			System.out.format(">> ERROR [%d:%d] non existing type %s\n",2,2,type);
			System.exit(0);
		}
		
		/**************************************/
		/* [2] Check That Name does NOT exist */
		/**************************************/
		if (SymbolTable.getInstance().find(name) != null)
		{
			System.out.format(">> ERROR [%d:%d] variable %s already exists in scope\n",2,2,name);				
		}

		/************************************************/
		/* [3] Enter the Identifier to the Symbol Table */
		/************************************************/
		SymbolTable.getInstance().enter(name,t);

		/************************************************************/
		/* [4] Return value is irrelevant for variable declarations */
		/************************************************************/
		return null;		
	}
}

//AstTypeNameList
public TypeList semantMe()
	{
		if (tail == null)
		{
			return new TypeList(
				head.semantMe(),
				null);
		}
		else
		{
			return new TypeList(
				head.semantMe(),
				tail.semantMe());
		}
	}



//AstTypeName
public Type semantMe()
	{
		Type t = SymbolTable.getInstance().find(type);
		if (t == null)
		{
			/**************************/
			/* ERROR: undeclared type */
			/**************************/
			System.exit(0);
			return null;
		}
		else
		{
			/*******************************************************/
			/* Enter var with name=name and type=t to symbol table */
			/*******************************************************/
			SymbolTable.getInstance().enter(name,t);
		}

		/****************************/
		/* return (existing) type t */
		/****************************/
		return t;
}

//AstStmtDecVar
public Type semantMe()
	{
		return var.semantMe();
	}

    //AstExpVarSimple
    public Type semantMe()
	{
		return SymbolTable.getInstance().find(name);
	}


    //AstExpVarField

    public Type semantMe()
	{
		Type t = null;
		TypeClass tc = null;
		
		/******************************/
		/* [1] Recursively semant var */
		/******************************/
		if (var != null) t = var.semantMe();
		
		/*********************************/
		/* [2] Make sure type is a class */
		/*********************************/
		if (t.isClass() == false)
		{
			System.out.format(">> ERROR [%d:%d] access %s field of a non-class variable\n",6,6,fieldName);
			System.exit(0);
		}
		else
		{
			tc = (TypeClass) t;
		}
		
		/************************************/
		/* [3] Look for fiedlName inside tc */
		/************************************/
		for (TypeList it = tc.dataMembers; it != null; it=it.tail)
		{
			if (it.head.name == fieldName)
			{
				return it.head;
			}
		}
		
		/*********************************************/
		/* [4] fieldName does not exist in class var */
		/*********************************************/
		System.out.format(">> ERROR [%d:%d] field %s does not exist in class\n",6,6,fieldName);							
		System.exit(0);
		return null;
	}



    //AstDecList
    public Type semantMe()
	{
		/*************************************/
		/* RECURSIVELY PRINT HEAD + TAIL ... */
		/*************************************/
		if (head != null) head.semantMe();
		if (tail != null) tail.semantMe();

		return null;
	}
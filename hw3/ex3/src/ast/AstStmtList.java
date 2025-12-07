package ast;

import java.util.ArrayList;
import java.util.List;

public class AstStmtList extends AstNode
{
	public List<AstStmt> statements;

	public AstStmtList(int lineNumber)
	{
		serialNumber = AstNodeSerialNumber.getFresh();
		this.lineNumber = lineNumber;
		statements = new ArrayList<>();
	}

	public void add(AstStmt stmt)
	{
		statements.add(stmt);
	}

	public void printMe()
	{
		System.out.print("AST NODE STMT LIST\n");
		for (AstStmt s : statements)
		{
			if (s != null) s.printMe();
		}

		AstGraphviz.getInstance().logNode(
			serialNumber,
			"STMT\nLIST\n");
		
		for (AstStmt s : statements)
		{
			if (s != null) AstGraphviz.getInstance().logEdge(serialNumber, s.serialNumber);
		}
	}
}

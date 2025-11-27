import java.io.*;
import java.io.PrintWriter;
import java_cup.runtime.Symbol;
import ast.*;

public class Main
{
	static public void main(String argv[])
	{
		Lexer l;
		Parser p;
		Symbol s;
		AstNode ast;
		FileReader fileReader;
		PrintWriter fileWriter;
		String inputFileName = argv[0];
		String outputFileName = argv[1];
		
		try
		{
			/********************************/
			/* [1] Initialize a file reader */
			/********************************/
			fileReader = new FileReader(inputFileName);

			/********************************/
			/* [2] Initialize a file writer */
			/********************************/
			fileWriter = new PrintWriter(outputFileName);
			
			/******************************/
			/* [3] Initialize a new lexer */
			/******************************/
			l = new Lexer(fileReader);
			
			/*******************************/
			/* [4] Initialize a new parser */
			/*******************************/

			/* [INTERCEPTION] Create a wrapper that logs tokens */
			java_cup.runtime.Scanner interceptingLexer = new java_cup.runtime.Scanner() {
				@Override
				public java_cup.runtime.Symbol next_token() throws Exception {
					// 1. Get the token from the real lexer
					java_cup.runtime.Symbol symbol = l.next_token();
					
					// 2. INTERCEPT: Print/Inspect the token here
					// 'sym' is the integer ID, 'value' is the actual string/object
					
					
					// 3. Pass it along to the parser
					return symbol;
				}
			};

			/* [5] Initialize the Parser with the INTERCEPTOR, not the original lexer */
			p = new Parser(interceptingLexer);



			/***********************************/
			/* [5] 3 ... 2 ... 1 ... Parse !!! */
			/***********************************/
			try {
				ast = (AstNode) p.parse().value;
				
				/*************************/
				/* [6] Print the AST ... */
				/*************************/
				if (ast != null) ast.printMe();
				
				/*************************/
				/* [7] Write OK          */
				/*************************/
				fileWriter.print("OK");
			} catch (Exception e) {
				fileWriter.print(e.getMessage());
			} finally {
				fileWriter.close();
			}
			
			/*************************************/
			/* [8] Finalize AST GRAPHIZ DOT file */
			/*************************************/
			AstGraphviz.getInstance().finalizeFile();
    	}
			     
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}



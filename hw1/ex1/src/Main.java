import java.io.*;
import java.io.PrintWriter;

import java.util.Map;

import java_cup.runtime.Symbol;
   
public class Main
{
	static private String FormatString(Symbol s, Lexer l, Map<Integer, String> tokenMap) {
		StringBuilder sb = new StringBuilder();

		sb.append(tokenMap.get(s.sym));
		if (s.value != null) {
			sb.append("(");
			sb.append(s.value);
			sb.append(")");
		}
		sb.append("[");
		sb.append(l.getLine());
		sb.append(",");
		sb.append(l.getTokenStartPosition());
		sb.append("]");

		return sb.toString();
	}

	static public void main(String argv[])
	{
		Lexer l;
		Symbol s;
		FileReader fileReader;
		PrintWriter fileWriter = null;
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

			/***********************/
			/* [4] Read next token */
			/***********************/
			s = l.next_token();

			/********************************/
			/* [5] Main reading tokens loop */
			/********************************/
			while (s.sym != TokenNames.EOF)
			{	

				if (s.sym == TokenNames.NO_MATCH) {
					fileWriter.close();
					fileWriter = new PrintWriter(outputFileName);
					fileWriter.print("ERROR");
					break;
				}

				/************************/
				/* [6] Print to console */
				/************************/
				Map<Integer, String> tokenMap = TokenNames.getTokenNameMap();

				/*********************/
				/* [7] Print to file */
				/*********************/
				fileWriter.print(FormatString(s, l, tokenMap));

				/***********************/
				/* [8] Read next token */
				/***********************/
				s = l.next_token();
				if (s.sym != TokenNames.EOF)
				{
					fileWriter.print("\n");
				} 
				
			}
			
			/******************************/
			/* [9] Close lexer input file */
			/******************************/
			l.yyclose();

			/**************************/
			/* [10] Close output file */
			/**************************/
			fileWriter.close();
    	}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}



/***************************/
/* FILE NAME: LEX_FILE.lex */
/***************************/

/*************/
/* USER CODE */
/*************/

import java_cup.runtime.*;

/******************************/
/* DOLLAR DOLLAR - DON'T TOUCH! */
/******************************/

%%

/************************************/
/* OPTIONS AND DECLARATIONS SECTION */
/************************************/
   
/*****************************************************/ 
/* Lexer is the name of the class JFlex will create. */
/* The code will be written to the file Lexer.java.  */
/*****************************************************/ 
%class Lexer

/********************************************************************/
/* The current line number can be accessed with the variable yyline */
/* and the current column number with the variable yycolumn.        */
/********************************************************************/
%line
%column

/*******************************************************************************/
/* Note that this has to be the EXACT same name of the class the CUP generates */
/*******************************************************************************/
%cupsym TokenNames

/******************************************************************/
/* CUP compatibility mode interfaces with a CUP generated parser. */
/******************************************************************/
%cup

/****************/
/* DECLARATIONS */
/****************/
/*****************************************************************************/   
/* Code between %{ and %}, both of which must be at the beginning of a line, */
/* will be copied verbatim (letter to letter) into the Lexer class code.     */
/* Here you declare member variables and functions that are used inside the  */
/* scanner actions.                                                          */  
/*****************************************************************************/   
%{
	/*********************************************************************************/
	/* Create a new java_cup.runtime.Symbol with information about the current token */
	/*********************************************************************************/
	private Symbol symbol(int type)               {return new Symbol(type, yyline, yycolumn);}
	private Symbol symbol(int type, Object value) {return new Symbol(type, yyline, yycolumn, value);}

	/*******************************************/
	/* Enable line number extraction from main */
	/*******************************************/
	public int getLine() { return yyline + 1; } 

	/**********************************************/
	/* Enable token position extraction from main */
	/**********************************************/
	public int getTokenStartPosition() { return yycolumn + 1; } 
%}

/***********************/
/* MACRO DECLARATIONS */
/***********************/


LineTerminator	= \r|\n|\r\n
WhiteSpaceChars = [ \f\t]
WhiteSpace		= {LineTerminator} | {WhiteSpaceChars}
INTEGER			= 0 | [1-9][0-9]*
WRONG_INTEGER = 0[0-9]+
STRING 		    = \"[a-zA-Z]*\"
ID 					= [a-zA-Z][a-zA-Z0-9]*

Letters         = [a-zA-Z]
Digits          = [0-9]
CommentValue1  = ({Letters}|{Digits}|{WhiteSpaceChars}|[\(\)\[\]\{\}\?\!\+\-\*\/\.\;])*

NotStar     = {Letters}|{Digits}|{WhiteSpace}|[\(\)\[\]\{\}\?\!\+\-\/\.\;]
StarSeq     = \*+
NotSlash    = {Letters}|{Digits}|{WhiteSpace}|[\(\)\[\]\{\}\?\!\+\-\.\;]
CommentValue2 = ({NotStar}|{StarSeq}{NotSlash})* 

CommentType1		= \/\/{CommentValue1}{LineTerminator}
CommentType2       = \/\*{CommentValue2}\*+\/
WrongCommentType2 = \/\* 


/******************************/
/* DOLLAR DOLLAR - DON'T TOUCH! */
/******************************/

%%

/************************************************************/
/* LEXER matches regular expressions to actions (Java code) */
/************************************************************/

/**************************************************************/
/* YYINITIAL is the state at which the lexer begins scanning. */
/* So these regular expressions will only be matched if the   */
/* scanner is in the start state YYINITIAL.                   */
/**************************************************************/

<YYINITIAL> {
{CommentType1}     {}
{CommentType2}     {}

"+"					{ return symbol(TokenNames.PLUS, yyline, yycolumn);}
"-"					{ return symbol(TokenNames.MINUS, yyline, yycolumn);}
"*"					{ return symbol(TokenNames.TIMES, yyline, yycolumn);}
"/"					{ return symbol(TokenNames.DIVIDE, yyline, yycolumn);}
"("					{ return symbol(TokenNames.LPAREN, yyline, yycolumn);}
")"					{ return symbol(TokenNames.RPAREN, yyline, yycolumn);}
"["					{ return symbol(TokenNames.LBRACK, yyline, yycolumn);}
"]"					{ return symbol(TokenNames.RBRACK, yyline, yycolumn);}
"{"					{ return symbol(TokenNames.LBRACE, yyline, yycolumn);}
"}"					{ return symbol(TokenNames.RBRACE, yyline, yycolumn);}
","					{ return symbol(TokenNames.COMMA, yyline, yycolumn);}
"."					{ return symbol(TokenNames.DOT, yyline, yycolumn);}
";"					{ return symbol(TokenNames.SEMICOLON, yyline, yycolumn);}

"int"				{ return symbol(TokenNames.TYPE_INT, yyline, yycolumn);}
"string"			{ return symbol(TokenNames.TYPE_STRING, yyline, yycolumn);}
"void"				{ return symbol(TokenNames.TYPE_VOID, yyline, yycolumn);}

":="				{ return symbol(TokenNames.ASSIGN, yyline, yycolumn);}
"="					{ return symbol(TokenNames.EQ, yyline, yycolumn);}
"<"					{ return symbol(TokenNames.LT, yyline, yycolumn);}
">"					{ return symbol(TokenNames.GT, yyline, yycolumn);}

"array"				{return symbol(TokenNames.ARRAY, yyline, yycolumn);}
"class"				{return symbol(TokenNames.CLASS, yyline, yycolumn);}
"return"			{return symbol(TokenNames.RETURN, yyline, yycolumn);}
"while"				{return symbol(TokenNames.WHILE, yyline, yycolumn);}
"if"				{return symbol(TokenNames.IF, yyline, yycolumn);}
"else"				{return symbol(TokenNames.ELSE, yyline, yycolumn);}
"new"				{return symbol(TokenNames.NEW, yyline, yycolumn);}
"extends"			{return symbol(TokenNames.EXTENDS, yyline, yycolumn);}
"nil"				{return symbol(TokenNames.NIL, yyline, yycolumn);}

{STRING} 		    { return symbol(TokenNames.STRING, yyline, yycolumn, yytext());}
{INTEGER}			{ 
    try {
        int value = Integer.parseInt(yytext());
        if (value > 32767) {
            throw new RuntimeException("ERROR");
        }
        return symbol(TokenNames.INT, yyline, yycolumn, Integer.valueOf(yytext()));
    } catch (NumberFormatException e) {
        throw new RuntimeException("ERROR");
    }
                    }
{ID}				{ return symbol(TokenNames.ID, yyline, yycolumn, yytext());}
{WhiteSpace}		{ /* just skip what was found, do nothing */ }
<<EOF>>				{ return symbol(TokenNames.EOF, yyline, yycolumn);}
{WRONG_INTEGER}		{ throw new RuntimeException("ERROR");}
{WrongCommentType2} { throw new RuntimeException("ERROR");}
.					{ throw new RuntimeException("ERROR");} /* . catches everything, NO_MATCH catch */
}

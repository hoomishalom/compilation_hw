import java.util.Map;
import java.util.HashMap;

public interface TokenNames {
  /* terminals */
  public static final int EOF = 0;
  public static final int PLUS = 1;
  public static final int MINUS = 2;
  public static final int TIMES = 3;
  public static final int DIVIDE = 4;
  public static final int LPAREN = 5;
  public static final int RPAREN = 6;
  public static final int LBRACK = 7;
  public static final int RBRACK = 8;
  public static final int LBRACE = 9;
  public static final int RBRACE = 10;
  public static final int COMMA = 11;
  public static final int DOT = 12;
  public static final int SEMICOLON = 13;
  public static final int TYPE_INT = 14;
  public static final int TYPE_STRING = 15;
  public static final int TYPE_VOID = 16;
  public static final int ASSIGN = 17;
  public static final int EQ = 18;
  public static final int LT = 19;
  public static final int GT = 20;
  public static final int ARRAY = 21;
  public static final int CLASS = 22;
  public static final int RETURN = 23;
  public static final int WHILE = 24;
  public static final int IF = 25;
  public static final int ELSE = 26;
  public static final int NEW = 27;
  public static final int EXTENDS = 28;
  public static final int NIL = 29;

  public static final int STRING= 30;
  public static final int INT = 31;
  public static final int ID = 32;

  public static final int NO_MATCH = 1000;

  public static Map<Integer, String> getTokenNameMap() {
    Map<Integer, String> tokenMap = new HashMap<>();  
    tokenMap.put(0, "EOF");
    tokenMap.put(1, "PLUS");
    tokenMap.put(2, "MINUS");
    tokenMap.put(3, "TIMES");
    tokenMap.put(4, "DIVIDE");
    tokenMap.put(5, "LPAREN");
    tokenMap.put(6, "RPAREN");
        tokenMap.put(7, "LBRACK");
        tokenMap.put(8, "RBRACK");
        tokenMap.put(9, "LBRACE");
        tokenMap.put(10, "RBRACE");
        tokenMap.put(11, "COMMA");
        tokenMap.put(12, "DOT");
        tokenMap.put(13, "SEMICOLON");
        tokenMap.put(14, "TYPE_INT");
        tokenMap.put(15, "TYPE_STRING");
        tokenMap.put(16, "TYPE_VOID");
        tokenMap.put(17, "ASSIGN");
        tokenMap.put(18, "EQ");
        tokenMap.put(19, "LT");
        tokenMap.put(20, "GT");
        tokenMap.put(21, "ARRAY");
        tokenMap.put(22, "CLASS");
        tokenMap.put(23, "RETURN");
        tokenMap.put(24, "WHILE");
        tokenMap.put(25, "IF");
        tokenMap.put(26, "ELSE");
        tokenMap.put(27, "NEW");
        tokenMap.put(28, "EXTENDS");
        tokenMap.put(29, "NIL");
        tokenMap.put(30, "STRING");
        tokenMap.put(31, "INT");
        tokenMap.put(32, "ID");
        
        return tokenMap;
    }
}

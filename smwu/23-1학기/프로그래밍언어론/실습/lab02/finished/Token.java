// Token.java
// 프로그래밍언어론 lab02 소프트웨어학부 컴퓨터과학전공 2016133 이유진
import java.lang.Enum;

enum Token {
     
     BOOL("bool"),CHAR("char"), ELSE("else"), FALSE("false"), FLOAT("float"), 
     STRING("string"), IF("if"), INT("int"),  TRUE("true"), WHILE("while"), 
     RETURN("return"), VOID("void"), FUN("fun"),  THEN("then"), LET("let"), 
     IN("in"), END("end"), READ("read"), PRINT("print"), DO("do"),  FOR("for"), 
     EOF("<<EOF>>"), 
     LBRACE("{"), RBRACE("}"), LBRACKET("["), RBRACKET("]"),
     LPAREN("("), RPAREN(")"), SEMICOLON(";"), COMMA(","),
     ASSIGN("="), EQUAL("=="),  LT("<"), LTEQ("<="), GT(">"),  
     GTEQ(">="),  NOT("!"),    NOTEQ("!="), PLUS("+"), MINUS("-"), 
     MULTIPLY("*"), DIVIDE("/"), AND("&"), OR("|"), ID(""), 
     NUMBER(""), STRLITERAL(""); 

    private String value; 

    private Token (String v) {
        value = v;
    }

    public String value( ) { return value; }
    public Token setValue(String v) { 
        this.value = v; 
        return this; 
    }

    public static Token idORkeyword (String name) {
        for (Token token : Token.values()) {
           if (token.value().equals(name)) 
        	   return token;
           if (token == Token.EOF) 
               break;
        }
	    return ID.setValue(name);
    } // keyword or ID
}
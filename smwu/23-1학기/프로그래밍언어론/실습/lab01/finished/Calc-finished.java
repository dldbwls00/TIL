//소프트웨어학부 컴퓨터과학전공 2016133 이유진
//2023-1학기 프로그래밍언어론(002) Lab01
import java.io.*;

class Calc {
   int token; int value; int ch;
    private PushbackInputStream input;
    final int NUMBER=256;
    
    Calc(PushbackInputStream is){
        input = is;
    }

    int getToken( ) { /* tokens are characters */
        while (true) {
            try{
               ch = input.read();
                if (ch == ' ' || ch == '\t' || ch == '\r');
                else if (Character.isDigit(ch)) {
                    value = number( );
                    input.unread(ch);
                    return NUMBER;
                } 
                else return ch;
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
    
    void error(){
        System.out.printf("parse error: %d\n",ch);
        //System.exit(1);
    }
    
    void match(int c) { 
        if (token == c)   token = getToken();
        else error();
    }

    void command() {
        /* command -> expr '\n' */
        Object result = expr(); //수정함
        if (token == '\n') /* end the parse and print the result */
           System.out.println("The result is: " + result); //수정함
        else error();
    }

    Object expr() {//
    	/* expr -> bexp {'&' bexp | '|' bexp} | !expr | true | false */
        Object result = "";
        if (token == '!'){// !<expr>
            match('!');
            result = !(boolean)expr();
        }
        else if (token == 't') {// true
            match('t');
            result = true ;
        }
        else if (token == 'f') {// false
            match('f');
            result = false ;
        }
        else {// &<bexp>, |<bexp>
        	result = bexp();
            while (token == '&') {
                match('&');
                Object temp = bexp();
                if ((boolean)result == true && ((boolean)temp) == true) {
                	result = true;
                }
                else   result = false;
            }
            while (token == '|'){
                match('|');
                Object temp = bexp();
                if ((boolean)result == true || ((boolean)temp) == true) {
                	result = true;
                }
                else   result = false;
            }
        }
        return result;
    }
    
    Object bexp(){
    	/* bexp -> aexp [relop aexp] */
        Object result = aexp();
        String op = relop();
        if (op == "==") {// ==
            if ((Integer)result == aexp())   result = true;
            else   result = false;
         }
         else if (op == "!=") {// !=
            if ((Integer)result != aexp())   result = true;
            else   result = false;
         }
         else if (op == "<") {// <
            if ((Integer)result < aexp())   result = true;
            else   result = false;
         }
         else if (op == ">") {// >
            if ((Integer)result > aexp())   result = true;
            else   result = false;
         }
         else if (op == "<=") {// <=
            if ((Integer)result <= aexp())   result = true;
            else   result = false;
         }
         else if (op == ">=") {// >=
            if ((Integer)result >= aexp())   result = true;
            else   result = false;
         }
         return result;
    }
    
    String relop(){//done
    	/* == | != | < | > | <= | >= */
        String result = "";
        while (token == '='){// ==
            match('=');
            result = "==";
        }
        if (token == '!') {
            match('!');
            if (token == '=') {// !=
                match('=');
                result = "!=";
            } 
            else   result = "!";// !
        } 
        else if (token == '<'){
            match('<');
            if (token == '='){// <=
                match('=');
                result = "<=";
            }
            else   result = "<";// <
        } 
        else if (token == '>'){
            match('>');
            if (token == '='){// >=
                match('=');
                result = ">=";
            }
            else   result = ">";// >
        } 
        return result;
    }
    
    int aexp(){//done
        /* aexp -> term { '+' term | '-' term } */
       int result = term();
       while (token == '+' || token == '-') {
          if (token == '+') {// +<term>
             match('+');
             result += term();
          }
          else {// -<term>
             match('-');
             result -= term();
          }
       }
       return result;
    }

    int term( ) {//done
        /* term -> factor { '*' factor | '/' factor} */
       int result = factor();
       while (token == '*' || token == '/' ) {
          if (token == '*') {// *<factor>
             match('*');
             result *= factor();
          }
          else {// /<factor>
             match('/');
             result /= factor();
          }
       }
       return result;
    }

    int factor(){
        /* factor -> [-] ( number | '('aexp')' ) */
        int result = 0;
        if (token == '(') {
            match('(');
            result = aexp();
            match(')');
        }
        else if (token == NUMBER){
            result = value;
            match(NUMBER); //token = getToken();
        }
        return result;
    }
    
    private int number( ) {
        /* number -> digit { digit } */
        int result = ch - '0';
        try{
            ch = input.read();
            while (Character.isDigit(ch)) {
                result = 10 * result + ch - '0';
                ch = input.read();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        return result;
    }

    void parse(){
        token = getToken(); //get the first token
        command(); //call the parsing command
    }
    public static void main(String []args){
        Calc calc = new Calc(new PushbackInputStream(System.in));
        while (true){
            System.out.print(">> ");
            calc.parse();
        }
    }
}
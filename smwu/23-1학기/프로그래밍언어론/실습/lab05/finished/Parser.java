// Parser.java
// Parser for language S
// 프로그래밍언어론 lab05 소프트웨어학부 컴퓨터과학전공 2016133 이유진

public class Parser {
    Token token;          // current token 
    Lexer lexer;
    String funId = "";

    public Parser(Lexer scan) { 
        lexer = scan;		  
        token = lexer.getToken(); // get the first token
    }
  
    private String match(Token t) {
        String value = token.value();
        if (token == t) 
            token = lexer.getToken();
        else 
            error(t);
        return value;
    }

    private void error(Token tok) {
        System.err.println("Syntax error: " + tok + " --> " + token);
        token = lexer.getToken();
    }
  
    private void error(String tok) {
        System.err.println("Syntax error: " + tok + " --> " + token);
        token = lexer.getToken();
    }
  
    public Command command() {
    // <command> ->  <decl> | <function> | <stmt>
	    if (isType()) {
	        Decl d = decl();
	        return d;
	    }
	/*
	    if (token == Token.FUN) {
	        Function f = function();
	        return f;
	    }
	*/
	    if (token != Token.EOF) {
	        Stmt s = stmt();
            return s;
	    }
	    return null;
    }

    private Decl decl() {
    // <decl>  -> <type> id[n]; //lab04
    // <decl>  -> <type> id [=<expr>]; 
        Type t = type();
	    String id = match(Token.ID);
	    Decl d = null;
	    
	    if (token == Token.LBRACKET) { //lab04 done
            match(Token.LBRACKET);
            int n = Integer.parseInt(match(Token.NUMBER)); 
            match(Token.RBRACKET);
            match(Token.SEMICOLON);
            return new Decl(id, t, n);
        } 

	    if (token == Token.ASSIGN) {
	        match(Token.ASSIGN);
            Expr e = expr();
	        d = new Decl(id, t, e);
	    } 
	    else 
            d = new Decl(id, t);
            
	    match(Token.SEMICOLON);
	    return d;
    }

    private Decls decls () {
    // <decls> -> {<decl>}
        Decls ds = new Decls ();
	    while (isType()) {
	        Decl d = decl();
	        ds.add(d);
	    }
        return ds;             
    }

    private Function function() { //lab05
    // <function>  -> fun <type> id(<params>) <stmt> 
   
        match(Token.FUN);
	    Type t = type();
	    String str = match(Token.ID);
	    funId = str; 
	    Function f = new Function(str, t);
	    match(Token.LPAREN);
        if (token != Token.RPAREN)
            f.params = params();
	    match(Token.RPAREN);
	    Stmt s = stmt();		
	    f.stmt = s;
	    return f;
    }

    private Decls params() { //lab05
    // <params> -> <type> id {, <type> id}
    	
	    Decls params = new Decls();
        
		// parse declrations of parameters

        return params;
    }

    private Type type () {
    // <type>  ->  int | bool | void | string 
        Type t = null;
        switch (token) {
		    case INT:
	            t = Type.INT; break;
	        case BOOL:
	            t = Type.BOOL; break;
	        case VOID:
	            t = Type.VOID; break;
	        case STRING:
	            t = Type.STRING; break;
	        default:
		        error("int | bool | void | string");
	    }
        match(token);
        return t;       
    }
  
    private Stmt stmt() {
    // <stmt> -> <block> | <assignment> | <ifStmt> | <whileStmt> | ...
        Stmt s = new Empty();
        switch (token) {
	    case SEMICOLON:
            match(Token.SEMICOLON); return s;
        case LBRACE:			
	        match(Token.LBRACE);		
            s = stmts();
            match(Token.RBRACE);	
	        return s;
        case IF: 	// if statement 
            s = ifStmt(); return s;
        case WHILE:      // while statement 
            s = whileStmt(); return s;
        case ID:	// assignment
            s = assignment(); return s;
	    case LET:	// let statement 
            s = letStmt(); return s;
	    case READ:	// read statement 
            s = readStmt(); return s;
	    case PRINT:	// print statment 
            s = printStmt(); return s;
	    case RETURN: // return statement 
            s = returnStmt(); return s;
	    case DO: //lab03 done
	    	s = dowhileStmt(); return s;
	    case FOR: //lab03 done
	    	s = forStmt(); return s;
        default:  
	        error("Illegal stmt"); return null; 
	    }
    }
  
    private Stmts stmts () {
    // <block> -> {<stmt>}
        Stmts ss = new Stmts();
	    while((token != Token.RBRACE) && (token != Token.END))
	        ss.stmts.add(stmt()); 
        return ss;
    }

    private Let letStmt () {
    // <letStmt> -> let <decls> in <block> end
	    match(Token.LET);	
        Decls ds = decls();
	    match(Token.IN);
        Stmts ss = stmts();
        match(Token.END);	
        match(Token.SEMICOLON);
        return new Let(ds, null, ss);
    }

    private Read readStmt() { //done
    // <readStmt> -> read id;
    	match(Token.READ);
        Identifier id = new Identifier(match(Token.ID));
        match(Token.SEMICOLON);
        return new Read(id);
    }

    private Print printStmt() { //done
    // <printStmt> -> print <expr>;
        match(Token.PRINT);
        Expr e = expr();
        match(Token.SEMICOLON);
        return new Print(e);
    }

    private Return returnStmt() { //lab05 함수 리턴
    // <returnStmt> -> return <expr>; 
        match(Token.RETURN);
        Expr e = expr();
        match(Token.SEMICOLON);
        return new Return(funId, e);
    }

    private Stmt assignment() {
    // <assignment> -> id[<expr>] = <expr>; //lab04
    // <assignment> -> id = <expr>;   
    	
        Array array = null;
        Expr e1 = null;
        Expr e2 = null;
        Identifier id = new Identifier(match(Token.ID));
    	
	    if (token == Token.LPAREN)    // lab05 function call 
	        return call(id);
	
        while (token == Token.LBRACKET) {
            match(Token.LBRACKET);
            e1 = expr();
            match(Token.RBRACKET);
            array = new Array(id, e1);
        } 
        if (token == Token.ASSIGN){
            match(Token.ASSIGN);
            e2 = expr();
            match(Token.SEMICOLON);
        } 
        
        if (array == null)
            return new Assignment(id, e2);
        else 
            return new Assignment(array, e2);
    }


    private Call call(Identifier id) { //lab05 함수 호출
    // <call> -> id(<expr>{,<expr>});
	    
	    // parse function call
	    match(Token.LPAREN);
	    Call c = new Call(id, arguments());
	    match(Token.RPAREN);
	    match(Token.SEMICOLON);
		return c;
	    //return null;
    }


    private If ifStmt () {
    // <ifStmt> -> if (<expr>) then <stmt> [else <stmt>]
        match(Token.IF);
	    match(Token.LPAREN);
        Expr e = expr();
	    match(Token.RPAREN);
        match(Token.THEN);
        Stmt s1 = stmt();
        Stmt s2 = new Empty();
        if (token == Token.ELSE){
            match(Token.ELSE); 
            s2 = stmt();
        }
        return new If(e, s1, s2);
    }

    private While whileStmt () { //done
    // <whileStmt> -> while (<expr>) <stmt>
    	match(Token.WHILE);
        match(Token.LPAREN); 
        Expr e = expr(); 
	    match(Token.RPAREN); 
        Stmt s = stmt();
        return new While(e, s);
    }
    
    private Stmts dowhileStmt() { //lab03 done
    // <dowhileStmt> -> do <stmt> while (<expr>);
    	match(Token.DO);
    	Stmt s = stmt();
    	match(Token.WHILE);
    	match(Token.LPAREN);
    	Expr e = expr();
    	match(Token.RPAREN);
    	match(Token.SEMICOLON);
    	
    	While w = new While(e, s);
    	return new Stmts(s, w);
    }
    
    private Let forStmt() { //lab03 done
    // <forStmts> -> for(<type> id = <expr>; <expr>; id=<expr>) <stmt>
    	match(Token.FOR);
    	match(Token.LPAREN);
    	Decls ds = decls();
    	
    	Expr e1 = expr();
    	match(Token.SEMICOLON);
    	
    	Identifier id = new Identifier(match(Token.ID));
    	match(Token.ASSIGN);
    	Expr e2 = expr();
    	match(Token.RPAREN);
    	
    	Stmt s = stmt();
    	
    	Assignment a = new Assignment(id, e2);
    	Stmts wss = new Stmts(s, a);
    	While w = new While(e1, wss);
    	Stmts ss = new Stmts(w);
    	return new Let(ds, null, ss);
    }

    private Expr expr () { //done
    // <expr> -> <bexp> {& <bexp> | '|'<bexp>} | !<expr> | true | false
        switch (token) {
		    case NOT:
		        Operator op = new Operator(match(token));
		        Expr e = expr();
	            return new Unary(op, e);
	        case TRUE:
	            match(Token.TRUE);
	            return new Value(true);
	        case FALSE:
	            match(Token.FALSE);
	            return new Value(false);
        }

        Expr e = bexp();
        Expr b = null;
        Operator op = null;
        while (token == Token.AND || token == Token.OR){
            op = new Operator(match(token));
            b = bexp();
            return new Binary(op, e, b);
        }
        return e;
    }

    private Expr bexp() { //done
    // <bexp> -> <aexp> [ (< | <= | > | >= | == | !=) <aexp> ]
        Expr e = aexp();
        Expr a = null;
        Operator op = null;
        
        switch (token) {
            case LT:
                op = new Operator(match(token));
                a = aexp();
                return new Binary(op, e, a);
            case LTEQ:
                op = new Operator(match(token));
                a = aexp();
                return new Binary(op, e, a);
            case GT:
                op = new Operator(match(token));
                a = aexp();
                return new Binary(op, e, a);
            case GTEQ:
                op = new Operator(match(token));
                a = aexp();
                return new Binary(op, e, a);
            case EQUAL:
                op = new Operator(match(token));
                a = aexp();
                return new Binary(op, e, a);
            case NOTEQ:
                op = new Operator(match(token));
                a = aexp();
                return new Binary(op, e, a);
        }
        return e;
    }
  
    private Expr aexp () {
    // <aexp> -> <term> { + <term> | - <term> }
        Expr e = term();
        while (token == Token.PLUS || token == Token.MINUS) {
            Operator op = new Operator(match(token));
            Expr t = term();
            e = new Binary(op, e, t);
        }
        return e;
    }
  
    private Expr term () {
    // <term> -> <factor> { * <factor> | / <factor>}
        Expr t = factor();
        while (token == Token.MULTIPLY || token == Token.DIVIDE) {
            Operator op = new Operator(match(token));
            Expr f = factor();
            t = new Binary(op, t, f);
        }
        return t;
    }
  
    private Expr factor() {
    // <factor> -> [-](id | id'['<expr>']' | <call> | literal | '('<aexp> ')')
        // lab04
    	Operator op = null;
        if (token == Token.MINUS) 
            op = new Operator(match(Token.MINUS));

        Expr e = null;
        switch(token) {
	        case ID:
	            Identifier v = new Identifier(match(Token.ID));
	//            e = v;
	//            if (token == Token.LPAREN) {  // function call
	//                match(Token.LPAREN); 
	//                Call c = new Call(v,arguments());
	//                match(Token.RPAREN);
	//                e = c;
	//            } 
	            if (token == Token.LBRACKET){ //lab04 done?
	                match(Token.LBRACKET);
	                Expr n = expr();
	                match(Token.RBRACKET);
	                return new Array(v, n);
	            } 
	            else 
	            	e = v;
	            break;
	        case NUMBER: case STRLITERAL: 
	            e = literal();
	            break; 
	        case LPAREN: 
	            match(Token.LPAREN); 
	            e = aexp();       
	            match(Token.RPAREN);
	            break; 
	        default: 
	            error("Identifier | Literal"); 
        }

        if (op != null)
            return new Unary(op, e);
        else return e;
    }
  
    private Exprs arguments() { //?
    // arguments -> [ <expr> {, <expr> } ]
        Exprs es = new Exprs();
        while (token != Token.RPAREN) {
            es.add(expr());
            if (token == Token.COMMA)
                match(Token.COMMA);
            else if (token != Token.RPAREN)
                error("Exprs");
        }  
        return es;  
    }

    private Value literal( ) {
        String s = null;
        switch (token) {
	        case NUMBER:
	            s = match(Token.NUMBER);
	            return new Value(Integer.parseInt(s));
	        case STRLITERAL:
	            s = match(Token.STRLITERAL);
	            return new Value(s);
        }
        throw new IllegalArgumentException( "no literal");
    }
 
    private boolean isType( ) {
        switch(token) {
	        case INT: case BOOL: case STRING: 
	            return true;
	        default: 
	            return false;
        }
    }
    
    public static void main(String args[]) { //
	    Parser parser;
	    if (args.length == 0) {
	        System.out.print(">> ");
	        Lexer.interactive = true;
	        parser  = new Parser(new Lexer());
	        do {
	            if (parser.token == Token.EOF)
	            	parser.token = parser.lexer.getToken();
	            Command command = null;
                try {
                    command = parser.command();
		            if (command != null) 
		            	command.display(0);    // display AST 
                } catch (Exception e) {
                    System.err.println(e);
                }
		        System.out.print("\n>> ");
	        } while(true);
	    }
    	else {
	        System.out.println("Begin parsing... " + args[0]);
	        parser  = new Parser(new Lexer(args[0]));
	        Command command = null;
	        do {
	        	if (parser.token == Token.EOF) break;
                try {
		             command = parser.command();
		             if (command != null) 
		            	 command.display(0);      // display AST
                } catch (Exception e) {
                    System.err.println(e); 
                }
	        } while (command != null);
	        
	    }
    } //main
} // Parser.java
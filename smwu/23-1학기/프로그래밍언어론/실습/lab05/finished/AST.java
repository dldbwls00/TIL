// AST.java
// AST for S
// 프로그래밍언어론 lab05 소프트웨어학부 컴퓨터과학전공 2016133 이유진

import java.util.*;

class Indent {
	public static void display(int level, String s) {
		String tab = "";
		System.out.println();
		for (int i = 0; i < level; i++)
			tab = tab + "	";
		System.out.print(tab + s);
	}
}

abstract class Command {
    // Command = Decl | Function | Stmt
    Type type = Type.UNDEF;
    public void display(int l) {
    	Indent.display(l,getClass().toString().substring(6));
    }
}

class Decls extends ArrayList<Decl> { //done
    // Decls = Decl*
	public ArrayList<Decl> ds = new ArrayList<Decl>();
    
	Decls() { super(); }; //?
    Decls(Decl d) { //?
	    this.add(d);
    }
    public void display(int level) {
        Indent.display(level,"Decls");
        for (Decl decl:this)
            decl.display(level+1);
    }
}

class Decl extends Command { //done
    // Decl = Type type; Identifier id 
    Identifier id;
    Expr expr = null;
    int arraysize = 0;

    Decl (String s, Type t) {
        id = new Identifier(s); type = t;
    } // declaration 

    Decl (String s, Type t, int n) { //lab04 이용
        id = new Identifier(s); type = t; arraysize = n;
    } // array declaration 

    Decl (String s, Type t, Expr e) {
        id = new Identifier(s); type = t; expr = e;
    } // declaration 
    
    public void display(int level){
        super.display(level);
        type.display(level+1);
        id.display(level+1);
        if (expr != null )
            expr.display(level+1);
    }
    
    public String toString ( ) { //lab04 done?
        return id + " " + expr; 
    }

}

class Functions extends ArrayList<Function> { //lab05
    // Functions = Function*
}

class Function extends Command  { //lab05 함수 정의
    // Function = Type type; Identifier id; Decls params; Stmt stmt
    Identifier id;
    Decls params;
    Stmt stmt;
   
    Function(String s, Type t) { 
        id = new Identifier(s); type = t; params = null; stmt = null;
    }

    public String toString ( ) { 
       return id.toString() + params.toString();
//       return id.toString(); //?
    }
}

class Type {
    // Type = int | bool | string | fun | array | except | void
    final static Type INT = new Type("int");
    final static Type BOOL = new Type("bool");
    final static Type STRING = new Type("string");
    final static Type VOID = new Type("void");
    final static Type FUN = new Type("fun");
    final static Type ARRAY = new Type("array");
    final static Type EXC = new Type("exc"); //?
    final static Type RAISEDEXC = new Type("raisedexc"); //?
    final static Type UNDEF = new Type("undef");
    final static Type ERROR = new Type("error");
    
    protected String id;
    protected Type(String s) { id = s; }
    public String toString ( ) { return id; }
    
    public void display(int level){ //done
        Indent.display(level,"Type: " + id);
    }
}

class ProtoType extends Type {
   // defines the type of a function and its parameters
   Type result;  
   Decls params;
   ProtoType (Type t, Decls ds) {
      super(t.id);
      result = t;
      params = ds;
   }
}

abstract class Stmt extends Command {//ektl
    // Stmt = Empty | Stmts | Assignment | If  | While | Let | Read | Print
	public void display(int l) {
//        Indent.display(l,getClass().toString().substring(6)+"");
        super.display(l);
    }    
}

class Empty extends Stmt { //done
	public void display(int level){
        super.display(level);
    }
}

class Stmts extends Stmt {//ektl
    // Stmts = Stmt*
    public ArrayList<Stmt> stmts = new ArrayList<Stmt>();
    
//    Stmts() { super(); }
//    Stmts(Stmt s) {
//	     stmts.add(s);
//    }
//    Stmts(Stmt s, While w){ //lab03 done
//    	stmts.add(s);
//    	stmts.add(w);
//    }
//    Stmts(Stmt s, Assignment a){ //lab03 done
//    	stmts.add(s);
//    	stmts.add(a);
//    }
//    
//    public void display(int level){ //done
//        Indent.display(level,"Stmts");
//        for (Stmt s:stmts){
//            if (s!=null)
//                s.display(level+1);
//        }
//	    
//    }
    Stmt s;
    While w = null;
    Stmts ss = null;
    Assignment a = null;

    Stmts() { super(); }
    Stmts(Stmt s,While w) {
        this.w = w; this.s = s;
    }
    Stmts(While w){
        this.w = w;
    }
    Stmts(Stmt s, Assignment a){
        this.s = s; this.a = a;
    }

    public void display(int level){
        Indent.display(level,"Stmts");
        if (s != null)
            s.display(level+1);
        if (w != null)
            w.display(level+1);
        if (ss != null)
            ss.display(level+1);
        for (Stmt s : stmts){
            if (s != null)
                s.display(level+1);
        }
        if (a != null)
            a.display(level+1);
    }
}

class Assignment extends Stmt {//
    // Assignment = Identifier id; Expr expr
    Identifier id;
    Array ar = null; //?
    Expr expr;

    Assignment (Identifier t, Expr e) {
        id = t;
        expr = e;
    }
    Assignment (Array a, Expr e) { //lab04 이용
    	//id[<expr>] = <expr>;
        ar = a;
        expr = e;
    }
    public String toString(){ //lab04 done?
        return ar.id + " " + ar.expr + " " + id + " " + expr;
    }
    
    public void display(int level) { //lab04 done?
//    	Indent.display(level, "Assignment");
//    	id.display(level+1);
//    	ar.display(level+1); //lab04 추가
//    	expr.display(level+1);
        super.display(level);
        if (id != null)
            id.display(level+1);
        expr.display(level+1);
        if (ar != null)
            ar.display(level+1);
    }
}

class If extends Stmt {//
    // If = Expr expr; Stmt stmt1, stmt2;
    Expr expr;
    Stmt stmt1, stmt2;
    
    If (Expr t, Stmt tp) {
        expr = t; stmt1 = tp; stmt2 = new Empty( );
    }
    If (Expr t, Stmt tp, Stmt ep) {
        expr = t; stmt1 = tp; stmt2 = ep; 
    }
    
    public void display(int level){
        super.display(level);
        expr.display(level+1);
        stmt1.display(level+1);
        stmt2.display(level+1);
    }
}

class While extends Stmt { //lab04 수정 필요
    // While = Expr expr; Stmt stmt;
//    Expr expr;
//    Stmt stmt;
//
//    While (Expr t, Stmt b) {
//        expr = t; stmt = b;
//    }
//    public void display(int level){ //done
//        super.display(level);
//        expr.display(level+1);
//        stmt.display(level+1);
//    }
	Expr expr = null;
    Stmt stmt, stmts;
    Stmt stmt1 = null;

    While (Expr t, Stmt b) {
        expr = t; stmt = b;
    }
    While (Expr t, Stmt b,Stmt a) {
        expr = t; stmt = b; stmt1 = a;
    }
    public String toString(){
        return expr + " " + stmt;
    }
    
    public void display(int level){
        Indent.display(level, "While: ");
        if (stmt1 != null)
            stmt1.display(level+1);
        expr.display(level+1);
        if (stmt != null)
            stmt.display(level+1);
        if (stmts != null)
            stmts.display(level+1);
    }
}

class Let extends Stmt { //lab04 수정 필요
    // Let = Decls decls; Functions funs; Stmts stmts;
//    Decls decls;
//    Functions funs;
//    Stmts stmts;
//
//    Let(Decls ds, Stmts ss) {
//        decls = ds;
//		funs = null;
//        stmts = ss;
//    }
//    Let(Decls ds, Functions fs, Stmts ss) {
//        decls = ds;
//	    funs = fs;
//        stmts = ss;
//    }
//    
//    public void display(int level){ //done
//        super.display(level);
//        decls.display(level+1);
//        stmts.display(level+1);
//    }
    Decls decls;
    Functions funs;
    While wh;
    Stmts stmts;
    Assignment asm;
    
    Let(Decls ds, Functions fs, Stmts ss) {
        decls = ds;
        funs = fs;
        stmts = ss;
    } 
    public String toString(){
        return decls + " " + stmts;
    }
    
    public void display(int level){
        super.display(level);
        decls.display(level+1);
        if (stmts != null)
            stmts.display(level+1);
        if (wh != null)
            wh.display(level+1);
        if (asm != null)
            asm.display(level+1);
    }
}

class Read extends Stmt { //done
    // Read = Identifier id
    Identifier id;

    Read (Identifier v) {
        id = v;
    }
    
    public void display(int level){
        super.display(level);
        id.display(level+1);
    }
}

class Print extends Stmt {
    // Print =  Expr expr
    Expr expr;

    Print (Expr e) {
        expr = e;
    }
    public String toString(){ //lab04 done?
        return expr + " ";
    }
    
    public void display(int level){
        super.display(level);
        expr.display(level+1);
    }
}

class Return extends Stmt { //lab05 이용 : 리턴문
    Identifier fid;
    Expr expr;

    Return (String s, Expr e) {
        fid = new Identifier(s);
        expr = e;
    }
    
    public void display(int level){
        super.display(level);
        fid.display(level+1);
        expr.display(level+1);
    }
}

class Try extends Stmt {
    // Try = Identifier id; Stmt stmt1; Stmt stmt2; 
    Identifier eid;
    Stmt stmt1; 
    Stmt stmt2; 

    Try(Identifier id, Stmt s1, Stmt s2) {
        eid = id; 
        stmt1 = s1;
        stmt2 = s2;
    }
}

class Raise extends Stmt {
    Identifier eid;

    Raise(Identifier id) {
        eid = id;
    }
}

class Exprs extends ArrayList<Expr> {
    // Exprs = Expr*
    public ArrayList<Expr> exprs = new ArrayList<Expr>();

    public void display(int level) {
        for (Expr e : exprs){
            if (e != null)
                e.display(level+1);
        }
    }
}

abstract class Expr extends Stmt {
    // Expr = Identifier | Value | Binary | Unary | Call
    public void display(int l) { 
        Indent.display(l, getClass().toString().substring(6)+":");
    } 
}

class Call extends Expr { //lab05 이용 : 함수 호출
    Identifier fid;  
    Exprs args;

    Call(Identifier id, Exprs a) {
       fid = id;
       args = a;
    }
    
    public void display(int level){
        super.display(level);
        fid.display(level+1);
        args.display(level+1);
    }
}

class Identifier extends Expr {
    // Identifier = String id
    private String id;

    Identifier(String s) { id = s; }
    public String toString( ) { return id; }
    public boolean equals (Object obj) {
        String s = ((Identifier) obj).id;
        return id.equals(s);
    }
    
    public void display(int level){
        Indent.display(level, "Identifier: "+id);
    }
}

class Array extends Expr { //lab04 이용
//    Array = Identifier id; Expr expr;
//	id[<expr>] : 배얼 요소 접근, 즉 배열[인덱스]에 대한 표현
    Identifier id;
    Expr expr = null;

    Array(Identifier s, Expr e) { id = s; expr = e; }
    public String toString( ) { return id.toString(); }
    public boolean equals (Object obj) {
        String s = ((Array) obj).id.toString();
        return id.equals(s);
    }
    public void display(int level) {
    	if (id!=null)
            id.display(level+1);
        if (expr!=null)
            expr.display(level+1);
//    	Indent.display(level, "Array");
        System.out.print(": " + id);
    }
}

class Value extends Expr { //lab04 이용
    // Value = int | bool | string | array | function 
    protected boolean undef = true;
    Object value = null; // Type type;
    Expr e; //lab04 done?
    Value v;

    Value(Type t) {
        type = t;  
        if (type == Type.INT) value = new Integer(0);
        if (type == Type.BOOL) value = new Boolean(false);
        if (type == Type.STRING) value = "";
        undef = false;
    }
    Value(Object v) {
        if (v instanceof Integer) type = Type.INT;
        if (v instanceof Boolean) type = Type.BOOL;
        if (v instanceof String) type = Type.STRING;
        if (v instanceof Function) type = Type.FUN;
        if (v instanceof Value[]) type = Type.ARRAY;
        if (v instanceof Function) type = Type.FUN; //lab05 추가
        value = v; undef = false; 
    }
    Value(Expr e, Value v){ 
    	this.e = e;	this.v = v; 
    } //lab04?
    Object value() { return value; }
    int intValue( ) { 
        if (value instanceof Integer) 
            return ((Integer) value).intValue(); 
        else return 0;
    }
    boolean boolValue( ) { 
        if (value instanceof Boolean) 
            return ((Boolean) value).booleanValue(); 
        else return false;
    } 
    String stringValue ( ) {
        if (value instanceof String) 
            return (String) value;
        else return ""; //null
    }
    Function funValue ( ) { //lab05 이용
        if (value instanceof Function) 
            return (Function) value; 
        else return null;
    }
    Value[] arrValue ( ) { //lab04 이용
        if (value instanceof Value[]) 
            return (Value[]) value; 
        else return null;
    }
    Type type ( ) { return type; }
    public String toString( ) { //done
        //if (undef) return "undef";
        if (type == Type.INT) return "" + intValue(); 
        if (type == Type.BOOL) return "" + boolValue();
	    if (type == Type.STRING) return "" + stringValue();
        if (type == Type.FUN) return "" + funValue();
        if (type == Type.ARRAY) return "" + arrValue(); //?
        return "undef";
    }
    
    public void display(int level){
        Indent.display(level,"Value: " + value);
    }
}

class Binary extends Expr {//
// Binary = Operator op; Expr expr1; Expr expr2;
    Operator op;
    Expr expr1, expr2;

    Binary (Operator o, Expr e1, Expr e2) {
        op = o; expr1 = e1; expr2 = e2;
    } // binary
    public String toString(){ //lab04 done?
        return op + " " + expr1 + " " + expr2;
    }
    
    public void display(int level) {
    	Indent.display(level, "Binary");
    	op.display(level+1);
    	expr1.display(level+1);
    	expr2.display(level+1);
    }
}

class Unary extends Expr { //done
    // Unary = Operator op; Expr expr
    Operator op;
    Expr expr;

    Unary (Operator o, Expr e) {
        op = o; //(o.val == "-") ? new Operator("neg"): o; 
        expr = e;
    } // unary
    
    public void display(int level){
        super.display(level);
        op.display(level+1);
        if (expr != null) 
        	expr.display(level+1);
    }
}

class Operator { //done
    String val;
    
    Operator (String s) { 
    	val = s; 
    }
    public String toString( ) { 
    	return val; 
    }
    public boolean equals(Object obj) { 
    	return val.equals(obj); 
    }
    
    public void display(int level){
        Indent.display(level, "Operator: " + val);  
    }
}
//AST.java

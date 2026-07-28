package Package.FrontEnd;
import Package.Classes.LexPrs.*;
import java.util.List;

/*
BNF Grammar:
<expr> ::= <term> { ("+" | "-") <term> }
<term> ::= <factor> { ("*" | "/") <factor> }
<factor> ::= <int> | "(" <expr> ")"
*/

public class Parser {
    private List<Token> list;
    public Parser(List<Token> list) {
        this.list = list;
    }

    public Expr parse() {
        Expr expr = expr(list);
        if(isCurrentToken(Token.Kind.EOF)) return expr;
        return null;
    }

    private Expr expr(List<Token> list) {
        Expr n1 = term(list);
        while (isCurrentToken(Token.Kind.PLS) || isCurrentToken(Token.Kind.MNS)) {
            n1 = new BinOP(n1, consumeCurrentToken(), term(list));
        } return n1;
    }

    private Expr term(List<Token> list) {
        Expr n2 = factor(list);
        while (isCurrentToken(Token.Kind.MUL) || isCurrentToken(Token.Kind.DIV)) {
            n2 = new BinOP(n2, consumeCurrentToken(), factor(list));
        } return n2;
    }

    private Expr factor(List<Token> list) {
        if (isCurrentToken(Token.Kind.LBR)) {
            consumeCurrentToken();
            Expr exp = expr(list);
            if (isCurrentToken(Token.Kind.RBR)) {
                consumeCurrentToken();
                return exp;
            }
        } else if (isCurrentToken(Token.Kind.INT)) return new IntVal(consumeCurrentToken().getVal());
        return  null;
    }

    private boolean isCurrentToken(Token.Kind kind) { return (!list.isEmpty()) && (list.getFirst().getKind() == kind); }

    private Token consumeCurrentToken() { return list.removeFirst(); }
}
package Package.Classes.LexPrs;

public class BinOP extends Expr {
    private Expr leftOP, rightOP;
    private Token sign;

    public BinOP(Expr leftOP, Token sign, Expr rightOP) {
        this.leftOP = leftOP;
        this.sign = sign;
        this.rightOP = rightOP;
    }

    public Expr getLeftOP() {return leftOP;}
    public Expr getRightOP() {return rightOP;}
    public Token getSign() {return sign;}
}
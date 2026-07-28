package Package.Classes.LexPrs;

public class IntVal extends Expr {
    private String val;

    public IntVal(String val) {
        this.val = val;
    }

    public String getVal() { return val; }
}
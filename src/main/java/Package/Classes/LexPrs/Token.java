package Package.Classes.LexPrs;

public class Token {
    public enum Kind {PLS, MNS, MUL, DIV, INT, LBR, RBR, EOF}
    private Kind kind;
    private String val;

    public Token(Kind kind, String val) {
        this.kind = kind;
        this.val = val;
    }

    public Kind getKind() {return kind;}
    public String getVal() {return val;}
}

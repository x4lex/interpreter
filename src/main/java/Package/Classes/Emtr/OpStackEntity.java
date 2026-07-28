package Package.Classes.Emtr;
import Package.Classes.LexPrs.Token;

public class OpStackEntity extends StackEntity {
    private Token.Kind kind;

    public OpStackEntity(Token.Kind kind) {
        this.kind = kind;
    }

    public Token.Kind getKind() {return kind;}
}

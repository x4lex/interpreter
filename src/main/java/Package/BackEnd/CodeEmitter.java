package Package.BackEnd;
import Package.Classes.LexPrs.*;
import java.util.LinkedList;

public class CodeEmitter {
    private LinkedList<String> bytecode = new LinkedList<>();
    private int rcntr = 1, memcntr = 0;

    public String emit(Expr tree) {
        if (tree instanceof BinOP) {
            String lt = emit(((BinOP) tree).getLeftOP());
            boolean strg = false;
            if (((BinOP) tree).getRightOP() instanceof BinOP && lt == null){
                bytecode.add("STR "+ rcntr +" "+ memcntr++);
                strg = true;
            }

            String rt = emit(((BinOP) tree).getRightOP());

            if (lt != null) bytecode.add(lt);
            if (rt != null) bytecode.add(rt);

            if(strg) bytecode.add("RMV "+ (rcntr^1) +" "+ --memcntr);
            bytecode.add(((BinOP) tree).getSign().getKind().toString() +" "+ (rcntr ^= 1) +" "+ (rcntr ^= 1) +" "+ (rcntr ^= 1));

            return null;
        }
        return "LOAD "+ (rcntr ^= 1) +" "+ ((IntVal) tree).getVal().toString();
    }

    public LinkedList<String> getList() {return bytecode;}
}
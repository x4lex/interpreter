import Package.BackEnd.*;
import Package.FrontEnd.*;

public class Main {
    public static void main(String[] args) {
        Parser prsr = new Parser(Lexer.Handle("(1 + 2) + ((3 + 4) + ((5 + 6) + ((7 + 8) + (9 + 10))))"));
        CodeEmitter cdem = new CodeEmitter();
        RegVirtMachine sbmh = new RegVirtMachine();

        cdem.emit(prsr.parse());
        System.out.print("Result: " + sbmh.calc(cdem.getList())+"\n");
    }
}
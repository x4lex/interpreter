import Package.BackEnd.*;
import Package.FrontEnd.*;

public class Main {
    public static void main(String[] args) {
        Parser prsr = new Parser(Lexer.Handle("(((100 / 5) - (4 * 3)) - ((20 - 8) / (2 + 1)))^2"));
        CodeEmitter cdem = new CodeEmitter();
        RegVirtMachine sbmh = new RegVirtMachine();

        cdem.emit(prsr.parse());
        System.out.print("Result: " + sbmh.calc(cdem.getList())+"\n");
    }
}
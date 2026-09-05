package Package.FrontEnd;
import Package.Classes.LexPrs.Token;

import java.io.EOFException;
import java.util.*;

public class Lexer {
    public static List<Token> Handle(String problem) {
        List<Token> list = new ArrayList<>();
        int i = 0;
        while (i < problem.length()) {
            if (problem.charAt(i) == '+') list.add(new Token(Token.Kind.PLS, problem.charAt(i)+""));
            else if (problem.charAt(i) == '-') list.add(new Token(Token.Kind.MNS, problem.charAt(i)+""));
            else if (problem.charAt(i) == '*') list.add(new Token(Token.Kind.MUL, problem.charAt(i)+""));
            else if (problem.charAt(i) == '/') list.add(new Token(Token.Kind.DIV, problem.charAt(i)+""));
            else if (problem.charAt(i) == '^') list.add(new Token(Token.Kind.POW, problem.charAt(i)+""));
            else if (problem.charAt(i) == '(') list.add(new Token(Token.Kind.LBR, problem.charAt(i)+""));
            else if (problem.charAt(i) == ')') list.add(new Token(Token.Kind.RBR, problem.charAt(i)+""));
            if (Character.isDigit(problem.charAt(i))) {
                int num = 0;
                while (i < problem.length() && Character.isDigit(problem.charAt(i))) {
                    num = num * 10 + problem.charAt(i) - '0';
                    i++;
                }
                list.add(new Token(Token.Kind.INT, num+""));
            }
            else i++;
        }
        list.add(new Token(Token.Kind.EOF, ""));
        return list;
    }
}
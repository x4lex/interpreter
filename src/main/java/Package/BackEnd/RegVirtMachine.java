package Package.BackEnd;
import java.util.*;

public class RegVirtMachine {
    private int[] rgstrs = new int[2], mem = new int[20];

    public int calc(List<String> list) {
        for (String line : list){
            String[] str = line.split(" ");
            switch (str[0]) {
                case "LOAD"-> rgstrs[Integer.parseInt(str[1])] = Integer.parseInt(str[2]);
                case "STR" -> mem[Integer.parseInt(str[2])] = rgstrs[Integer.parseInt(str[1])];
                case "RMV" -> rgstrs[Integer.parseInt(str[1])] = mem[Integer.parseInt(str[2])];
                case "PLS" -> rgstrs[Integer.parseInt(str[1])] = rgstrs[Integer.parseInt(str[3])] + rgstrs[Integer.parseInt(str[2])];
                case "MNS" -> rgstrs[Integer.parseInt(str[1])] = rgstrs[Integer.parseInt(str[3])] - rgstrs[Integer.parseInt(str[2])];
                case "MUL" -> rgstrs[Integer.parseInt(str[1])] = rgstrs[Integer.parseInt(str[3])] * rgstrs[Integer.parseInt(str[2])];
                case "DIV" -> rgstrs[Integer.parseInt(str[1])] = rgstrs[Integer.parseInt(str[3])] / rgstrs[Integer.parseInt(str[2])];
            }
        }
        return rgstrs[0];
    }
}
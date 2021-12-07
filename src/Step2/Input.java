package Step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
    public List<String> input(){
        System.out.printf("SOKOBAN > ");
        Scanner scanner = new Scanner(System.in);
        List<String> inputMove = new ArrayList<>();
        String input = scanner.next();

        for (String ch : input.split("")) {
            inputMove.add(ch);
        }
        return inputMove;
    }
}

package Step2;

import java.util.Scanner;

public class PlayAgain {
    public boolean again(){
        System.out.println("다시 시작하시겠습니까? 다시 시작 : 아무키, 종료 : q");
        Scanner scanner = new Scanner(System.in);
        char answer = scanner.next().charAt(0);
        if(answer != 'q'){
            return true;
        }
        System.out.println("Bye~!");
        return false;
    }
}

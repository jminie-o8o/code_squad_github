package Step3;

import Step2.Input;
import Step2.Show;
import java.util.List;

public class Main3 {
    public static void main(String[] args) {
        Input input = new Input();
        Show show = new Show();
        FinalPlay finalPlay = new FinalPlay();
        Check check = new Check();
        IntMapLists intMapLists = new IntMapLists();
        StringMapLists stringMapLists = new StringMapLists();

        boolean clear = true;
        int count = 0;

        System.out.println("소코반의 세계에 오신 것을 환영합니다!");
        System.out.println("^오^");

        Loop1:
        for (int i = 0; i < stringMapLists.stringMapLists().size(); i++) {
            int[][] intMap = intMapLists.intMapLists().get(i);
            System.out.println();
            System.out.printf("Stage %d \n", i + 1);
            System.out.println();
            show.showMap(stringMapLists.stringMapLists().get(i));
            System.out.println();
            Loop2:
            while (clear) { // clear 가 false 가 되어야 클리어 한 것 -> 그래야 이 while 문을 탈출하므로
                List<String> command = input.input();
                if(command.get(0).charAt(0) == 'r'){
                    intMapLists.intMapLists().get(i);
                    i -= 1;
                    continue Loop1; // r을 누른다면 다시 진행중인 스테이지를 시작한다.
                }
                String[][] map = finalPlay.playGame(command, intMap);
                clear = check.stageCheck(map); // Stage 를 클리어 했는지 여부를 확인
                count += 1;
            }
            System.out.printf("빠밤! Stage %d 클리어!\n", i + 1);
            System.out.println("턴수: " + count);
            count = 0;
            clear = true;
        }
        System.out.println();
        System.out.println("전체 게임을 클리어하셨습니다!!!");
        System.out.println("축하드립니다!");
    }
}

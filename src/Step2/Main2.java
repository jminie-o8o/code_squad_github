package Step2;

import Step1.MapConvert;
import Step1.MapList;

import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        MapList mapList = new MapList();
        MapConvert mapConvert = new MapConvert();
        Input input = new Input();
        Play play = new Play();
        PlayAgain playAgain = new PlayAgain();

        int[][] secondStage = mapConvert.convert(mapList.stage2());
        boolean again = true;
        while (again){
            List<String> command = input.input();
            play.playGame(command, secondStage);
            again = playAgain.again();
        }
    }
}

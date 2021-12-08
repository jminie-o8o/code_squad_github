package Step3;

import Step1.MapConvert;
import Step1.MapList;
import Step2.Input;
import Step2.Play;
import Step2.PlayAgain;
import Step2.Show;

public class Main3 {
    public static void main(String[] args) {
        MapList mapList = new MapList();
        MapConvert mapConvert = new MapConvert();
        Input input = new Input();
        Play play = new Play();
        Show show = new Show();
        PlayAgain playAgain = new PlayAgain();
        FinalMove finalMove = new FinalMove();

        int[][] secondStage = mapConvert.convert(mapList.stage2());
        String[][] test = finalMove.moveDown(secondStage);
        show.showMap(test);
    }
}

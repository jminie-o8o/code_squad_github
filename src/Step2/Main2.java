package Step2;

import Step1.MapConvert;
import Step1.MapList;

import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        MapList mapList = new MapList();
        MapConvert mapConvert = new MapConvert();
        Show show = new Show();
        Move move = new Move();
        Input input = new Input();
        Play play = new Play();

//        // MapList 에 있는 String[][] 타입의 stage2를 가져와서 int[][] 타입으로 전환시켜 준다.
//        int[][] secondStage = mapConvert.convert(mapList.stage2());
//        String[][] test = move.moveDown(secondStage);
//        show.showMap(test);

        int[][] secondStage = mapConvert.convert(mapList.stage2());
        List<String> command = input.input();
        play.playGame(command, secondStage);
    }
}

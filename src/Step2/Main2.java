package Step2;

import Step1.MapConvert;
import Step1.MapList;

import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        MapList mapList = new MapList();
        MapConvert convert = new MapConvert();
        Show show = new Show();
        Play play = new Play();

        // MapList 에 있는 String[][] 타입의 stage2를 가져와서 int[][] 타입으로 전환시켜 준다.
        int[][] secondStage = convert.convert(mapList.stage2());
        String[][] test = play.moveUp(secondStage);
        show.showMap(test);
    }
}

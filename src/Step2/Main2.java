package Step2;

import Step1.MapConvert;
import Step1.MapList;

import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        MapList mapList = new MapList();
        MapConvert convert = new MapConvert();

        // MapList 에 있는 String[][] 타입의 stage2를 가져와서 int[][] 타입으로 전환시켜 준다.
        int[][] secondStage = convert.convert(mapList.stage2());

        Play play = new Play();
        String[][] test = play.moveRight(secondStage);
        for (int i = 0; i < test.length; i++) {
            String[] inArr = test[i];
            for (int j = 0; j < inArr.length; j++) {
                System.out.print(inArr[j] + "");
            }
            System.out.println(); // 한 줄이 끝나면 다음 줄로 넘어가기 위한 용도
        }
    }
}

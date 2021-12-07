package Step2;

import Step1.MapConvert;
import Step1.MapList;

import java.util.List;

public class Play {
    Show show = new Show();
    Move move = new Move();
    MapList mapList = new MapList();
    MapConvert mapConvert = new MapConvert();
    MapReconvert mapReconvert = new MapReconvert();

    public String[][] playGame(List<String> input, int[][] secondStage){
        int[][] map = secondStage;
        String[][] finalMap = mapReconvert.reconvert(map);
        for (int i = 0; i < input.size(); i++) {
            char command = input.get(i).charAt(0);
            if(command == 'a'){
                finalMap =  move.moveLeft(secondStage);
                show.showMap(finalMap);
                System.out.println();
                continue;
            }
            if(command == 'd'){
                finalMap =  move.moveRight(secondStage);
                show.showMap(finalMap);
                System.out.println();
                continue;
            }
            if(command == 'w'){
                finalMap =  move.moveUp(secondStage);
                show.showMap(finalMap);
                System.out.println();
                continue;
            }
            if(command == 's'){
                finalMap =  move.moveDown(secondStage);
                show.showMap(finalMap);
                System.out.println();
                continue;
            } else {
                char upper = Character.toUpperCase(command); // char 를 대문자로 바꿔서 출력
                System.out.printf("%c: (경고!) 해당 명령을 수행할 수 없습니다.\n", upper);
                System.out.println();
                show.showMap(finalMap);
                System.out.println();
                continue;
            }
        }
        return finalMap;
    }
}

package Step3;

import Step2.MapReconvert;
import Step2.Show;

import java.util.List;

public class FinalPlay {
    Show show = new Show();
    MapReconvert mapReconvert = new MapReconvert();
    MoveRight moveRight = new MoveRight();
    MoveLeft moveLeft = new MoveLeft();
    MoveUp moveUp = new MoveUp();
    MoveDown moveDown = new MoveDown();

    public String[][] playGame(List<String> input, int[][] stage){
        int[][] map = stage;
        String[][] finalMap = mapReconvert.reconvert(map);
        for (int i = 0; i < input.size(); i++) {
            char command = input.get(i).charAt(0);
            if(command == 'd'){
                finalMap = moveRight.moveRight(stage);
                show.showMap(finalMap);
                System.out.println();
                continue;
            }
            if(command == 'a'){
                finalMap = moveLeft.moveLeft(stage);
                show.showMap(finalMap);
                System.out.println();
                continue;
            }
            if(command == 'w'){
                finalMap = moveUp.moveUp(stage);
                show.showMap(finalMap);
                System.out.println();
                continue;
            }
            if(command == 's'){
                finalMap = moveDown.moveDown(stage);
                show.showMap(finalMap);
                System.out.println();
                continue;
            } else {
                System.out.println("(경고!) 해당 명령을 수행할 수 없습니다.");
                System.out.println();
                show.showMap(finalMap);
                System.out.println();
                continue;
            }
        }
        return finalMap;
    }
}

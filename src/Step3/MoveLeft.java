package Step3;

import Step2.MapReconvert;

public class MoveLeft {
    MapReconvert reconvert = new MapReconvert();
    int onTheHole = 0;

    public String[][] moveLeft(int[][] map){
        Loop1:
        for (int i = 0; i < map.length; i++) {
            int[] inArr = map[i];
            Loop2:
            for (int j = 0; j < inArr.length; j++) {
                if(inArr[j] == 3 && inArr[j-1] == 5){
                    if(onTheHole == 0){
                        map[i][j] = 5;
                        map[i][j-1] = 3;
                        break Loop1;
                    }
                    if(onTheHole == 1){
                        map[i][j] = 1;
                        map[i][j-1] = 3;
                        onTheHole -= 1;
                        break Loop1;
                    }
                }
                if(inArr[j] == 3 && inArr[j-1] == 1){
                    if(onTheHole == 0){
                        map[i][j] = 5;
                        map[i][j-1] = 3;
                        onTheHole += 1;
                        break Loop1;
                    }
                    if(onTheHole == 1){
                        map[i][j] = 1;
                        map[i][j-1] = 3;
                        break  Loop1;
                    }
                }
                if(inArr[j] == 3 && inArr[j-1] == 2){
                    if(inArr[j-2] == 5){
                        if(onTheHole == 0){
                            map[i][j] = 5;
                            map[i][j-1] = 3;
                            map[i][j-2] = 2;
                            break Loop1;
                        }
                        if (onTheHole == 1){
                            map[i][j] = 1;
                            map[i][j-1] = 3;
                            map[i][j-2] = 2;
                            onTheHole -= 1;
                            break Loop1;
                        }
                    }
                    if(inArr[j-2] == 1){
                        if(onTheHole == 0){
                            map[i][j] = 5;
                            map[i][j-1] = 3;
                            map[i][j-2] = 6;
                            break Loop1;
                        }
                        if(onTheHole == 1){
                            map[i][j] = 1;
                            map[i][j-1] = 3;
                            map[i][j-2] = 6;
                            onTheHole -= 1;
                            break Loop1;
                        }
                    } else {
                        break Loop1;
                    }
                }
                if(inArr[j] == 3 && inArr[j-1] == 6){
                    if(inArr[j-2] == 5){
                        if(onTheHole == 0){
                            map[i][j] = 5;
                            map[i][j-1] = 3;
                            map[i][j-2] = 2;
                            onTheHole += 1;
                            break Loop1;
                        }
                        if(onTheHole == 1){
                            map[i][j] = 1;
                            map[i][j-1] = 3;
                            map[i][j-2] = 2;
                            onTheHole -= 1;
                            break Loop1;
                        }
                    }
                    if(inArr[j-2] == 1){
                        if(onTheHole == 0){
                            map[i][j] = 5;
                            map[i][j-1] = 3;
                            map[i][j-2] = 6;
                            onTheHole += 1;
                            break Loop1;
                        }
                        if(onTheHole == 1){
                            map[i][j] = 1;
                            map[i][j-1] = 3;
                            map[i][j-2] = 6;
                            break Loop1;
                        }
                    }
                    else {
                        break Loop1;
                    }
                }
                if(inArr[j] == 3 && inArr[j-1] == 0){
                    break Loop1;
                }
            }
        }
        String[][] moveLeft = reconvert.reconvert(map);
        return moveLeft;
    }
}

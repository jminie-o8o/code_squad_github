package Step3;

import Step2.MapReconvert;

public class MoveDown {
    MapReconvert reconvert = new MapReconvert();
    int onTheHole = 0;

    public String[][] moveDown(int[][] map){
        Loop1:
        for (int i = 0; i < map.length; i++) {
            int[] inArr = map[i];
            Loop2:
            for (int j = 0; j < inArr.length; j++) {
                if(inArr[j] == 3 && map[i+1][j] == 5){
                    if(onTheHole == 0){
                        map[i][j] = 5;
                        map[i+1][j] = 3;
                        break Loop1;
                    }
                    if(onTheHole == 1){
                        map[i][j] = 1;
                        map[i+1][j] = 3;
                        onTheHole -= 1;
                        break Loop1;
                    }
                }
                if(inArr[j] == 3 && map[i+1][j] == 1){
                    if(onTheHole == 0){
                        map[i][j] = 5;
                        map[i+1][j] = 3;
                        onTheHole += 1;
                        break Loop1;
                    }
                    if(onTheHole == 1){
                        map[i][j] = 1;
                        map[i+1][j] = 3;
                        break  Loop1;
                    }
                }
                if(inArr[j] == 3 && map[i+1][j] == 2){
                    if(map[i+2][j] == 5){
                        if(onTheHole == 0){
                            map[i][j] = 5;
                            map[i+1][j] = 3;
                            map[i+2][j] = 2;
                            break Loop1;
                        }
                        if (onTheHole == 1){
                            map[i][j] = 1;
                            map[i+1][j] = 3;
                            map[i+2][j] = 2;
                            onTheHole -= 1;
                            break Loop1;
                        }
                    }
                    if(map[i+2][j] == 1){
                        if(onTheHole == 0){
                            map[i][j] = 5;
                            map[i+1][j] = 3;
                            map[i+2][j] = 6;
                            break Loop1;
                        }
                        if(onTheHole == 1){
                            map[i][j] = 1;
                            map[i+1][j] = 3;
                            map[i+2][j] = 6;
                            onTheHole -= 1;
                            break Loop1;
                        }
                    } else {
                        break Loop1;
                    }
                }
                if(inArr[j] == 3 && map[i+1][j] == 6){
                    if(map[i+2][j] == 5){
                        if(onTheHole == 0){
                            map[i][j] = 5;
                            map[i+1][j] = 3;
                            map[i+2][j] = 2;
                            onTheHole += 1;
                            break Loop1;
                        }
                        if(onTheHole == 1){
                            map[i][j] = 1;
                            map[i+1][j] = 3;
                            map[i+2][j] = 2;
                            onTheHole -= 1;
                            break Loop1;
                        }
                    }
                    if(map[i+2][j] == 1){
                        if(onTheHole == 0){
                            map[i][j] = 5;
                            map[i+1][j] = 3;
                            map[i+2][j] = 6;
                            onTheHole += 1;
                            break Loop1;
                        }
                        if(onTheHole == 1){
                            map[i][j] = 1;
                            map[i+1][j] = 3;
                            map[i+2][j] = 6;
                            break Loop1;
                        }
                    }
                    else {
                        break Loop1;
                    }
                }
                if(inArr[j] == 3 && map[i+1][j] == 0){
                    break Loop1;
                }
            }
        }
        String[][] moveDown = reconvert.reconvert(map);
        return moveDown;
    }
}

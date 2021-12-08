package Step3;

import Step2.MapReconvert;

public class Move {
    MapReconvert reconvert = new MapReconvert();
    int onTheHole = 0; // location 이 1이라면 사람이 구멍 위에 있는 상태이다.

    public String[][] moveRight(int[][] map){

        Loop1:
        for (int i = 0; i < map.length; i++) {
            int[] inArr = map[i];
            Loop2:
            for (int j = 0; j < inArr.length; j++) {
                if(inArr[j] == 3 && inArr[j+1] == 5){ // 사람 옆에 빈칸일 때
                    if(onTheHole == 0){
                        map[i][j] = 5;
                        map[i][j+1] = 3;
                        break Loop1;
                    }
                    if(onTheHole == 1){
                        map[i][j] = 1;
                        map[i][j+1] = 3;
                        break Loop1;
                    }
                }
                if(inArr[j] == 3 && inArr[j+1] == 1){ // 사람 옆에 구멍일 때
                    if(onTheHole == 0){
                        map[i][j] = 5;
                        map[i][j+1] = 3;
                        onTheHole += 1; // 구멍 위로 올라갔으므로 onTheHole += 1
                        break Loop1;
                    }
                    if(onTheHole == 1){
                        map[i][j] = 1;
                        map[i][j+1] = 3; // 구멍에서 구멍으로 올라갔으므로 onTheHole 1로 유지
                        break  Loop1;
                    }
                }
                if(inArr[j] == 3 && inArr[j+1] == 2){
                    if(inArr[j+2] == 5){
                        if(onTheHole == 0){
                            map[i][j] = 5;
                            map[i][j+1] = 3;
                            map[i][j+2] = 2;
                            break Loop1;
                        }
                        if (onTheHole == 1){
                            map[i][j] = 1;
                            map[i][j+1] = 3;
                            map[i][j+2] = 2;
                            break Loop1;
                        }
                    }
                    if(inArr[j+2] == 1){
                        if(onTheHole == 0){
                            map[i][j] = 5;
                            map[i][j+1] = 3;
                            map[i][j+2] = 6; // 공이 구멍에 들어가 0으로 표시되는 것을 Reconvert 하기 전에 6으로 표시
                            break Loop1;
                        }
                        if(onTheHole == 1){
                            map[i][j] = 1;
                            map[i][j+1] = 3;
                            map[i][j+2] = 6;
                            break Loop1;
                        }
                    } else { // 공 뒤에 다른 공이나 벽이 있으면 그대로 for 문 탈출
                        break Loop1;
                    }
                }
                if(inArr[j] == 3 && inArr[j+1] == 6){
                    if(inArr[j+2] == 5){
                        if(onTheHole == 0){
                            map[i][j] = 5;
                            map[i][j+1] = 3;
                            map[i][j+2] = 2;
                            onTheHole += 1; // 합쳐져 있는 공과 구멍에서 공을 밀어냈으므로 구멍 위로 올라가게 된다.
                            break Loop1;
                        }
                        if(onTheHole == 1){
                            map[i][j] = 1;
                            map[i][j+1] = 3;
                            map[i][j+2] = 2; // 이미 구멍 위에 올라가 있으므로 onTheHole 1로 유지
                            break Loop1;
                        }
                    } else { // 공 뒤에 다른 공이나 벽이 있으면 그대로 for 문 탈출
                        break Loop1;
                    }
                }
                if(inArr[j] == 3 && inArr[j+1] == 0){
                    break Loop1;
                }
            }
        }
        // 오른쪽 이동이 끝났으면 다시 int[][] 타입의 map 을 String[][] 으로 return 시켜준다.
        String[][] moveRight = reconvert.reconvert(map);
        return moveRight;
    }

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
                            break Loop1;
                        }
                    } else {
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

    public String[][] moveUp(int[][] map){

        Loop1:
        for (int i = 0; i < map.length; i++) {
            int[] inArr = map[i];
            Loop2:
            for (int j = 0; j < inArr.length; j++) {
                if(inArr[j] == 3 && map[i-1][j] == 5){
                    if(onTheHole == 0){
                        map[i][j] = 5;
                        map[i-1][j] = 3;
                        break Loop1;
                    }
                    if(onTheHole == 1){
                        map[i][j] = 1;
                        map[i-1][j] = 3;
                        break Loop1;
                    }
                }
                if(inArr[j] == 3 && map[i-1][j] == 1){
                    if(onTheHole == 0){
                        map[i][j] = 5;
                        map[i-1][j] = 3;
                        onTheHole += 1;
                        break Loop1;
                    }
                    if(onTheHole == 1){
                        map[i][j] = 1;
                        map[i-1][j] = 3;
                        break  Loop1;
                    }
                }
                if(inArr[j] == 3 && map[i-1][j] == 2){
                    if(map[i-2][j] == 5){
                        if(onTheHole == 0){
                            map[i][j] = 5;
                            map[i-1][j] = 3;
                            map[i-2][j] = 2;
                            break Loop1;
                        }
                        if (onTheHole == 1){
                            map[i][j] = 1;
                            map[i-1][j] = 3;
                            map[i-2][j] = 2;
                            break Loop1;
                        }
                    }
                    if(map[i-2][j] == 1){
                        if(onTheHole == 0){
                            map[i][j] = 5;
                            map[i-1][j] = 3;
                            map[i-2][j] = 6;
                            break Loop1;
                        }
                        if(onTheHole == 1){
                            map[i][j] = 1;
                            map[i-1][j] = 3;
                            map[i-2][j] = 6;
                            break Loop1;
                        }
                    } else {
                        break Loop1;
                    }
                }
                if(inArr[j] == 3 && map[i-1][j] == 6){
                    if(map[i-2][j] == 5){
                        if(onTheHole == 0){
                            map[i][j] = 5;
                            map[i-1][j] = 3;
                            map[i-2][j] = 2;
                            onTheHole += 1;
                            break Loop1;
                        }
                        if(onTheHole == 1){
                            map[i][j] = 1;
                            map[i-1][j] = 3;
                            map[i-2][j] = 2;
                            break Loop1;
                        }
                    } else {
                        break Loop1;
                    }
                }
                if(inArr[j] == 3 && map[i-1][j] == 0){
                    break Loop1;
                }
            }
        }
        String[][] moveUp = reconvert.reconvert(map);
        return moveUp;
    }

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
                            break Loop1;
                        }
                    } else {
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

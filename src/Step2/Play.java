package Step2;

public class Play {
    MapReconvert reconvert = new MapReconvert();

    public String[][] moveRight(int[][] map){
        for (int i = 0; i < map.length; i++) {
            int[] inArr = map[i];
            for (int j = 0; j < inArr.length; j++) {
                if(inArr[j] == 3 && inArr[j+1] == 5){
                    map[i][j] = map[i][j+1]; // 2단계는 어차피 공백으로만 이동하니 map[i][j] = 5; 라고 둬도 무방
                    map[i][j+1] = 3;
                    System.out.println("D: 오른쪽으로 이동합니다.");
                    System.out.println();
                    break;
                }if(inArr[j] == 3 && inArr[j+1] != 5){
                    System.out.println("(경고!) 해당 명령을 수행할 수 없습니다!");
                    System.out.println();
                    break;
                }
            }
        }
        // 오른쪽 이동이 끝났으면 다시 int[][] 타입의 map 을 String[][] 으로 return 시켜준다.
        String[][] moveRight = reconvert.reconvert(map);
        return moveRight;
    }

    public String[][] moveLeft(int[][] map){
        for (int i = 0; i < map.length; i++) {
            int[] inArr = map[i];
            for (int j = 0; j < inArr.length; j++) {
                if(inArr[j] == 3 && inArr[j-1] == 5){
                    map[i][j] = map[i][j-1];
                    map[i][j-1] = 3;
                    System.out.println("A: 왼쪽으로 이동합니다.");
                    System.out.println();
                    break;
                }if(inArr[j] == 3 && inArr[j-1] != 5){
                    System.out.println("(경고!) 해당 명령을 수행할 수 없습니다!");
                    System.out.println();
                    break;
                }
            }
        }
        // 왼쪽 이동이 끝났으면 다시 int[][] 타입의 map 을 String[][] 으로 return 시켜준다.
        String[][] moveLeft = reconvert.reconvert(map);
        return moveLeft;
    }

    public String[][] moveUp(int[][] map){
        for (int i = 0; i < map.length; i++) {
            int[] inArr = map[i];
            for (int j = 0; j < inArr.length; j++) {
                if(inArr[j] == 3 && map[i-1][j] == 5){
                    map[i][j] = map[i-1][j];
                    map[i-1][j] = 3;
                    System.out.println("W: 위쪽으로 이동합니다.");
                    System.out.println();
                    break;
                }if(inArr[j] == 3 && map[i-1][j] != 5){
                    System.out.println("(경고!) 해당 명령을 수행할 수 없습니다!");
                    System.out.println();
                    break;
                }
            }
        }
        // 왼쪽 이동이 끝났으면 다시 int[][] 타입의 map 을 String[][] 으로 return 시켜준다.
        String[][] moveUp = reconvert.reconvert(map);
        return moveUp;
    }

    public String[][] moveDown(int[][] map){
        for (int i = 0; i < map.length; i++) {
            int[] inArr = map[i];
            for (int j = 0; j < inArr.length; j++) {
                if(inArr[j] == 3 && map[i+1][j] == 5){
                    map[i][j] = map[i+1][j];
                    map[i+1][j] = 3;
                    System.out.println("W: 위쪽으로 이동합니다.");
                    System.out.println();
                    break;
                }if(inArr[j] == 3 && map[i+1][j] != 5){
                    System.out.println("(경고!) 해당 명령을 수행할 수 없습니다!");
                    System.out.println();
                    break;
                }
            }
        }
        // 왼쪽 이동이 끝났으면 다시 int[][] 타입의 map 을 String[][] 으로 return 시켜준다.
        String[][] moveDown = reconvert.reconvert(map);
        return moveDown;
    }

}

package Step2;

public class Play {
    MapReconvert reconvert = new MapReconvert();

    public String[][] moveRight(int[][] map){
        for (int i = 0; i < map.length; i++) {
            int[] inArr = map[i];
            for (int j = 0; j < inArr.length; j++) {
                if(inArr[j] == 3){
                    map[i][j] = map[i][j+1]; // 2단계는 어차피 공백으로만 이동하니 map[i][j] = 5; 라고 둬도 무방
                    map[i][j+1] = 3;
                    break;
                }
            }
        }
        // 오른쪽 이동이 끝났으면 다시 int[][] 타입의 map 을 String[][] 으로 return 시켜준다.
        String[][] moveRight = reconvert.reconvert(map);
        return moveRight;
    }
}

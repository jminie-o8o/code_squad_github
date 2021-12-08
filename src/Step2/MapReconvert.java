package Step2;

public class MapReconvert {

    public String[][] reconvert(int[][] map){
        int row = 0;
        for (int i = 0; i < map.length; i++) {
            int[] inArr = map[i];
            row = inArr.length;
        }

        String[][] reconvertedMap = new String[map.length][row];
        for (int i = 0; i < map.length; i++) {
            int[] inArr = map[i];
            for (int j = 0; j < row; j++) {
                if (inArr[j] == 5){
                    reconvertedMap[i][j] = " ";
                }
                if (inArr[j] == 0){
                    reconvertedMap[i][j] = "#";
                }
                if (inArr[j] == 1){
                    reconvertedMap[i][j] = "O";
                }
                if (inArr[j] == 2){
                    reconvertedMap[i][j] = "o";
                }
                if (inArr[j] == 3){
                    reconvertedMap[i][j] = "P";
                }
                if (inArr[j] == 6){ // Step3 공과 구멍이 합쳐지는 부분 추가
                    reconvertedMap[i][j] = "0";
                }
            }
        }
        return reconvertedMap;
    }
}

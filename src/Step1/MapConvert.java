package Step1;

public class MapConvert {

    public int[][] convert(String[][] map) {
        int row = 0;
        for (int i = 0; i < map.length; i++) {
            String[] inArr = map[i];
            row = inArr.length;
        }

        // 여기서 map.length 는 세로길이 row 는 가로길이
        int[][] convertedMap = new int[map.length][row];

        for (int i = 0; i < map.length; i++) {
            String[] inArr = map[i];
            for (int j = 0; j < row; j++) {
                if (inArr[j] == " ") {
                    convertedMap[i][j] = 5;
                }
                if (inArr[j] == "#") {
                    convertedMap[i][j] = 0;
                }
                if (inArr[j] == "O") {
                    convertedMap[i][j] = 1;
                }
                if (inArr[j] == "o") {
                    convertedMap[i][j] = 2;
                }
                if (inArr[j] == "P") {
                    convertedMap[i][j] = 3;
                }
                if (inArr[j] == "0") { // Step3 공과 구멍이 합쳐지는 부분 추가
                    convertedMap[i][j] = 6;
                }
            }
        }
        return convertedMap;
    }
}


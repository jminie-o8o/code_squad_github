public class MapInfo {
    MapList mapList = new MapList();
    MapConvert mapConvert = new MapConvert();

    // 구멍의 개수를 구하는 메서드
    public int countHole(int[][] map) {
        int holeNumber = 0;
        for (int i = 0; i < map.length; i++) {
            int[] inArr = map[i];
            for (int j = 0; j < inArr.length; j++) {
                if (inArr[j] == 1) {
                    holeNumber += 1;
                }
            }
        }
        return holeNumber;
    }

    // 공의 개수를 구하는 메서드
    public int countBall(int[][] map) {
        int ballNumber = 0;
        for (int i = 0; i < map.length; i++) {
            int[] inArr = map[i];
            for (int j = 0; j < inArr.length; j++) {
                if (inArr[j] == 2) {
                    ballNumber += 1;
                }
            }
        }
        return ballNumber;
    }

    // String 을 int 로 변환한 2차원 배열을 매개변수로 사용자의 위치를 구하는 메서드
    public int[] playerLocation(int[][] map) {
        int[] playerLocation = new int[2];
        for (int i = 0; i < map.length; i++) {
            int[] inArr = map[i];
            for (int j = 0; j < inArr.length; j++) {
                if (inArr[j] == 3) {
                    playerLocation[0] = i;
                    playerLocation[1] = j;
                }
            }
        }
        return playerLocation;
    }

    // 맵의 정보를 출력해주는 메서드
    public void mapInfo(String[][] map) {
        int[][] convertedMap = mapConvert.convert(map);

        System.out.println();

        int row = 0;
        int column = 0;
        for (int i = 0; i < map.length; i++) {
            column = map.length;
            String[] inArr = map[i];
            for (int j = 0; j < inArr.length; j++) {
                row = inArr.length;
                System.out.print(inArr[j] + "");
            }
            System.out.println(); // 한 줄이 끝나면 다음 줄로 넘어가기 위한 용도
        }
        System.out.println();
        System.out.println("가로길이: " + row);
        System.out.println("세로길이: " + column);
        System.out.println("구멍의 수: " + countHole(convertedMap));
        System.out.println("공의 수: " + countBall(convertedMap));
        System.out.printf("플레이어 위치 (%d, %d)", playerLocation(convertedMap)[0] + 1, playerLocation(convertedMap)[1] + 1);
        System.out.println();
    }
}


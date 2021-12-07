# 구현과정 상세 설명

## 1단계
- Step1.MapList 클라스 작성
    - String[ ][ ] 즉 2차원 배열을 이용하여 Map의 형태를 갖춰준다.
    - 이때 처음에는 char 형태로 2차원 배열을 만들었지만 char 타입은 null 을 받을 수 없어 String 으로 변경했다.
    - 하지만 결국 null 이 아닌 공백문자열로 구현했으므로 char 로 하든 String 으로 하든 상관없었을 것 같다.
    - txt 파일로 받아서 문자열로 넘기는 것을 모르겠어서 Step1.MapList 에 직접 Map을 그려 넣는 방식으로 구현했다.
      </br>
      </br>

**Step1.MapList 클라스**
```java
public class MapList {

    public String[][] stage1() {
        String[][] stage1 = {
                {"#", "#", "#", "#", "#"},
                {"#", "O", "o", "P", "#"},
                {"#", "#", "#", "#", "#"}
        };
        return stage1;
    }

    public String[][] stage2() {
        String[][] stage2 = {
                {" ", " ", "#", "#", "#", "#", "#", "#", "#", " ", " "},
                {"#", "#", "#", " ", " ", "O", " ", " ", "#", "#", "#"},
                {"#", " ", " ", " ", " ", "o", " ", " ", " ", " ", "#"},
                {"#", " ", "O", "o", " ", "P", " ", "o", "O", " ", "#"},
                {"#", "#", "#", " ", " ", "o", " ", " ", "#", "#", "#"},
                {" ", "#", " ", " ", " ", "O"," ", " ", "#", " ", " "},
                {" ", "#", "#", "#", "#", "#", "#", "#", "#", " ", " "}
        };
        return stage2;
    }
}
```

- Step1.MapConvert 클라스 작성

|기호|의미|저장값|
|---|---|---|
|#|벽(wall)|0|
|O|구멍(Hall)|1|
|o|공(Ball)|2|
|P|플레이어(Player)|3|
|=|스테이지 구분|4|

**이슈**
- 처음에는 공백 문자열 즉 " " 을 생각하지 않고 작성했다.
    - 그러나 int 의 특징으로 인해 공백문자열을 자동으로 0으로 변환하여 벽 즉 # 과의 구분이 불가능하게 되어
      따로 저장값을 5라고 지정했다.
- 위에서 말한 것 처럼 txt 파일에서 문자열로 넘겨서 구현하는 것이 아니다 보니 스테이지 구분 즉 **=** 을 받을 일이 없어
  사실상 스테이지 구분 4는 쓰는 일이 없었다...

- MapConvert 출력 결과
    - [출력결과물](https://user-images.githubusercontent.com/79504043/144867123-aa9f7b0d-9b51-487e-bffd-34a52fe66570.png)


**Step1.MapConvert 클라스**
```java
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
                if (inArr[j] == "=") {
                    convertedMap[i][j] = 4;
                }
            }
        }
        return convertedMap;

    }
}

```

- Mapinfo 클라스 작성
    - 구멍의 개수를 구하는 메서드
    - 공의 개수를 구하는 메서드
    - String 을 int 로 변환한 2차원 배열을 매개변수로 사용자의 위치를 구하는 메서드
    - Map 의 정보를 출력해주는 메서드
- 위 4개와 같이 메서드를 분리해서 구현

**이슈**
- Step1.Main 에서 Stage 이름을 직접 찍어주는 것이 아니라 Step1.MapList 안에 글로벌필드로 Stage의 이름 (ex: Stage 1, Stage 2) 등을 넣어
  메서드에서 뽑아내도록 구현하고 싶었으나 계속 막혀서 실패... 추후 리팩토링


**Step1.MapInfo 클라스**

```java
import Step1.MapConvert;
import Step1.MapList;

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
```

- Step1.Main 클라스 작성 및 결과 출력

```java
import Step1.MapInfo;
import Step1.MapList;

public class Main {

    public static void main(String[] args) {
        MapList mapList = new MapList();
        MapInfo mapInfo = new MapInfo();
        String[][] firstStage = mapList.stage1();
        String[][] secondStage = mapList.stage2();

        System.out.println("Stage 1");
        mapInfo.mapInfo(firstStage);
        System.out.println();
        System.out.println("Stage 2");
        mapInfo.mapInfo(secondStage);
    }
}
```
- 결과
    - [결과 출력 사진](https://user-images.githubusercontent.com/79504043/144847198-f1795a7c-e99c-43e1-8ffa-dfbf846e86e4.png)

___
## 2단계

## 3단계
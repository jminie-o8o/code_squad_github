# 구현과정 상세 설명

## 2단계
- **Input 클라스 작성**
  - for 반복문과 Scanner 로 입력값을 입력받아 List<String> inputMove 에 입력값을 순서대로 받아 넣는다.
  - List< String > 타입으로 리턴해주었다.

**Input 클라스**
```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
    public List<String> input(){
        System.out.printf("SOKOBAN > ");
        Scanner scanner = new Scanner(System.in);
        List<String> inputMove = new ArrayList<>();
        String input = scanner.next();

        for (String ch : input.split("")) {
            inputMove.add(ch);
        }
        return inputMove;
    }
}
```

</br>

- **MapReconvert 클라스 작성**
  - 플레이어의 움직임을 구현하는 클라스를 작성하기 전에 우선 int 타입의 2차원 배열을 
  String 타입의 2차원 배열로 표현하기 위한 메서드가 필요했다. (이동을 마친 Map 을 다시 String 타입의 Map으로 표현해야 하기 때문)
  - Convert 클라스와 정확히 반대로 int 타입의 2차원 배열을 파라미터로 받아 String 타입의 2차원 배열로 리턴해주는 메서드를 작성했다.
  - 1단계에서 설명한대로 Stage의 구분자 == 은 구현하지 못하였으므로 4를 == 로 변경하는 기능은 뺐다.
  
**MapReconvert 클라스**
```java
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
            }
        }
        return reconvertedMap;
    }
}
```

</br>

- **Move 클라스 작성**
  - 상 하 좌 우 로 움직이는 4개의 메서드를 작성했다.
  - 좌 우 로 움직이는 메서드는 

```java
for (int j = 0; j < inArr.length; j++) {
        if(inArr[j] == 3 && inArr[j+1] == 5){
            map[i][j] = map[i][j+1]; // 2단계는 어차피 공백으로만 이동하니 map[i][j] = 5; 라고 둬도 무방
            map[i][j+1] = 3;
            System.out.println("D: 오른쪽으로 이동합니다.");
            System.out.println();
            break Loop1; // 2중 반복문을 한번에 탈출시킨다.
```
```java
for (int j = 0; j < inArr.length; j++) {
        if(inArr[j] == 3 && inArr[j-1] == 5){
            map[i][j] = map[i][j-1];
            map[i][j-1] = 3;
            System.out.println("A: 왼쪽으로 이동합니다.");
            System.out.println();
            break Loop1;
```
- 다음과 같이 플레이어의 자리에 공백 즉 5를 넣고 플레이어가 이동한 자리에는 플레이어 즉 3을 넣어 스위칭 하는 방식으로 구현했다.
- 2중 for 문에서 한번에 탈출하기 위해 for 문에 각각 Loop1, Loop2 라고 명명해 
break Loop1 을 통해 이동을 마쳤으면 전체 for문을 탈출하도록 구현했다.
- 상 하 로 움직이는 메서드는 

```java
for (int j = 0; j < inArr.length; j++) {
    if(inArr[j] == 3 && map[i-1][j] == 5){
        map[i][j] = map[i-1][j];
        map[i-1][j] = 3;
        System.out.println("W: 위쪽으로 이동합니다.");
        System.out.println();
        break Loop1;
```
```java
for (int j = 0; j < inArr.length; j++) {
    if(inArr[j] == 3 && map[i+1][j] == 5){
        map[i][j] = map[i+1][j];
        map[i+1][j] = 3;
        System.out.println("S: 아래쪽으로 이동합니다.");
        System.out.println();
        break Loop1;
```
- 다음과 같이 map[ i+1 ][ j ] 를 통해 위 아래줄을 스위치 시켜주었다.
- 상 하 좌 우 모든 메서드는 모두 int 타입의 2차원 배열에서 동작하고 마지막에 reconvert 메서드를 통해
다시 String 타입의 2차원 배열로 변경시켜주어 리턴시켰다.
- 상 하 좌 우 모두 공백이 아닌 다른 곳으로 이동하려고 할 경우 경고문을 띄어주고 바로 이전 상태의 Map을 
띄어주었다.

**Move 클라스**
```java
public class Move {
    MapReconvert reconvert = new MapReconvert();

    public String[][] moveRight(int[][] map){
        Loop1:
        for (int i = 0; i < map.length; i++) {
            int[] inArr = map[i];
            Loop2:
            for (int j = 0; j < inArr.length; j++) {
                if(inArr[j] == 3 && inArr[j+1] == 5){
                    map[i][j] = map[i][j+1]; // 2단계는 어차피 공백으로만 이동하니 map[i][j] = 5; 라고 둬도 무방
                    map[i][j+1] = 3;
                    System.out.println("D: 오른쪽으로 이동합니다.");
                    System.out.println();
                    break Loop1; // 2중 반복문을 한번에 탈출시킨다.
                }if(inArr[j] == 3 && inArr[j+1] != 5){
                    System.out.println("D: (경고!) 해당 명령을 수행할 수 없습니다!");
                    System.out.println();
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
                    map[i][j] = map[i][j-1];
                    map[i][j-1] = 3;
                    System.out.println("A: 왼쪽으로 이동합니다.");
                    System.out.println();
                    break Loop1;
                }if(inArr[j] == 3 && inArr[j-1] != 5){
                    System.out.println("A: (경고!) 해당 명령을 수행할 수 없습니다!");
                    System.out.println();
                    break Loop1;
                }
            }
        }
        // 왼쪽 이동이 끝났으면 다시 int[][] 타입의 map 을 String[][] 으로 return 시켜준다.
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
                    map[i][j] = map[i-1][j];
                    map[i-1][j] = 3;
                    System.out.println("W: 위쪽으로 이동합니다.");
                    System.out.println();
                    break Loop1;
                }if(inArr[j] == 3 && map[i-1][j] != 5){
                    System.out.println("W: (경고!) 해당 명령을 수행할 수 없습니다!");
                    System.out.println();
                    break Loop1;
                }
            }
        }
        // 왼쪽 이동이 끝났으면 다시 int[][] 타입의 map 을 String[][] 으로 return 시켜준다.
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
                    map[i][j] = map[i+1][j];
                    map[i+1][j] = 3;
                    System.out.println("S: 아래쪽으로 이동합니다.");
                    System.out.println();
                    break Loop1;
                }if(inArr[j] == 3 && map[i+1][j] != 5){
                    System.out.println("S: (경고!) 해당 명령을 수행할 수 없습니다!");
                    System.out.println();
                    break Loop1;
                }
            }
        }
        // 왼쪽 이동이 끝났으면 다시 int[][] 타입의 map 을 String[][] 으로 return 시켜준다.
        String[][] moveDown = reconvert.reconvert(map);
        return moveDown;
    }
}
```

</br>

- **Play 클라스 작성**
  - Input 클라스에서 입력받은 리스트에 담긴 command 즉 입력을 보고 Move 클라스의 상하좌우 움직임이
  동작하는 클라스이다.
  - 입력값과 Stage2 를 모두 받아 동작하기 때문에 파라미터로 List < String > 과 2차원 int 배열 2개를 받는다.
  - 또한 상 하 좌 우 (w a s d) 를 제외한 다른 입력을 받으면 경고문을 띄워주고 바로 이전 상태의 Map 을 출력해준다.

**Play 클라스**
```java
import java.util.List;

public class Play {
    Show show = new Show();
    Move move = new Move();
    MapReconvert mapReconvert = new MapReconvert();

    public String[][] playGame(List<String> input, int[][] secondStage){
        int[][] map = secondStage;
        String[][] finalMap = mapReconvert.reconvert(map);
        for (int i = 0; i < input.size(); i++) {
            char command = input.get(i).charAt(0);
            if(command == 'a'){
                finalMap =  move.moveLeft(secondStage);
                show.showMap(finalMap);
                System.out.println();
                continue;
            }
            if(command == 'd'){
                finalMap =  move.moveRight(secondStage);
                show.showMap(finalMap);
                System.out.println();
                continue;
            }
            if(command == 'w'){
                finalMap =  move.moveUp(secondStage);
                show.showMap(finalMap);
                System.out.println();
                continue;
            }
            if(command == 's'){
                finalMap =  move.moveDown(secondStage);
                show.showMap(finalMap);
                System.out.println();
                continue;
            } else {
                char upper = Character.toUpperCase(command); // char 를 대문자로 바꿔서 출력
                System.out.printf("%c: (경고!) 해당 명령을 수행할 수 없습니다.\n", upper);
                System.out.println();
                show.showMap(finalMap);
                System.out.println();
                continue;
            }
        }
        return finalMap;
    }
}
```

</br>

- **Show 클라스 작성**
  - 매번 맵을 보여주기 위해 Main 클라스에서 String 타입의 2차원 배열을 2중 for 문으로 찍어 보여주었는데
  좀더 Main 클라스를 간단히 하기 위해 따로 메서드를 구분해주었다.

```java
public class Show {
    public void showMap(String[][] map){
        for (int i = 0; i < map.length; i++) {
            String[] inArr = map[i];
            for (int j = 0; j < inArr.length; j++) {
                System.out.print(inArr[j] + "");
            }
            System.out.println(); // 한 줄이 끝나면 다음 줄로 넘어가기 위한 용도
        }
    }
}
```

</br>

- **PlayAgain 클라스 작성**
  - input 으로 입력받은 작업을 모두 수행한 뒤 게임을 다시 시작할지 말지를 선택하는 기능을 구현했다.
  - boolean 타입으로 리턴값을 지정하여 만약 q 를 제외한 다른 값을 입력하면 true 를 리턴해 게임을 다시 시작하고
  q를 입력하면 게임이 종료하도록 했다.

**PlayAgain 클라스**
```java
import java.util.Scanner;

public class PlayAgain {
  public boolean again(){
    System.out.println("다시 시작하시겠습니까? 다시 시작 : 아무키나 누르시오, 종료 : q");
    Scanner scanner = new Scanner(System.in);
    char answer = scanner.next().charAt(0);
    if(answer != 'q'){
      return true;
    }
    System.out.println("Bye~!");
    return false;
  }
}
```

</br>

- **Main2 클라스 작성**
  - 지금까지 구현한 클라스들을 모아 실제 동작을 수행하는 클라스이다.
  - boolean again = true; 를 지정해 게임의 재시작 여부를 PlayAgain 클라스로 동작할 수 있도록 하였다.

**Main2 클라스**
```java
import Step1.MapConvert;
import Step1.MapList;

import java.util.List;

public class Main2 {
  public static void main(String[] args) {
    MapList mapList = new MapList();
    MapConvert mapConvert = new MapConvert();
    Input input = new Input();
    Play play = new Play();
    PlayAgain playAgain = new PlayAgain();

    int[][] secondStage = mapConvert.convert(mapList.stage2());
    boolean again = true;
    while (again){
      List<String> command = input.input();
      play.playGame(command, secondStage);
      again = playAgain.again();
    }
  }
}
```

- 결과
  - [결과 출력 사진](https://user-images.githubusercontent.com/79504043/145018538-4aff19bc-8378-42d8-b951-519552125f3f.png)

___
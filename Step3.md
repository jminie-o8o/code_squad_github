# 구현과정 상세 설명

## 2단계
- **MoveRight 클라스 작성**
    - 처음에는 FinalMove 라는 하나의 클라스 안에 플레이어의 움직임을 구현하려 했지만 완성하고 나니 
  코드가 400줄이 넘어가 상 하 좌 우 4개의 기능을 각각 클라스로 구분하였다.


- 
  - [x] 처음 시작시 Stage 1의 지도와 프롬프트가 표시된다
  - [x] 플레이어는 o를 밀어서 이동할 수 있지만 당길 수는 없다.
  - [x] o를 O 지점에 밀어 넣으면 0으로 변경된다.
  - [x] 플레이어는 O를 통과할 수 있다.
  - [x] 플레이어는 #을 통과할 수 없다.
  - [x] 0 상태의 o를 밀어내면 다시 o와 O로 분리된다.
  - [x] 플레이어가 움직일 때마다 턴수를 카운트한다.
  - [x] 상자가 두 개 연속으로 붙어있는 경우 밀 수 없다.
  - [x] r 명령 입력시 진행하고 있는 스테이지를 초기화 한다.
  - [x] 0(공이 들어있는 구멍) O(공이 없는 구멍) 이 연속으로 2개 붙어있는 경우 공을 옆으로 밀면 오른쪽으로 0이 이동된다.
  - [x] 모든 o를 O자리에 이동시키면 클리어 화면을 표시하고 다음 스테이지로 표시한다.
  - [x] 주어진 모든 스테이지를 클리어시 축하메시지를 출력하고 게임을 종료한다.

위 기능이 모두 작동하도록 구현하였다.  
기능은 모두 정상작동 하지만 2중 for 문에 2중 if 문까지 들어가 코드가 매우 복잡해졌다.  

**구현시 어려웠던 점**
- 소코반 게임은 플레이어가 O 즉 구멍위에 있다가 다른 곳으로 이동할 경우 다시 그곳에 구멍이 표시되어야 하는데
그것을 구현하는게 생각보다 시간이 걸렸다. 큰 틀은 int onTheHole 이라는 변수를 놓아 그것을 각 상황마다 체크해 
1이 되면 구멍위에 있는 상태고 0이 되면 구멍위에 있지 않은 상태로 나누어 구현하였다.

**MoveRight 클라스**
```java
import Step2.MapReconvert;

public class MoveRight {
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
                        onTheHole -= 1;
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
                            onTheHole -= 1;
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
                            onTheHole -= 1;
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
                            map[i][j+2] = 2;
                            onTheHole -= 1;
                            break Loop1;
                        }
                    }
                    if(inArr[j+2] == 1){
                        if(onTheHole == 0){
                            map[i][j] = 5;
                            map[i][j+1] = 3;
                            map[i][j+2] = 6;
                            onTheHole += 1; // 합쳐져 있는 공과 구멍에서 공을 밀어냈으므로 구멍 위로 올라가게 된다.
                            break Loop1;
                        }
                        if(onTheHole == 1){
                            map[i][j] = 1;
                            map[i][j+1] = 3;
                            map[i][j+2] = 6;
                            break Loop1;
                        }
                    }
                    else { // 공 뒤에 다른 공이나 벽이 있으면 그대로 for 문 탈출
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
}
```

<br>

- **FinalPlay 클라스 작성**
  - 위에서 작성한 Move 관련 메서드들이 실제로 동작하는 클라스이다.
  - 입력값을 받아 움직임 동작을 수행하기 때문에 Step2의 Play 클라스와 거의 흡사하다.

**FinalPlay 클라스**
```java
import Step2.MapReconvert;
import Step2.Show;

import java.util.List;

public class FinalPlay {
    Show show = new Show();
    MapReconvert mapReconvert = new MapReconvert();
    MoveRight moveRight = new MoveRight();
    MoveLeft moveLeft = new MoveLeft();
    MoveUp moveUp = new MoveUp();
    MoveDown moveDown = new MoveDown();

    public String[][] playGame(List<String> input, int[][] stage){
        int[][] map = stage;
        String[][] finalMap = mapReconvert.reconvert(map);
        for (int i = 0; i < input.size(); i++) {
            char command = input.get(i).charAt(0);
            if(command == 'd'){
                finalMap = moveRight.moveRight(stage);
                show.showMap(finalMap);
                System.out.println();
                continue;
            }
            if(command == 'a'){
                finalMap = moveLeft.moveLeft(stage);
                show.showMap(finalMap);
                System.out.println();
                continue;
            }
            if(command == 'w'){
                finalMap = moveUp.moveUp(stage);
                show.showMap(finalMap);
                System.out.println();
                continue;
            }
            if(command == 's'){
                finalMap = moveDown.moveDown(stage);
                show.showMap(finalMap);
                System.out.println();
                continue;
            } else {
                System.out.println("(경고!) 해당 명령을 수행할 수 없습니다.");
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

<br>

- **Check 클라스 작성**
  - 스테이지가 클리어 됐는지 확인하는 클라스이다.
  - 스테이지의 클리어 여부는 현재 맵에 o 즉 공이 존재하는가 여부로 판별하였다.
  - 따라서 String 타입의 2차원 배열을 파라미터로 받아서 쭉 훑으면서 o 즉 공의 숫자를 카운트한다.
  - 만약 count 의 결과값이 0 즉 공이 없다면 스테이지가 클리어 된 것이고, 0이 아니라면 클리어되지 않은 것이다.
  - 클리어 되었다면 false 를 리턴, 되지 않았다면 true 를 리턴한다. 뭔가 반대여야 자연스럽다고 생각할 수 있지만
  추후 Main 클라스에서 실제 동작시 while 에서 클리어 즉 false 로 탈출해야 하기 때문에 이렇게 구현했다. (추가 - 생각해보니 반대여도 상관이 없다.)

**Check 클라스**
```java
public class Check {
    public boolean stageCheck(String[][] map){
        int count = 0;
        for (int i = 0; i < map.length; i++) {
            String[] inArr = map[i];
            for (int j = 0; j < inArr.length; j++) {
                if(inArr[j].charAt(0) == 'o'){
                    count += 1;
                }
            }
        }
        if(count == 0){
            return false; // 공의 개수가 0개 이므로 스테이지 클리어
        }
        return true;
    }
}
```

<br>

-**IntMapLists 클라스 및 StringMapLists 작성**
  - 결국 txt 파일에서 맵을 문자열로 전환하는 기능은 구현하지 못했기에 Step1 때 만들었던 MapList 에 Stage5 까지 직접 
2차원 배열로 맵을 만들었다.
  - Main 클라스에서 동작시 각 Map 들을 int 타입과 String 타입으로 리스트에 넣어줘서 하나씩 빼주며 진행해야 하기에 
두 클라스에 각각 List<int[ ][ ]> 와 List<String[ ][ ]> 타입으로 return 하는 메서드를 만들었다.
  - 추후 txt 파일에서 맵을 추출하는 기능 리팩토링...

**IntMapLists 클라스**
```java
import java.util.ArrayList;
import java.util.List;

public class IntMapLists {
    MapList mapList = new MapList();
    MapConvert mapConvert = new MapConvert();


    public List<int[][]> intMapLists(){
        int[][] firstStage = mapConvert.convert(mapList.stage1());
        int[][] secondStage = mapConvert.convert(mapList.stage2());
        int[][] thirdStage = mapConvert.convert(mapList.stage3());
        int[][] fourthStage = mapConvert.convert(mapList.stage4());
        int[][] fifthStage = mapConvert.convert(mapList.stage5());

        List<int[][]> intMapLists = new ArrayList<>();
        intMapLists.add(firstStage);
        intMapLists.add(secondStage);
        intMapLists.add(thirdStage);
        intMapLists.add(fourthStage);
        intMapLists.add(fifthStage);

        return intMapLists;
    }
}
```

**StringMapLists 클라스**
```java
import Step1.MapList;
import java.util.ArrayList;
import java.util.List;

public class StringMapLists {
  MapList mapList = new MapList();

  public List<String[][]> stringMapLists(){
    List<String[][]> mapLists = new ArrayList<>();
    mapLists.add(mapList.stage1());
    mapLists.add(mapList.stage2());
    mapLists.add(mapList.stage3());
    mapLists.add(mapList.stage4());
    mapLists.add(mapList.stage5());

    return mapLists;
  }
}
```

<br>

- **Main3 클라스 작성**
  - 기능별로 나누어 놓았던 클라스들을 모아 실제 게임이 작동시키는 클라스이다.
  - for 문으로 stage1 ~ 5까지 맵을 가져와 구현시킨다.
  - while 문으로 Stage 를 클리어 했는지 확인한다. (boolean clear를 놓아 위에서 만든 check 메서드로 
  스테이지의 클리어 여부를 확인하고 클리어했으면 while 문을 탈출한다.)
  - while 문 안에 if 문을 놓아 만약 입력값으로 r 이 들어왔다면 진행중인 스테이지에서 게임을 재시작 하도록 구현했다.
  - int 타입의 count 를 놓아 움직임이 행해질 때마다 1씩 더해줘 턴 수를 세주어 클리어 하면 축하메세지와 함께
  출력해준다.

**Main3 클라스**
```java
import Step2.Input;
import Step2.Show;
import java.util.List;

public class Main3 {
    public static void main(String[] args) {
        Input input = new Input();
        Show show = new Show();
        FinalPlay finalPlay = new FinalPlay();
        Check check = new Check();
        IntMapLists intMapLists = new IntMapLists();
        StringMapLists stringMapLists = new StringMapLists();

        boolean clear = true;
        int count = 0;

        System.out.println("소코반의 세계에 오신 것을 환영합니다!");
        System.out.println("^오^");

        Loop1:
        for (int i = 0; i < stringMapLists.stringMapLists().size(); i++) {
            int[][] intMap = intMapLists.intMapLists().get(i);
            System.out.println();
            System.out.printf("Stage %d \n", i + 1);
            System.out.println();
            show.showMap(stringMapLists.stringMapLists().get(i));
            System.out.println();
            Loop2:
            while (clear) { // clear 가 false 가 되어야 클리어 한 것 -> 그래야 이 while 문을 탈출하므로
                List<String> command = input.input();
                if(command.get(0).charAt(0) == 'r'){
                    intMapLists.intMapLists().get(i);
                    i -= 1;
                    continue Loop1; // r을 누른다면 다시 진행중인 스테이지를 시작한다.
                }
                String[][] map = finalPlay.playGame(command, intMap);
                clear = check.stageCheck(map); // Stage 를 클리어 했는지 여부를 확인
                count += 1;
            }
            System.out.printf("빠밤! Stage %d 클리어!\n", i + 1);
            System.out.println("턴수: " + count);
            count = 0;
            clear = true;
        }
        System.out.println();
        System.out.println("전체 게임을 클리어하셨습니다!!!");
        System.out.println("축하드립니다!");
    }
}
```

<br>

- **소코반 시연 영상**
  - [시연 영상 보러가기](https://user-images.githubusercontent.com/79504043/145201529-714d7847-3f22-466f-addb-57cad3ac0f20.mp4)


___
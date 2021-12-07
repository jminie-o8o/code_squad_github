package Step1;

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

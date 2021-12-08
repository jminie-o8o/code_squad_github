package Step3;

import Step1.MapConvert;
import Step1.MapList;

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

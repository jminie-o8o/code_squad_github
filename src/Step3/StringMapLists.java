package Step3;

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

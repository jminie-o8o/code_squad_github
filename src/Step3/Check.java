package Step3;

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

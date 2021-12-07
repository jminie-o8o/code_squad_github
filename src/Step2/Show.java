package Step2;

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

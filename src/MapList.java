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
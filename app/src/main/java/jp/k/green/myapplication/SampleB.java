package jp.k.green.myapplication;

public class SampleB {

    public  String getName(Integer id) {
        String name = null;
        if (id == 1) {
            name = "test1";
        } else if (id == 2) {
            name = "test2";
        } else {
            name = "other";
        }
        return name;
    }
    static public int getSample() {
        return 1;
    }
}

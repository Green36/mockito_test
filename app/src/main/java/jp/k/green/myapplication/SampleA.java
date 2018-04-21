package jp.k.green.myapplication;

public class SampleA {

    private SampleB sampleB = new SampleB();

    public String createName() {
        String ret = sampleB.getName(SampleB.getSample());
        return ret;
    }
}
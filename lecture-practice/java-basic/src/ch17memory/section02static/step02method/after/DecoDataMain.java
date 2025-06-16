package ch17memory.section02static.step02method.after;

import static ch17memory.section02static.step02method.after.DecoData.*;         // static import

public class DecoDataMain {
    public static void main(String[] args) {

        // static import
        staticCall1();

        DecoData decoData = new DecoData();
        decoData.instanceCall();
    }
}

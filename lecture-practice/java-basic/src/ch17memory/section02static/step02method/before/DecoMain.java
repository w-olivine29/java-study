package ch17memory.section02static.step02method.before;

public class DecoMain {
    public static void main(String[] args) {
        String str = "Java";

        // 단순히 기능만 사용할 건데 사용하지 않을 인스턴스를 생성해야한다. (다른 곳에서 사용할때도 매번 인스턴스를 생성해야함)
        DecoUtil decoUtil = new DecoUtil();
        String decoratedStr = decoUtil.decorateStr(str);

        System.out.println("before: " + str);
        System.out.println("after: " + decoratedStr);
    }

}

package ch17memory.section02static.step02method.after;


public class DecoMain {
    public static void main(String[] args) {
        String str = "Java";

        // 인스턴스 생성 없이 바로 접근
        String decoratedStr = DecoUtil.decorateStr(str);

        System.out.println("before: " + str);
        System.out.println("after: " + decoratedStr);
    }

}

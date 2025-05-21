package ch03operator;

public class Operator06Logical {
    public static void main(String[] args) {

        System.out.println(" ==== && 연산 (and) ====================");
        System.out.println(true && true); //true
        System.out.println(true && false); //false
        System.out.println(false && false); //false

        System.out.println(" ==== || 연산 (or) ====================");
        System.out.println(true || true); //true
        System.out.println(true || false); //true
        System.out.println(false || false); //false

        System.out.println(" ==== ! 연산 ====================");
        System.out.println(!true); //false
        System.out.println(!false); //true

        System.out.println("=====================================");
        boolean b1 = true;
        boolean b2 = false;

        System.out.println("b1 && b2 -> " + (b1 && b2) ); //false
        System.out.println("b1 || b2 -> " + (b1 || b2) ); //true
        System.out.println("!b1 -> " + !b1 ); //false
        System.out.println("!b2 -> " + !b2 ); //true

        System.out.println("(10 < 1) || b1 -> " + ((10 < 1) || b1)); // true
        System.out.println("!(10 < 1) || b1 -> " + (!(10 < 1) && b1)); // true
    }
}

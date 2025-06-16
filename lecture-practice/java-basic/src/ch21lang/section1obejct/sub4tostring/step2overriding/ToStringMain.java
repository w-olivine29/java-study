package ch21lang.section1obejct.sub4tostring.step2overriding;

public class ToStringMain {
    public static void main(String[] args) {

        Car car = new Car("morning");
        Cat cat1 = new Cat("kinnyang", 8);
        Cat cat2 = new Cat("cheese", 3);

        System.out.println("1. 직접 toString 호출 ======================");
        System.out.println(car.toString()); // 패키지경로@4e50df2e
        System.out.println(cat1.toString()); // Cat{name='kinnyang', age=8}
        System.out.println(cat2.toString()); // Cat{name='cheese', age=3}

        System.out.println("\n2. print 내부에서 toString 호출 ======================");
        System.out.println(car); // 패키지경로@4e50df2e
        System.out.println(cat1); // Cat{name='kinnyang', age=8}
        System.out.println(cat2); // Cat{name='cheese', age=3}

        System.out.println("\n3. Object 다형성 활용 ======================");
        ObjectPrinter.print(car); // 패키지경로@4e50df2e
        ObjectPrinter.print(cat1); // Cat{name='kinnyang', age=8}
        ObjectPrinter.print(cat2); // Cat{name='cheese', age=3}

        // toString()재정의 후 참조값(16진수로 된 값)을 얻기 위해선?
        int hashCode = cat1.hashCode();
        System.out.println("hashCode: " + hashCode);
        System.out.println(Integer.toHexString(hashCode));

        // hashCode() 도 재정의했다면?
        int identityHashCode = System.identityHashCode(cat1);
        System.out.println("identityHashCode: " + identityHashCode);
        System.out.println(Integer.toHexString(hashCode));

        // 10진수인 해시코드을 16진수화
    }
}

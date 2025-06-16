package ch24nestedclasses.example.ex3;


public class OuterClass {

    public void myMethod() {

        class LocalClass {
            void hello() {
                System.out.println("hello");
            }
        }

        LocalClass localClass = new LocalClass();
        localClass.hello();
    }

}

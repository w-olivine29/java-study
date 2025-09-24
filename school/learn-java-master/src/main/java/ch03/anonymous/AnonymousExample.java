package ch03.anonymous;

public class AnonymousExample {
    public static void main(String[] args) {

        Animal cat = new Cat();
        Animal dog = new Dog();

        Animal crow = new Animal(){
            @Override
            public void sound() {
                System.out.println("까악까악");
                fly();
            }
            
            // 해당 메서드는 외부에서 사용 불가
            public void fly() {
                System.out.println("까마귀가 날아갑니다. 푸드덕-");
            }
        };

        cat.sound();
        dog.sound();
        crow.sound();
        

    }
}

package ch26generic.section3method.sub4wildcard;

import ch26generic.section3method.Animal;
import ch26generic.section3method.Cat;

public class WildCardMain2 {
    public static void main(String[] args) {

        Box<Cat> catBox = new Box<>();
        catBox.set(new Cat("에멘탈치즈", 6));


        Cat resultCat1 = WildCardEx.printAndReturn(catBox);
        
        // 와일드카드 메서드 (반환타입이 상한클래스로 고정되어 있어 Cat으로 직접 받지 못한다)
        Animal animal = WildCardEx.printAndReturnWildcard(catBox);
        Cat resultCat2 = (Cat) WildCardEx.printAndReturnWildcard(catBox);

    }
}

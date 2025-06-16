package ch26generic.section3method.sub4wildcard;

import ch26generic.section3method.*;

public class WildCardMain1 {
    public static void main(String[] args) {

        Box<Cat> catBox = new Box<>();

        catBox.set(new Cat("에멘탈치즈", 6));

        WildCardEx.printGenericV1(catBox);
        WildCardEx.printWildCardV1(catBox);

        WildCardEx.printGenericV2(catBox);
        WildCardEx.printWildCardV2(catBox);


        WildCardEx.printAndReturn(catBox);
        WildCardEx.printAndReturnWildcard(catBox);


    }
}

package ch07annotation.step2definition;

import java.util.Arrays;

public class ElementDataMain {
    public static void main(String[] args) {
        Class<ElementData1> annoClass = ElementData1.class;
        AnnoElement annotation = annoClass.getAnnotation(AnnoElement.class);

        String value = annotation.value();
        System.out.println("value = " + value); //data

        int count = annotation.count(); //10
        System.out.println("count = " + count);

        String[] tags = annotation.tags();
        System.out.println(Arrays.toString(tags)); //[tag1, tag2]
    }
}

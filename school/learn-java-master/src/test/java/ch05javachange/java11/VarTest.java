package ch05javachange.java11;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

// var의 실제 도입 버전은 10
class VarTest {
    
    @Test
    void varTest() {
        
        //기본형 타입, String
        var intVar = 1;
        var longVar = 1L;
        var booleanVar = true;
        var stringVar = "hello";

        assertThat(intVar).isInstanceOf(Integer.class);
        assertThat(longVar).isInstanceOf(Long.class);
        assertThat(booleanVar).isInstanceOf(Boolean.class);
        assertThat(stringVar).isInstanceOf(String.class);

        // 참조형 타입
        var listVar = new ArrayList<String>();
        var mapVar = new HashMap<String, String>();

        assertThat(listVar).isInstanceOf(ArrayList.class);
        assertThat(mapVar).isInstanceOf(HashMap.class);

        var mouse = new Mouse("inote", 20000);
        assertThat(mouse).isInstanceOf(Mouse.class);
    }

    record Mouse(String name, int price) {

    }
}
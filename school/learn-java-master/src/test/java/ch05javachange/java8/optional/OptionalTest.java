package ch05javachange.java8.optional;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OptionalTest {
    @Test
    void create() {

        Optional<String> optional = Optional.ofNullable("hello");
        assertThat(optional.isPresent()).isTrue();

        System.out.println(optional.get());

        Optional<String> optional2 = Optional.of("hello2");
        assertThat(optional2.isPresent()).isTrue();

        System.out.println(optional2.get());

        Optional<String> optional3 = Optional.ofNullable(null);
        assertThat(optional3.isPresent()).isFalse();

        //System.out.println(optional3.get()); //NoSuchElementException: No value present

        Optional<String> optional4 = Optional.empty();
        assertThat(optional4.isPresent()).isFalse();
    }

    @Test
    void orElse() {
        // orElse
        Optional<String> optional = Optional.ofNullable("hello");
        assertThat(optional.orElse("default")).isEqualTo("hello");
        System.out.println(optional.orElse("default"));

        Optional<String> optional2 = Optional.ofNullable(null);
        assertThat(optional2.orElse("default")).isEqualTo("default");
        System.out.println(optional2.orElse("default"));
    }

    @Test
    void orElseThrow() {
        // orElseThrow
        Optional<String> optional = Optional.ofNullable("hello");
        assertThat(optional.orElseThrow()).isEqualTo("hello");
        System.out.println(optional.orElseThrow());

        Optional<String> optional2 = Optional.empty();
        assertThatThrownBy(() -> optional2.orElseThrow(IllegalStateException::new))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void map(){
        // map
        Optional<String> optional = Optional.ofNullable("hello");
        assertThat(optional.map(String::toUpperCase).orElse("default")).isEqualTo("HELLO");
        System.out.println(optional.map(String::toUpperCase).orElse("default"));

        Optional<String> optional2 = Optional.empty();
        assertThat(optional2.map(String::toUpperCase).orElse("default")).isEqualTo("default");
        System.out.println(optional2.map(String::toUpperCase).orElse("default"));
    }

    @Test
    void ifPresent() {
        // ifPresent
        Optional<String> optional = Optional.ofNullable("hello");
        optional.ifPresent(s -> System.out.println(s.toUpperCase()));

        Optional<String> optional2 = Optional.empty();
        optional2.ifPresent(s -> System.out.println(s.toUpperCase()));
    }
}
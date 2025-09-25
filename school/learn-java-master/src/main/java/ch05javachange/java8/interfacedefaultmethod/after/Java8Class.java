package ch05javachange.java8.interfacedefaultmethod.after;

import java.time.ZonedDateTime;

public class Java8Class implements Java8Interface {

    @Override
    public String getTime() {
        return ZonedDateTime.now(java.time.ZoneId.of("Asia/Seoul")).toString();
    }
}

package annotation.task;

import java.util.ArrayList;
import java.util.List;

import static annotation.task.ParameterLogger.logParams;

public class CustomLoggingMain {
    public static void main(String[] args) {
        TaskClass taskInstance = new TaskClass();

        logParams(taskInstance, "callMethod");
        logParams(taskInstance, "callMethod", 1);
        logParams(taskInstance, "callMethod", 1, 2);
        logParams(taskInstance, "callMethodNotAnnotation");

        System.out.println();

        Object returnValue1 = logParams(taskInstance, "callMethodReturnList", new ArrayList<>());
        Object returnValue2 = logParams(taskInstance, "callMethodReturnList", List.of(1,2,3));

        System.out.println("returnValue1 = " + returnValue1);
        System.out.println("returnValue2 = " + returnValue2);
    }
}

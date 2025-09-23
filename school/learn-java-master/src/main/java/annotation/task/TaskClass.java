package annotation.task;

import java.util.List;

public class TaskClass {

    @ParamLogger
    public void callMethod() {
        System.out.println("TaskClass.callMethod() 호출");

    }
    @ParamLogger
    public void callMethod(int num) {
        System.out.println("TaskClass.callMethod(int num) 호출");
    }
    @ParamLogger
    public void callMethod(int num1, int num2) {
        System.out.println("TaskClass.callMethod(int num1, int num2)  호출");
    }

    public void callMethodNotAnnotation() {
        System.out.println("TaskClass.callMethodNotAnnotation() 호출");
    }

    @ParamLogger
    public List<Integer> callMethodReturnList(List<Integer> list){
        System.out.println("TaskClass.callMethodReturnList(List<Integer> list) 호출");
        return list;
    }
}

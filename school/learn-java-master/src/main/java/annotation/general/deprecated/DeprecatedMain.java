package annotation.general.deprecated;

public class DeprecatedMain {
    public static void main(String[] args) {

        OldLibrary oldLibrary = new OldLibrary();
        oldLibrary.printMessage(); // IDE 에서 경고 표시를 해주고 'printMessage()' is deprecated 를 띄워줌

        NewLibrary newLibrary = new NewLibrary();
        newLibrary.printMessage();
    }
}

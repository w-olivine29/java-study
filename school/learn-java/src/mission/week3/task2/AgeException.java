package mission.week3.task2;


// 41기 유도경
public class AgeException extends RuntimeException {

    public AgeException(String message) {
        super(message);
    }

    static class UnderAgeException extends AgeException {

        public UnderAgeException(String message) {
            super(message);
        }
    }

    static class OverAgeException extends AgeException {
        public OverAgeException(String message) {
            super(message);
        }
    }
}

package ch09array;

public class Array1_1 {
    public static void main(String[] args) {
        int[] students; // 배열 변수 선언
        students = new int[5]; // 길이가 5인 배열 (데이터를 5개 넣을 수 있음)

        // 배열은 0부터 시작
        // [인덱스번호]를 통해 접근
        students[0] = 10;
        students[1] = 20;
        students[2] = 30;
        students[3] = 40;
        students[4] = 50;
        //students[5] = 50; // ArrayIndexOutOfBoundsException  (Index 5 out of bounds for length 5)

        for (int i = 0; i < students.length; i++) {
            System.out.println((i + 1) + "번 학생: " + students[i]);
        }

        System.out.println(students);
        //[I@506e1b77 -> [I 는 int형 배열을 뜻함, 뒷부분은 참조값 (메모리의 값을 16진수로 표현한 것)
    }
}

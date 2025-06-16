package ch27collection.section9iterationsorting.sub2sorting.step1array.my;

public class MyUser implements Comparable<MyUser>{

    private String name;
    private int yearOfBirth;

    public MyUser(String name, int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "name='" + name + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }

    @Override
    public int compareTo(MyUser o) {
        int result = 0;
        if (this.yearOfBirth < o.yearOfBirth) {
            result = -1;
        }else if(this.yearOfBirth > o.yearOfBirth){
            result  = 1;
        }else { //나이가 같다면 이름 가나다순
            result = this.name.compareTo(o.name); //String 클래스에서 Comparable를 구현했기때문에 사용가능
        }
        return result;
    }
}

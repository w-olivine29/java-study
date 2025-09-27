package ch06designpattern.task.model.Club;

public class DefaultClub implements Club {

    private String name;
//    private static List<Student> members;


    public DefaultClub(String name) {
        this.name = name;
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder("동아리 이름: " + name);
//        sb.append("동아리 회원 수:").append(members.size());
//        members.forEach(student -> sb.append(student.getInfo()));

        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public String getMembers(){

        StringBuilder sb = new StringBuilder();
//        members.forEach(student -> sb.append(student.getInfo()));

        return sb.toString();
    }

}


package mission.week2.optionaltask.task2;

//41기 유도경
public class Candidate {

    private int number;
    private String name;

    private int voteCount;


    public Candidate(int number, String name) {
        this.number = number;
        this.name = name;
    }

    // 득표
    public void poll() {
        voteCount++;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getVoteCount() {
        return voteCount;
    }
}

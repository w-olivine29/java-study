package ch26generic.example.ex3;

/* 문제3 - 준비
게임 속 캐릭터를 클래스로 만들자
ClassUnit은 유닛들의 부모 클래스
    - Sorcerer, Warrior, Hunter , Assassin 를 만들자
*/
public class ClassUnit {
    private String name;

    private int hp;
    private int mp;
    private int stamina;

    public ClassUnit(String name, int hp, int mp, int stamina) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.stamina = stamina;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }

    public int getStamina() {
        return stamina;
    }

    @Override
    public String toString() {
        return "ClassUnit{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", mp=" + mp +
                ", stamina=" + stamina +
                '}';
    }
}

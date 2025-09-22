package mission.week3.optionaltask.task1lotto;


// 41기 유도경
public class LottoProgram {

    private final LottoService service;

    public LottoProgram(LottoService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        LottoProgram lotto = new LottoProgram(new LottoService());

        int participateNumber = 5;

        try {
            for (int i = 0; i < participateNumber; i++) {
                lotto.service.joinLotto();
            }

            lotto.service.totalResultProcess();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

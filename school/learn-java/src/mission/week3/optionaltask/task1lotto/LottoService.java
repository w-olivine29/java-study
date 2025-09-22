package mission.week3.optionaltask.task1lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

// 41기 유도경
import static mission.week3.optionaltask.task1lotto.LottoGenerator.generate;

public class LottoService {

    private final LottoInputHandler inputHandler;
    private final LottoResultPrinter resultPrinter;
    private Lotto winningNumber;
    private final HashMap<String, LottoUser> users;


    public LottoService() {
        this.inputHandler = new LottoInputHandler(new Scanner(System.in));
        this.users = new HashMap<>();
        this.resultPrinter = new LottoResultPrinter();
    }

    public void joinLotto() {
        LottoUser lottoUser = new LottoUser();
        users.put(lottoUser.getUserID(), lottoUser);

        lottoUser.setLottos(generate(inputHandler.inputPurchaseCount()));
    }

    public void totalResultProcess() throws Exception {
        setWinningNumber();
        calculateAllMatchResults();
        resultPrinter.printTotalResults(users, winningNumber);
        inputHandler.close();
    }


    public void setWinningNumber() {
        this.winningNumber = new Lotto(generate());
    }

    private void calculateAllMatchResults() {
        //맞춘 번호 카운트용
        HashSet<Integer> winningNumberSet =
                (HashSet<Integer>) Arrays.stream(winningNumber.getSelectNumbers()) //IntStream
                        .boxed() //Stream<Integer>
                        .collect(Collectors.toSet());

        for (LottoUser user : users.values()) {
            user.getLottos()
                    .forEach(lotto -> lotto.setMatchCount(winningNumberSet));
        }
    }
}

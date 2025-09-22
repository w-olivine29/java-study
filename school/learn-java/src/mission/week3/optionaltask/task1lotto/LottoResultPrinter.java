package mission.week3.optionaltask.task1lotto;

import java.util.HashMap;
import java.util.List;

// 41기 유도경
public class LottoResultPrinter {


    public void printTotalResults(HashMap<String, LottoUser> users, Lotto winningNumber) {
        System.out.println("[로또 발표]");
        System.out.printf("%c   %s\n\n",
                ' ', getLottoNumberAsString(winningNumber));

        for (LottoUser user : users.values()) {
            printResult(user);
        }
    }


    public void printResult(LottoUser user) {
        System.out.printf("[%s 로또 결과]\n", user.getUserID());

        int sequence = 'A';
        List<Lotto> lottos = user.getLottos();
        for (int i = 0; i < lottos.size(); i++) {
            System.out.printf("%c   %s => %d개 일치\n",
                    (char) sequence++,
                    getLottoNumberAsString(lottos.get(i)),
                    lottos.get(i).getMatchCount()
            );
        }
        System.out.println();
    }

    private String getLottoNumberAsString(Lotto lotto) {

        int[] lottoNum = lotto.getSelectNumbers();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < lottoNum.length; i++) {
            sb.append(String.format("%02d", lottoNum[i]));
            if (i < (lottoNum.length - 1)) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

}

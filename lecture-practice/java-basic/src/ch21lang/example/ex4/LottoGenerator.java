package ch21lang.example.ex4;

import java.util.Random;


public class LottoGenerator {

    private final Random random;

    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;
    private static final int LOTTO_SIZE = 6;

    private final LottoTicket[] tickets;

    public LottoGenerator(Random random, int number) {
        this.random = random;
        tickets = new LottoTicket[number];
    }

    public void printLottoTickets() {
        for (int i = 0; i < tickets.length; i++) {
            System.out.printf("[%d] %s\n", (i + 1), tickets[i]);
        }
    }

    public void generate() {
        for (int i = 0; i < tickets.length; i++) {
            tickets[i] = generateTicket();
        }
    }

    private LottoTicket generateTicket() {
        int[] lotto = new int[LOTTO_SIZE];

        for (int i = 0; i < 6; i++) {
            lotto[i] = random.nextInt(LOTTO_MIN, LOTTO_MAX + 1);
            for (int j = 0; j < i; j++) {
                while (lotto[i] == lotto[j]) {
                    lotto[i] = random.nextInt(LOTTO_MIN, LOTTO_MAX + 1);
                }
            }
        }
        return new LottoTicket(lotto);
    }

}

package mission.week2.optionaltask.task2;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//41기 유도경
public class ElectionVoteCountSimulation {


    private final Scanner scanner;
    private final Random random;
    private int totalVoteCount;

    private Candidate[] candidates;

    public ElectionVoteCountSimulation() {
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }

    public static void main(String[] args) {
        ElectionVoteCountSimulation simulation = new ElectionVoteCountSimulation();
        simulation.execute();
    }

    public void execute() {
        try (scanner) {
            inputTotalVote();
            inputCandidates();
            simulate();
        }

    }

    // 1표마다 중간결과 출력
    private void simulate() {
        for (int i = 1; i <= totalVoteCount; i++) {
            int selectedNumber = random.nextInt(0, candidates.length);
            candidates[selectedNumber].poll(); // 득표
            printVoteResults(i, selectedNumber);
        }

        // 당선인 출력
        List<Candidate> maxVoteCandidates = getMaxVoteCandidates();
        if (maxVoteCandidates.size() == 1) {
            System.out.printf("[투표결과] 당선인: %s (%d표)\n",
                    maxVoteCandidates.getFirst().getName(),
                    maxVoteCandidates.getFirst().getVoteCount());

        } else {
            System.out.println("[투표결과] 공동 최다 득표");

            for (Candidate candidate : maxVoteCandidates) {
                System.out.printf("%s (%d표)\n", candidate.getName(), candidate.getVoteCount());
            }
        }
    }

    private List<Candidate> getMaxVoteCandidates() {

        List<Candidate> maxVoteCandidates = new ArrayList<>();
        maxVoteCandidates.add(candidates[0]);

        for (int i = 1; i < candidates.length; i++) {
            if (maxVoteCandidates.getFirst().getVoteCount() < candidates[i].getVoteCount()) {
                maxVoteCandidates.clear();
                maxVoteCandidates.add(candidates[i]);

            } else if (maxVoteCandidates.getFirst().getVoteCount() == candidates[i].getVoteCount()) {
                maxVoteCandidates.add(candidates[i]);
            }
        }
        return maxVoteCandidates;
    }

    private void printVoteResults(int currentVoteNumber, int selectedNumber) {
        System.out.printf("[투표진행률]: %.2f, %d명 투표 => %s\n",
                currentVoteNumber / (double) totalVoteCount * 100, currentVoteNumber, candidates[selectedNumber].getName());

        for (Candidate candidate : candidates) {
            System.out.printf("[기호: %d] %s: %.2f (투표수: %d)\n",
                    candidate.getNumber(),
                    candidate.getName(),
                    (double) candidate.getVoteCount() / totalVoteCount * 100,
                    candidate.getVoteCount());
        }
        System.out.println();
    }

    private void inputTotalVote() {

        while (true) {
            try {
                System.out.print("총 진행할 투표수를 입력해 주세요: ");
                int count = scanner.nextInt();

                if (count < 1 || count > 10000) {
                    System.out.println("총 투표 수는 1 ~ 10000 사이 값으로 입력해주세요.");
                    continue;
                }

                totalVoteCount = count;
                break;
            } catch (Exception e) {
                System.out.println("제대로 된 정수를 입력해주세요.");
            } finally {
                scanner.nextLine();
            }
        }
    }

    private void inputCandidates() {
        inputCandidateCount();

        for (int i = 1; i <= candidates.length; i++) {
            inputCandidateName(i);
        }
    }

    private void inputCandidateCount() {
        while (true) {
            try {
                System.out.print("가상 선거를 진행할 후보자 인원을 입력해 주세요: ");

                int candidateCount = scanner.nextInt();

                if (candidateCount < 2 || candidateCount > 10) {
                    System.out.println("후보자 인원은 2~10명으로 입력해 주세요.");
                    continue;
                }
                candidates = new Candidate[candidateCount];
                break;

            } catch (Exception e) {
                System.out.println("제대로 된 정수를 입력해주세요.");
            } finally {
                scanner.nextLine(); // 버퍼 비우기
            }
        }
    }

    private void inputCandidateName(int candidateNumber) {

        String candidateName = "";
        while (true) {
            System.out.print((candidateNumber) + "번 째 후보자 이름을 입력해 주세요: ");
            candidateName = scanner.nextLine();

            if (validateCandidateName(candidateName)) {
                candidates[candidateNumber - 1] = new Candidate(candidateNumber, candidateName);
                return;
            }
        }
    }

    private boolean validateCandidateName(String name) {
        if (name.length() > 10) {
            System.out.println("후보자 이름은 10자 미만으로 입력해주세요.");
            return false;
        }
        return true;
    }
}

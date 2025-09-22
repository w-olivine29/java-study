package mission.week3.optionaltask.task2tax;

import java.util.InputMismatchException;
import java.util.Scanner;

import static mission.week3.optionaltask.task2tax.AnnualIncomeTaxCriteria.*;
import static mission.week3.optionaltask.task2tax.AnnualIncomeTaxPrinter.*;

//41기 유도경
public class AnnualIncomeTaxCalculator {

    public static void main(String[] args) {
        AnnualIncomeTaxCalculator calculator = new AnnualIncomeTaxCalculator();
        calculator.execute();
    }

    private final Scanner scanner;


    public AnnualIncomeTaxCalculator() {
        this.scanner = new Scanner(System.in);
    }

    public void execute() {

        try (scanner) {
            System.out.println("[과세금액 계산 프로그램]");
            long annualIncome = inputAnnualIncome();
            int applyIndex = getApplyIndex(annualIncome);

            printResult(getTaxRateResultTitle(), calculateByTaxRate(annualIncome, applyIndex));
            printResult(getDeductionResultTitle(), calculateByTaxDeduction(annualIncome, applyIndex));


        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("계산을 종료합니다.");
        }

    }


    // 세율에 의한 계산
    private long calculateByTaxRate(long annualIncome, int applyIndex) {

        long totalApplyTaxAmount = 0;
        for (int i = 0; i <= applyIndex; i++) {

            Long minTaxableAmount = TAXATION.get(i).get(0); //하한선 (초과)
            Long maxTaxableAmount = TAXATION.get(i).get(1); //상한선 (이하)

            long applyAmount = 0L; //세금계산에 적용될 금액 양
            long applyTax = 0L; // 계산된 세금

            if (i == applyIndex) { // 적용 기준에 돌입 시 계산에서 남은 금액을 적용금액으로 할당
                applyAmount = annualIncome;
            } else {
                applyAmount = maxTaxableAmount - minTaxableAmount;
            }
            annualIncome -= applyAmount; // 세금계산에 이용한 금액을 제한다.

            applyTax = (long) (applyAmount * (TAX_RATE.get(i) * 0.01));
            totalApplyTaxAmount += applyTax;

            printApplyTex(applyAmount, TAX_RATE.get(i), applyTax);
        }
        return totalApplyTaxAmount;
    }


    // 누진공제계산법
    private long calculateByTaxDeduction(long annualIncome, int applyIndex) {
        return (long) (annualIncome * (TAX_RATE.get(applyIndex) * 0.01)) - DEDUCTION.get(applyIndex);
    }


    private int getApplyIndex(long annualIncome) {

        for (int i = 0; i < TAXATION.size(); i++) {
            Long maxTaxableAmount = TAXATION.get(i).get(1);

            // 상한선 기준이 없을 때 (마지막 기준 적용)
            if (maxTaxableAmount == 0) {
                return TAXATION.size() - 1;
            }

            // 연소득이 특정 상한선 이하일때 해당 기준 적용
            if (maxTaxableAmount >= annualIncome) {
                return i;
            }
        }
        throw new RuntimeException(annualIncome + ": 해당 연소득을 적용할 세율 구간을 찾을 수 없습니다.");
    }


    private long inputAnnualIncome() {
        System.out.print("연소득을 입력해주세요: ");

        while (true) {
            try {
                long input = scanner.nextLong();

                if (input < 1) {
                    throw new InputMismatchException();
                }
                return input;

            } catch (InputMismatchException e) {
                System.out.println("제대로 된 정수값을 입력해주세요.");
            } finally {
                scanner.nextLine(); // 남은 개행문자 비우기
            }
        }
    }
}


package mission.week3.optionaltask.task2tax;

//41기 유도경
public class AnnualIncomeTaxPrinter {

    public static String getDeductionResultTitle() {
        return String.format("%-17s", "[누진공제 계산에 의한 세금]:");
    }

    public static String getTaxRateResultTitle() {
        return String.format("%-19s", "[세율에 의한 세금]: ");
    }

    // 기본출력
    public static void printApplyTex(long applyAmount, int taxRate, long applyTax) {
        printApplyTex(applyAmount, taxRate, applyTax, 12, 12);
    }

    public static void printApplyTex(long applyAmount, int taxRate, long applyTax, int applyAmountLength, int applyTaxLength) {

        String format = "%," + applyAmountLength + "d * %2d%% = %," + applyTaxLength + "d\n";
        System.out.printf(format, applyAmount, taxRate, applyTax);
    }

    // 기본출력
    public static void printResult(String title, long applyTotalTax) {
        printResult(title, applyTotalTax, 14);
    }

    public static void printResult(String title, long applyTotalTax, int applyTaxLength) {
        String format = "%," + applyTaxLength + "d\n";
        System.out.printf(title + format, applyTotalTax);
    }


}

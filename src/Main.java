import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
            printBonusDatesBetween(2010, 2015);
            printBonusDatesBetween(1900, 1900);
    }

    public static void printBonusDatesBetween(int fromYear, int toYear) {
        if (fromYear >= toYear)
            return;

        LocalDate fromDate = LocalDate.parse(fromYear+"-01-01");
        LocalDate toDate = LocalDate.parse(toYear+"-01-01");

        while (!fromDate.equals(toDate)) {
            String fromDateString = fromDate.toString().replace("-", "");
            int fromDateStringLength = fromDateString.length();

            for (var i = 0; i < fromDateStringLength / 2; i++) {
                if (fromDateString.charAt(i) == fromDateString.charAt(fromDateStringLength - (i + 1))) {
                    if (i + 1 == fromDateStringLength / 2)
                        System.out.println(fromDate);
                }
                else
                    break;
            }
            fromDate = fromDate.plusDays(1);
        }
    }
}

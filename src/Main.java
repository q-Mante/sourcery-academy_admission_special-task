import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        printBonusDatesBetween(0, 9);
        printBonusDatesBetween(0, 99);
        printBonusDatesBetween(0, 999);
        printBonusDatesBetween(0, 9999);
        printBonusDatesBetween(10, 99);
        printBonusDatesBetween(10, 999);
        printBonusDatesBetween(10, 9999);
        printBonusDatesBetween(100, 999);
        printBonusDatesBetween(100, 9999);
        printBonusDatesBetween(1000, 9999);
        printBonusDatesBetween(2010, 2015);
        printBonusDatesBetween(-1000, -100);
        printBonusDatesBetween(2010, 2010);
    }

    public static void printBonusDatesBetween(int fromYear, int toYear) {
        if (fromYear >= toYear || fromYear < 0)
            return;

        int fromSizeAdd = 4 - Integer.toString(fromYear).length();
        int toSizeAdd = 4 - Integer.toString(toYear).length();

        String fromParse = new String(new char[fromSizeAdd]).replace('\0', '0') + fromYear + "-01-01";
        String toParse = new String(new char[toSizeAdd]).replace('\0', '0') + toYear + "-01-01";

        LocalDate fromDate = LocalDate.parse(fromParse);
        LocalDate toDate = LocalDate.parse(toParse);

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
public class CalendarPrinter {
    private static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }
    private static int getDaysInMonth(int month, int year) {
        return switch (month) {
            case 2 ->
                    isLeapYear(year) ? 29 : 28;
            case 4, 6, 9, 11 ->
                    30;
            default ->
                    31;
        };
    }

    // Function to get the day for the start of the given month
    private static int getDayOfWeek(int month, int year) {
        int[] adjustment = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        if (month < 3) {
            year -= 1;
        }
        return (year + year / 4 - year / 100 + year / 400 + adjustment[month - 1] + 1) % 7;
    }

    public static void printCalendar(int month, int year) {
        if (month < 1 || month > 12 || year < 0) {
            System.out.println("Invalid Input!");
            return;
        }

        System.out.println(" Su Mo Tu We Th Fr Sa");

        int dayOfWeek = getDayOfWeek(month, year);

        for (int i = 0; i < dayOfWeek; i++) {
            System.out.print("   ");
        }

        int daysInMonth = getDaysInMonth(month, year);

        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%3d", day);
            if ((dayOfWeek + day) % 7 == 0 || day == daysInMonth) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        printCalendar(8, 2018);
    }
}

package hyeond0.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Calendar {
    private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] LEAP_MAX_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private HashMap <Date, PlanItem> planMap;

    public Calendar() {
        planMap = new HashMap<Date, PlanItem>();
    }
    public void registerPlan(String strDate, String plan) {
       PlanItem p = new PlanItem(strDate, plan);
       planMap.put(p.getDate(), p);
    }

    public PlanItem SearchPlan(String strDate){
        Date date = PlanItem.getDatefromString(strDate);
        return planMap.get(date);
    }
    public boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 != 0);
    }

    public int getMaxDaysOfMonth(int year, int month) {
        if (isLeapYear(year)) {
            return LEAP_MAX_DAYS[month - 1];
        } else {
            return MAX_DAYS[month - 1];
        }
    }

    public void printLine(int maxDay, int firstline, int count) {
        if (firstline != 0) {
            for (int i = 0; i < 7 - firstline; i++) {
                System.out.print("   ");
            }
        }
        for (int i = 1; i <= maxDay; i++) {
            System.out.printf("%3d", i);
            firstline--;
            if (firstline == 0) {
                System.out.println();
            }
            if (firstline < 0) {
                count--;
                if (count == 0) {
                    count = 7;
                    System.out.println();
                }
            }
        }
    }

    public void printCalendar(int year, int month, String weekday) {
        System.out.printf("    <<%4d년 %3d월>> \n", year, month);
        System.out.println("   일 월 화 수 목 금 토");
        System.out.println("----------------------");

        int maxDay = getMaxDaysOfMonth(year, month);
        int firstLine;
        int lineCount = 7;

        //get weekday automatically

        switch (weekday) {
            case "일":
                firstLine = 7;
                printLine(maxDay, firstLine, lineCount);
                break;
            case "월":
                firstLine = 6;
                printLine(maxDay, firstLine, lineCount);
                break;
            case "화":
                firstLine = 5;
                printLine(maxDay, firstLine, lineCount);
                break;
            case "수":
                firstLine = 4;
                printLine(maxDay, firstLine, lineCount);
                break;
            case "목":
                firstLine = 3;
                printLine(maxDay, firstLine, lineCount);
                break;
            case "금":
                firstLine = 2;
                printLine(maxDay, firstLine, lineCount);
                break;
            case "토":
                firstLine = 1;
                printLine(maxDay, firstLine, lineCount);
                break;
            default:
                break;
        }

//        for(int i = 1; i <= maxDay; i++) {
//            System.out.printf("%3d", i);
//            if (i%7==0) {
//                System.out.println();
//            }
//        }
        System.out.println();
//        System.out.println(" 1  2  3  4  5  6  7");
//        System.out.println(" 8  9 10 11 12 13 14");
//        System.out.println("15 16 17 18 19 20 21");
//        System.out.println("22 23 24 25 26 27 28");
//        if (MAX_DAYS[month-1] == 30) {
//            System.out.println("29 30");
//        }
//        else if (MAX_DAYS[month-1] == 31) {
//            System.out.println("29 30 31");
    }


}
//commit test
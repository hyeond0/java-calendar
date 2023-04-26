package hyeond0.Calendar;

import java.util.Scanner;

public class Prompt {
    public void runPrompt() {
        Scanner scanner = new Scanner(System.in);
        Calendar cal = new Calendar();
        int month;
        int year;
        while (true) {
            System.out.println("연도를 입력하세요.");
            System.out.println("YEAR> ");
            year = scanner.nextInt();
            System.out.println("월을 입력하세요.");
            System.out.print("MONTH> ");
            month = scanner.nextInt();
            if (month == -1) {
                break;
            }
            if (month > 12) {
                System.out.println("1월부터 12월까지만 입력 가능합니다.");
                continue;
            }
            cal.printCalendar(year, month);
        }
        System.out.println("Have a nice day!");
        scanner.close();
    }
    public static void main(String[] args) {
        //쉘 실행
        Prompt p = new Prompt();
        p.runPrompt();
    }
}

package hyeond0.Calendar;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {
    public void printMenu() {
        System.out.println("+------------------+");
        System.out.println("| 1. 일정 등륵");
        System.out.println("| 2. 일정 검색");
        System.out.println("| 3. 달력 보기");
        System.out.println("| h. 도움말 q. 종료");
        System.out.println("+------------------+");
        System.out.println("명령 (1, 2, 3, h, q)");
        System.out.print("> ");
    }

    public void runPrompt() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        Calendar cal = new Calendar();
        boolean quit = false;
        while (!quit) {
            printMenu();
            String command = scanner.next();
            switch (command) {
                case "1":
                    registerSchedule(scanner, cal);
                    break;
                case "2":
                    searchSchedule(scanner, cal);
                    break;
                case "3":
                    showCalendar(scanner, cal);
                    break;
                case "h":
                    printMenu();
                    break;
                case "q":
                    System.out.println("프로그램을 종료합니다.");
                    quit = true;
                    break;
                default:
                    break;
            }
        }
        scanner.close();
    }

    private void showCalendar(Scanner s, Calendar c) {
        System.out.println("연도를 입력하세요.");
        System.out.print("YEAR> ");
        int year = s.nextInt();
        System.out.println("월을 입력하세요.");
        System.out.print("MONTH> ");
        int month = s.nextInt();
        System.out.println("첫째 날의 요일을 입력하세요.");
        System.out.println("WEEKDAY> ");
        String weekday = s.next();
        c.printCalendar(year, month, weekday);
    }

    private void registerSchedule(Scanner s, Calendar c) throws ParseException {
//        System.out.println("[일정 등륵] 날짜를 입력하세요.");
//        System.out.print("> ");
//        String date = s.next();
//        s.nextLine();
//        System.out.println("일정을 입력하세요.");
//        System.out.print("> ");
//        String plan = s.nextLine();
//        h.put(date, plan);
//        System.out.println("일정이 등륵되었습니다.");
//        System.out.println(h);
        System.out.println("[새 일정 등록]");
        System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd).");
        System.out.print("> ");
        String date = s.next();
        s.nextLine(); //ignore one newline
        System.out.println("일정을 입력해 주세요.");
        System.out.print("> ");
        String text = s.nextLine();
        c.registerPlan(date, text);
    }
    private void searchSchedule(Scanner s, Calendar c) throws ParseException {
        System.out.println("[일정 검색] 날짜를 입력하세요.");
        System.out.print("> ");
        String date = s.next();
        String plan = c.SearchPlan(date);
        System.out.println("해당 날짜의 일정입니다.");
        System.out.println(plan);
    }



    public static void main(String[] args) throws ParseException {
        //쉘 실행
        Prompt p = new Prompt();
        p.runPrompt();
    }
}

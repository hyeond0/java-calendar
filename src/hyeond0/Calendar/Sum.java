package hyeond0.Calendar;

import java.util.Scanner;

public class Sum{
    public static void main(String[] args) {
        System.out.println("두 수를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();
        String[] numArray = result.split(" ");
        int sum = Integer.parseInt(numArray[0]) + Integer.parseInt(numArray[1]);
        System.out.println("두 수의 합은 " + sum +"입니다.");
//        System.out.printf("두 수의 합은 %d입니다.", Integer.parseInt(numArray[0]) + Integer.parseInt(numArray[1]));
        scanner.close();
    }
}

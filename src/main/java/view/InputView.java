package view;

import validation.InputValidation;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final InputValidation validation = new InputValidation();

    public static int wantFunction() {
        try {
            System.out.println("## 원하는 기능을 선택하세요.");
            int number = scanner.nextInt();
            validation.notNumberInRange(number);
            return number;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return wantFunction();
        }
    }

    public static int inputTableNumber() {
        try {
            System.out.println("## 테이블을 선택하세요.");
            int number = scanner.nextInt();
            validation.notNumberOfTable(number);
            return number;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return inputTableNumber();
        }
    }

    public static int inputMenuNumber() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        return scanner.nextInt();
    }

    public static int menuCount() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        return scanner.nextInt();
    }

    public static int inputPayNumber() {
        try {
            System.out.println("## 신용 카드는 1번, 현금은 2번");
            int number = scanner.nextInt();
            validation.notNumberOfOrder(number);
            return number;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return inputPayNumber();
        }
    }
}

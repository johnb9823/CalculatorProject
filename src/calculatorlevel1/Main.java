package calculatorlevel1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String exit = "exit";

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요 (종료하려면 'exit'을 입력하세요): ");
            String input1 = scanner.nextLine();
            //equalsIgnoreCase() 대소문자를 구별하지 않고 문자열을 비교하는 메서드
            if (input1.equalsIgnoreCase(exit)) {
                System.out.println("계산기를 종료합니다.");
                break;
                //플래그 사는 불리언 타입의 변수
            }
            int n1 = Integer.parseInt(input1);
            // 문자열을 정수로 변환

            System.out.print("두 번째 숫자를 입력하세요: ");
            String input2 = scanner.nextLine();
            if (input2.equalsIgnoreCase(exit)) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
            int n2 = Integer.parseInt(input2);
            // 문자열을 정수로 변환

            System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
            String op = scanner.nextLine();
            if (op.equalsIgnoreCase(exit)) {
                System.out.println("계산기를 종료합니다.");
                break;
            }

            switch (op) {
                case "+":
                    System.out.println(n1 + " + " + n2 + " = " + (n1 + n2));
                    break;
                case "-":
                    System.out.println(n1 + " - " + n2 + " = " + (n1 - n2));
                    break;
                case "*":
                    System.out.println(n1 + " * " + n2 + " = " + (n1 * n2));
                    break;
                case "/":
                    if (n2 == 0) {
                        System.out.println("분모는 0일 수 없습니다. 다른 값을 입력해주세요.");
                    } else {
                        System.out.println(n1 + " / " + n2 + " = " + (n1 / n2));
                    }
                    break;
                default:
                    System.out.println("잘못된 연산자입니다. 다시 입력해주세요.");
                    break;
            }
            System.out.println();  // 계산 후 공백 한 줄 추가
        }

    }
}

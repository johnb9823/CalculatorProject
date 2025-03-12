package calculatorlevel2;
import java.util.Scanner;

public class App {
    private static final String exit = "exit";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Calculator calculator = new Calculator();

        boolean flag = true;
        while (flag) {
            double n1 = 0;
            System.out.print("첫 번째 숫자를 입력하세요 (종료하려면 'exit'을 입력하세요): ");
            String firstNum = scanner.nextLine();
            if (exit.equalsIgnoreCase(firstNum)) {
                System.out.println("계산기를 종료합니다.");
                break;
            }

            //예외처리 추가 : 입력 값이 숫자가 아닐 겅우 다시 입력 받기
            try {
                n1 = Double.parseDouble(firstNum);
            } catch(NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
                continue; // 다시 반복문으로 돌아가서 입력받기
            }

            double n2 = 0;
            System.out.print("두 번째 숫자를 입력하세요: ");
            String secondNum = scanner.nextLine();
            if (exit.equalsIgnoreCase(secondNum)) {
                System.out.println("계산기를 종료합니다.");
                break;
            }

            try{
                n2 = Double.parseDouble(secondNum);
            }catch(NumberFormatException e){
                System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
                continue; // 다시 반복문으로 돌아가서 입력받기
            }


            System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
            String op = scanner.nextLine();
            if (exit.equalsIgnoreCase(op)) {
                System.out.println("계산기를 종료합니다.");
                break;
            }

            // 나누기 연산에서 분모가 0일 경우 다시 입력 받기
            while (op.equals("/") && n2 == 0) {
                System.out.println("분모는 0일 수 없습니다. 다른 값을 입력해주세요.");
                System.out.print("두 번째 숫자를 다시 입력하세요: ");
                secondNum = scanner.nextLine();
                try {
                    n2 = Double.parseDouble(secondNum);  // 새로운 값을 받음
                } catch (NumberFormatException e) {
                    System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                    continue;  // 다시 반복문으로 돌아가서 입력 받기
                }
            }


            // 연산 수행
            double result = calculator.calculate(n1, n2, op);
            System.out.println("계산 결과: " + result);
            System.out.println();  // 계산 후 공백 한 줄 추가

            // 연산 결과 출력
            System.out.println("저장된 연산 결과들:");
            for (Double res : calculator.getResults()) {
                System.out.println(res);
            }

            // 연산 결과 삭제 (예시로 가장 먼저 저장된 결과를 삭제)
            System.out.print("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (y/n): ");
            String deleteChoice = scanner.nextLine();
            if (deleteChoice.equalsIgnoreCase("y")) {
                calculator.removeFirstResult();
            }

        }

    }
}

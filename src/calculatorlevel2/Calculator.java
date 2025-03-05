package calculatorlevel2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    private List<Double> results = new ArrayList<>();

    // 사칙연산 메서드들
    public double add(double num1, double num2) {
        double result = num1 + num2;
        results.add(result);
        return result;
    }

    public double subtract(double num1, double num2) {
        double result = num1 - num2;
        results.add(result);
        return result;
    }

    public double multiply(double num1, double num2) {
        double result = num1 * num2;
        results.add(result);
        return result;
    }

    public double divide(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("분모는 0일 수 없습니다. 다른 값을 입력해주세요.");
            return Double.NaN;
        }
        double result = num1 / num2;
        results.add(result);
        return result;
    }

    // 계산 메서드 (연산 기호에 따라 사칙연산 수행)
    public double calculate(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return add(num1, num2);
            case "-":
                return subtract(num1, num2);
            case "*":
                return multiply(num1, num2);
            case "/":
                return divide(num1, num2);
            default:
                System.out.println("잘못된 연산자입니다. 다시 입력해주세요.");
                return Double.NaN;  // 잘못된 연산자일 때
        }
    }

    // 연산 결과 목록 반환
    public List<Double> getResults() {
        return results;
    }

    // 연산 결과 목록에서 가장 먼저 저장된 데이터를 삭제
    public void removeFirstResult() {
        if (!results.isEmpty()) {
            results.remove(0);
            System.out.println("가장 첫 번째 연산 결과를 삭제했습니다.");
        } else {
            System.out.println("삭제할 연산 결과가 없습니다.");
        }
    }
}

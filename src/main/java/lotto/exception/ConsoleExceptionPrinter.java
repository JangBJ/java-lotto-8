package lotto.exception;

public class ConsoleExceptionPrinter implements ExceptionPrinter {

    @Override
    public void print(String message) {
        if (message == null) {
            System.out.println("[ERROR] 알 수 없는 오류입니다.");
            return;
        }

        System.out.println("[ERROR] " + message);
    }
}

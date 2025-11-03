package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ConsoleExceptionPrinter;
import lotto.exception.ExceptionPrinter;
import lotto.parse.InputParser;

import java.util.List;

public class InputView {

    private static final String GET_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String GET_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String GET_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private final ExceptionPrinter exceptionPrinter;

    public InputView() {
        this.exceptionPrinter = new ConsoleExceptionPrinter();
    }

    public InputView(ExceptionPrinter exceptionPrinter) {
        this.exceptionPrinter = exceptionPrinter;
    }

    public int getMoney() {
        while (true) {
            try {
                System.out.println(GET_MONEY_MESSAGE);
                String input = Console.readLine();
                return InputParser.moneyParser(input);
            } catch (IllegalArgumentException e) {
                exceptionPrinter.print(e.getMessage());
            }
        }
    }

    public List<Integer> getWinningLottoNumber() {
        while (true) {
            try {
                System.out.println(GET_WINNING_NUMBER_MESSAGE);
                String input = Console.readLine();
                return InputParser.winningNumberParser(input);
            } catch (IllegalArgumentException e) {
                exceptionPrinter.print(e.getMessage());
            }
        }
    }

    public int getBonusLottoNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                System.out.println(GET_BONUS_NUMBER_MESSAGE);
                String input = Console.readLine();
                return InputParser.bonusNumberParser(input, winningNumbers);
            } catch (IllegalArgumentException e) {
                exceptionPrinter.print(e.getMessage());
            }
        }
    }
}
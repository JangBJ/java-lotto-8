package lotto.parse;

import lotto.validate.InputValidator;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    public static List<Integer> winningNumberParser(String winningNumber) {
        InputValidator.validateWinningNumberList(winningNumber);

        return Arrays.stream(winningNumber.trim().split(","))
                .map(Integer::parseInt)
                .toList();
    }

    public static int bonusNumberParser(String bonusNumber, List<Integer> winningNumberList) {
        InputValidator.validateBonusNumber(bonusNumber, winningNumberList);

        return Integer.parseInt(bonusNumber.trim());
    }

    public static int moneyParser(String money) {
        InputValidator.validateMoney(money);

        return Integer.parseInt(money.trim());
    }
}


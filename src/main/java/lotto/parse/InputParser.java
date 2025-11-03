package lotto.parse;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    public List<Integer> winningNumberParser(String winningNumber) {
        return Arrays.stream(winningNumber.trim().split(","))
                .map(Integer::parseInt)
                .toList();
    }

    public int bonusNumberParser(String bonusNumber) {
        return Integer.parseInt(bonusNumber.trim());
    }
}


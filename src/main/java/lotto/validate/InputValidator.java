package lotto.validate;

import lotto.exception.InputException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class InputValidator {

    private static final int LOTTO_PRICE = 1000;
    private static final int MAX_MONEY = 1_000_000_000; // 10억원 제한
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int WINNING_NUMBER_COUNT = 6;
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("\\d+");
    private static final Pattern WINNING_ALLOWED_PATTERN = Pattern.compile("[\\d\\s,]+");

    public static void validateMoney(String money) {
        if (money == null || money.trim().isEmpty()) {
            throw new IllegalArgumentException(InputException.MONEY_BLANK.getMessage());
        }

        String trimmed = money.trim();

        if (!NUMERIC_PATTERN.matcher(trimmed).matches()) {
            throw new IllegalArgumentException(InputException.MONEY_NOT_NUMERIC.getMessage());
        }

        int amount;
        try {
            amount = Integer.parseInt(trimmed);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputException.MONEY_TOO_LARGE.getMessage());
        }

        if (amount <= 0) {
            throw new IllegalArgumentException(InputException.MONEY_NOT_POSITIVE.getMessage());
        }

        if (amount > MAX_MONEY) {
            throw new IllegalArgumentException(InputException.MONEY_TOO_LARGE.getMessage());
        }

        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(InputException.MONEY_NOT_THOUSANDS.getMessage());
        }
    }

    public static void validateWinningNumberList(String winningNumber) {
        if (winningNumber == null || winningNumber.trim().isEmpty()) {
            throw new IllegalArgumentException(InputException.WINNING_BLANK.getMessage());
        }

        String trimmed = winningNumber.trim();

        if (!WINNING_ALLOWED_PATTERN.matcher(trimmed).matches()) {
            throw new IllegalArgumentException(InputException.WINNING_ILLEGAL_CHAR.getMessage());
        }

        String[] parts = trimmed.split(",");

        if (parts.length != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException(InputException.WINNING_NOT_6.getMessage());
        }

        List<Integer> numbers;
        try {
            numbers = parseNumberList(parts);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputException.WINNING_NOT_NUMERIC.getMessage());
        }

        for (int number : numbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(InputException.WINNING_OUT_OF_RANGE.getMessage());
            }
        }

        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException(InputException.WINNING_DUPLICATE.getMessage());
        }
    }

    public static void validateBonusNumber(String bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber == null || bonusNumber.trim().isEmpty()) {
            throw new IllegalArgumentException(InputException.BONUS_BLANK.getMessage());
        }

        String trimmed = bonusNumber.trim();

        if (!NUMERIC_PATTERN.matcher(trimmed).matches()) {
            throw new IllegalArgumentException(InputException.BONUS_NOT_NUMERIC.getMessage());
        }

        int bonus;
        try {
            bonus = Integer.parseInt(trimmed);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputException.BONUS_NOT_NUMERIC.getMessage());
        }

        if (bonus < MIN_LOTTO_NUMBER || bonus > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(InputException.BONUS_OUT_OF_RANGE.getMessage());
        }

        if (winningNumbers.contains(bonus)) {
            throw new IllegalArgumentException(InputException.BONUS_DUPLICATE_WITH_WINNING.getMessage());
        }
    }

    private static List<Integer> parseNumberList(String[] parts) {
        return java.util.Arrays.stream(parts)
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    private static boolean hasDuplicates(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        return set.size() != numbers.size();
    }
}
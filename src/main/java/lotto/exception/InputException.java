package lotto.exception;

public enum InputException {
    // 금액
    MONEY_BLANK("구입 금액이 비어 있습니다."),
    MONEY_NOT_NUMERIC("구입 금액은 숫자만 입력해야 합니다."),
    MONEY_NOT_POSITIVE("구입 금액은 0보다 커야 합니다."),
    MONEY_NOT_THOUSANDS("구입 금액은 1,000원 단위여야 합니다."),
    MONEY_TOO_LARGE("구입 금액이 너무 큽니다."),

    // 당첨 번호
    WINNING_BLANK("당첨 번호가 비어 있습니다."),
    WINNING_ILLEGAL_CHAR("당첨 번호에는 숫자와 쉼표만 사용할 수 있습니다."),
    WINNING_NOT_6("당첨 번호는 쉼표로 구분된 6개여야 합니다."),
    WINNING_NOT_NUMERIC("당첨 번호에는 숫자만 입력해야 합니다."),
    WINNING_OUT_OF_RANGE("당첨 번호는 1~45 범위여야 합니다."),
    WINNING_DUPLICATE("당첨 번호에 중복이 있습니다."),

    // 보너스 번호
    BONUS_BLANK("보너스 번호가 비어 있습니다."),
    BONUS_NOT_NUMERIC("보너스 번호는 숫자만 입력해야 합니다."),
    BONUS_OUT_OF_RANGE("보너스 번호는 1~45 범위여야 합니다."),
    BONUS_DUPLICATE_WITH_WINNING("보너스 번호가 당첨 번호와 중복됩니다.");

    private final String message;

    InputException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

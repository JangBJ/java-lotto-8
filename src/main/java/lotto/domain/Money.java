package lotto.domain;

public class Money {

    public static final int PRICE = 1_000;

    private final int value;

    public Money(int value) {
        this.value = value;
    }

    public int MoneyToPriceCount(){
        return value/PRICE;
    }
}

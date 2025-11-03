package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumber {

    private final List<Integer> lottoNumber;

    public LottoNumber(List<Integer> lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public String toString() {
        return lottoNumber.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}

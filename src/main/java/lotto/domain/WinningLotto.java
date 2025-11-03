package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final List<Integer> winningNumberList;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumberList, int bonusNumber) {
        this.winningNumberList = winningNumberList.stream()
                .sorted()
                .toList();
        this.bonusNumber = bonusNumber;
    }

    public int countMatch(LottoNumber lottoNumber) {
        return (int)lottoNumber.getLottoNumber().stream()
                .filter(winningNumberList::contains)
                .count();
    }

    public boolean bonusMatch(LottoNumber lottoNumber) {
        return lottoNumber.getLottoNumber().contains(bonusNumber);
    }
}

package lotto.view;

import lotto.domain.LottoNumber;

import java.util.List;

public class OutputView {

    public void printLottoList(List<LottoNumber> lottoNumberList) {
        lottoNumberList.forEach(System.out::println);
    }
}

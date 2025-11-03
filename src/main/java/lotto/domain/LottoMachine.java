package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoMachine {


    public LottoNumber createRandomLottoNumbers() {
        List<Integer> randomNumberList =  Randoms.pickUniqueNumbersInRange(1,45, 6)
                .stream()
                .sorted()
                .toList();

        return new LottoNumber(randomNumberList);
    }

}

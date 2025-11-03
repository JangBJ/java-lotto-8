package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public LottoNumber createRandomLotto() {
        List<Integer> randomNumberList =  Randoms.pickUniqueNumbersInRange(1,45, 6)
                .stream()
                .sorted()
                .toList();

        return new LottoNumber(randomNumberList);
    }

    public List<LottoNumber> createRandomLottoList(int count) {
        List<LottoNumber> lottoList = new ArrayList<>();

        for(int i = 0; i < count; i++) {
            lottoList.add(createRandomLotto());
        }

        return lottoList;
    }
}

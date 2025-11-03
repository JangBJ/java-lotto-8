package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public List<Integer> createRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1,45, 6)
                .stream().sorted().toList();
    }

}

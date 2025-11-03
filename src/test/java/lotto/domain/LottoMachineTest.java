package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoMachineTest {

    private final LottoMachine lottoMachine;

    private List<Integer> lottoNumbers;

    public LottoMachineTest() {
        lottoMachine = new LottoMachine();
    }

    @BeforeEach
    void createRandomNumbers() {
        lottoNumbers = lottoMachine.createRandomLottoNumbers();
    }

    @Test
    void 랜덤_6개_번호_생성(){
        assertEquals(6, lottoNumbers.size());
    }

    @Test
    void 랜덤_6개의_번호_중복_불가(){
        assertEquals(6, new HashSet<>(lottoNumbers).size());
    }

    @Test
    void 랜덤_6개의_번호_범위(){
        assertTrue(lottoNumbers
                .stream()
                .allMatch(number -> number >=1 && number <=45));
    }
}
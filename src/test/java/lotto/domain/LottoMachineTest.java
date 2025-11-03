package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoMachineTest {

    private final LottoMachine lottoMachine;
    private LottoNumber lottoNumber;

    public LottoMachineTest() {
        lottoMachine = new LottoMachine();
    }

    @BeforeEach
    void createRandomNumbers() {
        lottoNumber = lottoMachine.createRandomLotto();
    }

    @Test
    void 랜덤_6개_번호_생성(){
        assertEquals(6, lottoNumber.getLottoNumber()
                .size());
    }

    @Test
    void 랜덤_6개의_번호_중복_불가(){
        assertEquals(6, new HashSet<>(lottoNumber.getLottoNumber())
                .size());
    }

    @Test
    void 랜덤_6개의_번호_범위(){
        assertTrue(lottoNumber.getLottoNumber()
                .stream()
                .allMatch(number -> number >=1 && number <=45));
    }

    @Test
    void 로또_번호는_여러개_생성_가능(){
        int count = 10;

        List<LottoNumber> lottoNumberList = lottoMachine.createRandomLottoList(count);

        assertEquals(count, lottoNumberList.size());
    }

}
package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    @Test
    void 일치_6개() {
        WinningLotto winning = new WinningLotto(List.of(1,2,3,4,5,6), 7);
        LottoNumber ticket = new LottoNumber(List.of(1,2,3,4,5,6));

        assertAll(
                () -> assertEquals(6, winning.countMatch(ticket)),
                () -> assertFalse(winning.bonusMatch(ticket))
        );
    }

    @Test
    void 일치_5개_보너스_일치_보너스_true() {
        WinningLotto winning = new WinningLotto(List.of(1,2,3,4,5,6), 7);
        LottoNumber ticket = new LottoNumber(List.of(1,2,3,4,5,7));

        assertAll(
                () -> assertEquals(5, winning.countMatch(ticket)),
                () -> assertTrue(winning.bonusMatch(ticket))
        );
    }

    @Test
    void 일치_5개_보너스_불일치_보너스_false() {
        WinningLotto winning = new WinningLotto(List.of(1,2,3,4,5,6), 7);
        LottoNumber ticket = new LottoNumber(List.of(1,2,3,4,5,8));

        assertAll(
                () -> assertEquals(5, winning.countMatch(ticket)),
                () -> assertFalse(winning.bonusMatch(ticket))
        );
    }

    @Test
    void 일치_4개() {
        WinningLotto winning = new WinningLotto(List.of(1,2,3,4,5,6), 7);
        LottoNumber ticket = new LottoNumber(List.of(1,2,3,4,8,9));

        assertAll(
                () -> assertEquals(4, winning.countMatch(ticket)),
                () -> assertFalse(winning.bonusMatch(ticket))
        );
    }

    @Test
    void 일치_3개() {
        WinningLotto winning = new WinningLotto(List.of(1,2,3,4,5,6), 7);
        LottoNumber ticket = new LottoNumber(List.of(1,2,3,8,9,10));

        assertAll(
                () -> assertEquals(3, winning.countMatch(ticket)),
                () -> assertFalse(winning.bonusMatch(ticket))
        );
    }

    @Test
    void 하나도_일치하지_않으면_0개_매치() {
        WinningLotto winning = new WinningLotto(List.of(1,2,3,4,5,6), 7);
        LottoNumber ticket = new LottoNumber(List.of(10,11,12,13,14,15));

        assertAll(
                () -> assertEquals(0, winning.countMatch(ticket)),
                () -> assertFalse(winning.bonusMatch(ticket))
        );
    }

    @Test
    void 당첨번호_순서가_달라도_동일하게_매치되어야_한다() {
        WinningLotto winning = new WinningLotto(List.of(6,5,4,3,2,1), 7); // 생성자에서 정렬됨
        LottoNumber ticket = new LottoNumber(List.of(1,2,3,4,5,6));

        assertEquals(6, winning.countMatch(ticket));
    }
}
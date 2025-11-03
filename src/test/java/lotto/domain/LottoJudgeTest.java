package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoJudgeTest {

    @Test
    void 각_등수_집계가_정확히_된다() {
        // given
        WinningLotto winning = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        List<LottoNumber> tickets = List.of(
                new LottoNumber(List.of(1, 2, 3, 4, 5, 6)),
                new LottoNumber(List.of(1, 2, 3, 4, 5, 7)),
                new LottoNumber(List.of(1, 2, 3, 4, 5, 8)),
                new LottoNumber(List.of(1, 2, 3, 4, 9, 10)),
                new LottoNumber(List.of(1, 2, 3, 11, 12, 13)),
                new LottoNumber(List.of(10, 11, 12, 13, 14, 15))
        );

        LottoJudge judge = new LottoJudge();

        // when
        LottoResult result = judge.winningJudge(tickets, winning);

        // then
        assertAll(
                () -> assertEquals(1, result.countOf(WinningRank.FIRST)),
                () -> assertEquals(1, result.countOf(WinningRank.SECOND)),
                () -> assertEquals(1, result.countOf(WinningRank.THIRD)),
                () -> assertEquals(1, result.countOf(WinningRank.FOURTH)),
                () -> assertEquals(1, result.countOf(WinningRank.FIFTH)),
                () -> assertEquals(1, result.countOf(WinningRank.MISS))
        );
    }

}
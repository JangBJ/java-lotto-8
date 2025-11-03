package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    @Test
    void 초기_모든_등수는_0이다() {
        LottoResult res = new LottoResult();
        for (WinningRank r : WinningRank.values()) {
            assertEquals(0, res.countOf(r), r + " 초기 카운트는 0");
        }
    }

    @Test
    void 등수_추가시_카운트가_증가한다() {
        LottoResult res = new LottoResult();
        res.addWinningRank(WinningRank.FIFTH);
        res.addWinningRank(WinningRank.FIFTH);
        res.addWinningRank(WinningRank.THIRD);

        assertAll(
                () -> assertEquals(2, res.countOf(WinningRank.FIFTH)),
                () -> assertEquals(1, res.countOf(WinningRank.THIRD)),
                () -> assertEquals(0, res.countOf(WinningRank.FIRST))
        );
    }

    @Test
    void 총상금은_등수별_상금과_개수의_합이다() {
        LottoResult res = new LottoResult();
        res.addWinningRank(WinningRank.FIRST);
        res.addWinningRank(WinningRank.SECOND);

        assertEquals(2_030_000_000, res.totalPrizeMoney());
    }

    @Test
    void 수익률은_총상금_나누기_지불액_퍼센트_소수점_1자리() {
        LottoResult res = new LottoResult();
        res.addWinningRank(WinningRank.FIFTH);

        String percent = res.profitPercent(8_000);
        assertEquals("62.5%", percent);
    }

}
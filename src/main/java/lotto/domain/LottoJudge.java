package lotto.domain;

import java.util.List;

public class LottoJudge {

    public LottoResult winningJudge(List<LottoNumber> tickets, WinningLotto winning) {
        LottoResult result = new LottoResult();
        for (LottoNumber t : tickets) {
            int match = winning.countMatch(t);
            boolean bonus = (match == 5) && winning.bonusMatch(t);
            result.addWinningRank(WinningRank.of(match, bonus));
        }
        return result;
    }
}

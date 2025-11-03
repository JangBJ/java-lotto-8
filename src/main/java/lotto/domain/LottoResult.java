package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

    private final EnumMap<WinningRank, Integer> counts = new EnumMap<>(WinningRank.class);

    public LottoResult() {
        for (WinningRank winningRank : WinningRank.values()) {
            counts.put(winningRank, 0);
        }
    }

    public void addWinningRank(WinningRank winningRank) {
        counts.merge(winningRank, 1, Integer::sum);
    }

    public int countOf(WinningRank winningRank) {
        return counts.get(winningRank);
    }

    public int totalPrizeMoney(){
        int sum = 0;

        for(WinningRank winningRank : WinningRank.values()) {
            sum += (int) (winningRank.prizeMoney * counts.get(winningRank));
        }
        return sum;
    }

    public String profitPercent(int paid) {
        double ratio = (double) totalPrizeMoney() / paid;

        return String.format("%.2f%%", ratio * 100);
    }
}

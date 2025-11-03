package lotto.domain;

public enum WinningRank {
    FIRST (6, false, 2_000_000_000L),
    SECOND(5, true, 30_000_000L),
    THIRD (5, false, 1_500_000L),
    FOURTH(4, false, 50_000L),
    FIFTH (3, false, 5_000L),
    MISS  (0, false, 0L);

    public final int match;
    public final boolean bonus;
    public final long prizeMoney;

    WinningRank(int match, boolean bonus, long prize) {
        this.match = match;
        this.bonus = bonus;
        this.prizeMoney = prize;
    }

    public static WinningRank of(int matchCount, boolean bonusMatch) {
        switch (matchCount) {
            case 6: return FIRST;
            case 5: return rankForFive(bonusMatch);
            case 4: return FOURTH;
            case 3: return FIFTH;
            default: return MISS;
        }
    }

    private static WinningRank rankForFive(boolean bonusMatch) {
        if(bonusMatch) return SECOND;
        return THIRD;
    }
}
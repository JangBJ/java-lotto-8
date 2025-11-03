package lotto.domain;

public enum WinningRank {
    FIRST (6, false, 2_000_000_000L),
    SECOND(5, true,     30_000_000L),
    THIRD (5, false,     1_500_000L),
    FOURTH(4, false,        50_000L),
    FIFTH (3, false,         5_000L),
    MISS  (0, false,              0L);

    public final int match;
    public final boolean bonus;
    public final long prizeMoney;

    WinningRank(int match, boolean bonus, long prize) {
        this.match = match;
        this.bonus = bonus;
        this.prizeMoney = prize;
    }

    public static WinningRank of(int matchCount, boolean bonusMatched) {
        if (matchCount == 6) return FIRST;
        if (matchCount == 5) return bonusMatched ? SECOND : THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return MISS;
    }
}
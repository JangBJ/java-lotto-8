package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.WinningRank;

import java.util.List;

public class OutputView {

    private static final String BUY_SUCCESS = "%d개를 구매했습니다.";

    public void printLottoList(List<LottoNumber> lottoNumberList) {
        System.out.printf(BUY_SUCCESS, lottoNumberList.size());
        System.out.println();
        lottoNumberList.forEach(System.out::println);
    }

    public void printStatistics(LottoResult result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (%,d원) - %d개%n",
                WinningRank.FIFTH.prizeMoney,  result.countOf(WinningRank.FIFTH));
        System.out.printf("4개 일치 (%,d원) - %d개%n",
                WinningRank.FOURTH.prizeMoney, result.countOf(WinningRank.FOURTH));
        System.out.printf("5개 일치 (%,d원) - %d개%n",
                WinningRank.THIRD.prizeMoney,  result.countOf(WinningRank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (%,d원) - %d개%n",
                WinningRank.SECOND.prizeMoney, result.countOf(WinningRank.SECOND));
        System.out.printf("6개 일치 (%,d원) - %d개%n",
                WinningRank.FIRST.prizeMoney,  result.countOf(WinningRank.FIRST));
    }

    public void printProfitPercent(LottoResult result, int money) {
        System.out.printf("총 수익률은 %s입니다.%n", result.profitPercent(money));
    }
}

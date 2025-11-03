package lotto;

import lotto.domain.*;
import lotto.parse.InputParser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;

    public LottoGame(final InputView inputView, final OutputView outputView,
                     final LottoMachine lottoMachine) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = lottoMachine;
    }

    public void start() {
        int money = inputView.getMoney();
        Money purchase = new Money(money);
        int count = purchase.moneyToPriceCount();

        List<LottoNumber> tickets = lottoMachine.createRandomLottoList(count);
        outputView.printLottoList(tickets);
        System.out.println();

        List<Integer> winningNumberList = inputView.getWinningLottoNumber();

        int bonusNumber = inputView.getBonusLottoNumber(winningNumberList);

        WinningLotto winning = new WinningLotto(winningNumberList, bonusNumber);
        LottoJudge judge = new LottoJudge();
        LottoResult result = judge.winningJudge(tickets, winning);

        outputView.printStatistics(result);
        outputView.printProfitPercent(result, money);
    }
}

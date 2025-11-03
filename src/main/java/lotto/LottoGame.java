package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
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


    public void start(){
        int money  = Integer.parseInt(inputView.getPrice());
        Money moneyCount = new Money(money);
        int count = moneyCount.moneyToPriceCount();
        inputView.getWinningLottoNumber();
        inputView.getBonusLottoNumber();

        List<LottoNumber> lottoNumberList = lottoMachine.createRandomLottoList(count);

        outputView.printLottoList(lottoNumberList);
    }
}

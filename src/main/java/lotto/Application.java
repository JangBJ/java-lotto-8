package lotto;

import lotto.domain.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {

        new LottoGame(new InputView(),
                new OutputView(),
                new LottoMachine()).start();

    }
}

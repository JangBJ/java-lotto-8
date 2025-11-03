package lotto.view;


import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String GET_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String GET_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String GET_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String getPrice(){
        System.out.println(GET_MONEY_MESSAGE);
        return Console.readLine();
    }

    public String getWinningLottoNumber(){
        System.out.println(GET_WINNING_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public String getBonusLottoNumber(){
        System.out.println(GET_BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }

}


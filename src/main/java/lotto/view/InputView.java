package lotto.view;


import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getPrice(){
        return Console.readLine();
    }

    public String getWinningLottoNumber(){
        return Console.readLine();
    }

    public String getBonusLottoNumber(){
        return Console.readLine();
    }

}


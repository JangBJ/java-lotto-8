package view;


import java.io.Console;

public class InputView {

    private final Console console;

    public InputView(Console console) {
        this.console = console;
    }

    public String getPrice(){
        return console.readLine();
    }

    public String getWinningLottoNumber(){
        return console.readLine();
    }

    public String getBonusLottoNumber(){
        return console.readLine();
    }

}


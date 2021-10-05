package baseball.view.impl;

import java.io.PrintStream;

import baseball.domain.BaseballResult;
import baseball.domain.Numbers;
import baseball.exception.BaseballException;
import baseball.view.View;
import nextstep.utils.Console;

public class ConsoleView implements View {

    private final PrintStream out = System.out;

    @Override
    public Numbers getNumbers() {
        while(true) {
            out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();

            try {
                return new Numbers(input);
            } catch(BaseballException ex) {
                out.println(ex.getMessage());
            }
        }
    }

    @Override
    public void printResult(BaseballResult result) {
        out.println(result.getResultString());
    }


    @Override
    public GameStatus confirmRestart() {
        while(true) {
            out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
            String input = Console.readLine();

            // TODO: try / catch 블럭도 indent 제약사항에 걸리는걸까?
            try {
                return GameStatus.from(input);
            } catch(BaseballException ex) {
                out.println(ex.getMessage());
            }
        }
    }

    @Override
    public void printFinish() {
        out.println("게임 끝");
    }
}

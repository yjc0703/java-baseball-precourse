package baseball;

import baseball.controller.GameController;
import baseball.service.GameService;
import baseball.view.View;
import baseball.view.impl.ConsoleView;
import baseball.view.impl.GameStatus;

public class Application {
    public static void main(String[] args) {
        View view = new ConsoleView();
        GameService service = new GameService();

        GameController controller = new GameController(view, service);
        GameStatus status = null;

        do {
            status = controller.play();
        } while(status.equals(GameStatus.CONTINUE));
    }
}

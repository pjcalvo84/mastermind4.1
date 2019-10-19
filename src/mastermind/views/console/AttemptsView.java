package mastermind.views.console;

import mastermind.controllers.ProposalController;
import mastermind.models.Game;
import mastermind.views.MessageView;
import santaTecla.utils.WithConsoleView;

public class AttemptsView extends WithConsoleView {


    private Game game;

    public AttemptsView(Game game){
        this.game = game;
    }

    void writeln() {
        this.console.writeln(MessageView.ATTEMPTS.getMessage().replaceFirst("#attempts",
                "" + game.getAttempts()));
    }
}

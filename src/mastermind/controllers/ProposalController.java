package mastermind.controllers;

import java.util.ArrayList;
import java.util.List;

import mastermind.models.Combination;
import mastermind.models.ProposedCombination;
import mastermind.models.Session;
import mastermind.types.Color;
import mastermind.types.Error;
import mastermind.views.console.ErrorView;
import mastermind.views.MessageView;
import mastermind.views.console.ColorView;
import mastermind.views.console.GameView;
import mastermind.views.console.ProposedCombinationView;

public class ProposalController extends Controller {

    private ProposedCombinationView proposedCombinationView;

    public ProposalController(Session session) {
        super(session);
    }

    @Override
    public void control(){

        ProposedCombination proposedCombination = new ProposedCombination();
        this.proposedCombinationView = new ProposedCombinationView(proposedCombination);
        this.proposedCombinationView.read();
        this.session.addProposedCombination(proposedCombination);

        this.proposedCombinationView.writeln();
        new GameView(this.session.getGame()).writeGame();
        this.checkGame();
    }

    private void checkGame(){
        if (this.session.isWinner()) {
            this.proposedCombinationView.writeln(MessageView.WINNER.getMessage());
            this.session.next();
        } else if (this.session.isLooser()) {
            this.proposedCombinationView.writeln(MessageView.LOOSER.getMessage());
            this.session.next();
        }
    }
}

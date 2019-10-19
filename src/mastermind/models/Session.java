package mastermind.models;

import java.util.List;

import mastermind.types.Color;

public class Session  {

    private final State state;
    private final Game game;

    public Session() {
        this.state = new State();
        this.game = new Game();
    }

    public void resume() {
        this.game.clear();
        this.state.reset();
    }


    public void next() {
        this.state.next();
    }

    public StateValue getStateValue() {
        return this.state.getValue();
    }

    public void addProposedCombination(ProposedCombination proposedCombination){
        this.game.addProposedCombination(proposedCombination);
    }

    public SecretCombination getSecretCombination(){
        return this.game.getSecretCombination();
    }
    public boolean isWinner() {
        return this.game.isWinner();
    }

    public boolean isLooser() {
        return this.game.isLooser();
    }

    public Game getGame() {
        return this.game;
    }

}


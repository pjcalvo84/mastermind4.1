package mastermind.views.console;

import mastermind.models.Game;
import mastermind.models.Session;
import mastermind.types.Color;
import santaTecla.utils.WithConsoleView;


public class GameView extends WithConsoleView{

    private Game game;

    public GameView(Game game) {
        this.game = game;
    }

    public void writeGame(){
        new AttemptsView(game).writeln();
        new SecretCombinationView(game.getSecretCombination()).writeln();
        for(int i = 0; i < game.getAttempts(); i++){
            this.writeColors(i);
        }
    }

    private void writeColors(int position){
        for (Color color : game.getColors(position)) {
            new ColorView(color).write();
        }
        new ResultView().writeln(game.getBlacks(position),game.getWhites(position));
    }
}

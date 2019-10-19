package mastermind.controllers;

import mastermind.models.Game;
import mastermind.models.Session;
import mastermind.views.console.SecretCombinationView;
import mastermind.views.console.StartView;

public class StartController extends Controller {

    public StartController(Session session) {
        super(session);
    }

    public void control(){
        new StartView().writeGameIntro();
        new SecretCombinationView(session.getSecretCombination()).writeln();
        session.next();
    }
}

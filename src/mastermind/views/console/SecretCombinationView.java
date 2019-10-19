package mastermind.views.console;

import mastermind.controllers.Controller;
import mastermind.models.SecretCombination;
import mastermind.views.MessageView;
import santaTecla.utils.WithConsoleView;

public class SecretCombinationView extends WithConsoleView {

    private SecretCombination secretCombination;

    public SecretCombinationView(SecretCombination secretCombination){
        this.secretCombination = secretCombination;
    }

    public void writeln() {
        for (int i = 0; i < secretCombination.getColors().size(); i++) {
            this.console.write(MessageView.SECRET.getMessage());
        }
        this.console.writeln();
    }

}

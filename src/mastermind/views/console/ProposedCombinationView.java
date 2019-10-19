package mastermind.views.console;


import java.util.ArrayList;
import java.util.List;

import mastermind.models.Combination;
import mastermind.models.ProposedCombination;
import mastermind.types.Color;
import mastermind.types.Error;
import santaTecla.utils.WithConsoleView;
import mastermind.views.MessageView;

public class ProposedCombinationView extends WithConsoleView {

    private ProposedCombination proposedCombination;

    public ProposedCombinationView(ProposedCombination proposedCombination) {
        this.proposedCombination = proposedCombination;
    }

    public void read() {
        Error error;
        List<Color> colors;
        do {
            String characters = this.console.readString(MessageView.PROPOSED_COMBINATION.getMessage());
            colors = new ArrayList<Color>();
            for (int i = 0; i < characters.length(); i++) {
                colors.add(ColorView.getInstance(characters.charAt(i)));
            }
            error = addProposedCombination(colors);
            if (error != null) {
                new ErrorView(error).writeln();
            }
        } while (error != null);
        this.proposedCombination.set(colors);
    }

    public void writeln(){
        this.console.writeln();
    }

    public void writeln(String message){
        this.console.writeln(message);
    }

    void write() {
        for (Color color : this.proposedCombination.getColors()) {
            new ColorView(color).write();
        }
    }

    private Error addProposedCombination(List<Color> colors) {
        Error error = null;
        if (colors.size() != Combination.getWidth()) {
            error = Error.WRONG_LENGTH;
        } else {
            for (int i = 0; i < colors.size(); i++) {
                if (colors.get(i) == null) {
                    error = Error.WRONG_CHARACTERS;
                } else {
                    for (int j = i+1; j < colors.size(); j++) {
                        if (colors.get(i) == colors.get(j)) {
                            error = Error.DUPLICATED;
                        }
                    }
                }
            }
        }
        if (error == null){
            this.proposedCombination.set(colors);
        }
        return error;
    }
}

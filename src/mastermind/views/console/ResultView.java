package mastermind.views.console;

import mastermind.controllers.ProposalController;
import mastermind.views.MessageView;
import santaTecla.utils.WithConsoleView;

public class ResultView extends WithConsoleView {


    private Result result;
    public ResultView(Result result) {
        this.result = result;
    	}

    public void writeln() {
        this.console.writeln(MessageView.RESULT.getMessage()
                .replaceFirst("#blacks", "" + result.getBlacks())
                .replaceFirst("#whites", "" + result.getWhites()));
    }
}

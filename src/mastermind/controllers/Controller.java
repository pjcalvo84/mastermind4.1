package mastermind.controllers;

import mastermind.models.Combination;
import mastermind.models.Game;
import mastermind.models.Session;

public abstract class Controller {

	protected Session session;

	Controller(Session session) {
		this.session = session;
	}

    public abstract void control();

}

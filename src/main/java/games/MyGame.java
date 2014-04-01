package games;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import states.GameState;

public class MyGame extends StateBasedGame {

	public static void main(String[] args) {
		try {
			AppGameContainer agc = new AppGameContainer(new MyGame());
			agc.setDisplayMode(512, 512, false);
			agc.setTargetFrameRate(60);
			agc.setShowFPS(false);
			agc.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public MyGame() {
		super("15 Puzzle");

	}

	public void initStatesList(GameContainer container) throws SlickException {
		addState(new GameState());

	}

}

package states;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import controllers.Event;
import controllers.InputController;

public class GameState extends BasicGameState {

	public static final int CELL_DIM = 128;
	private Image[][] images = new Image[4][4];
	private SpriteSheet sprite;
	private int emptyX = 3, emptyY = 3;
	private InputController inputController;

	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		inputController = InputController.getInstance();
		sprite = new SpriteSheet("res/screen.jpg", CELL_DIM, CELL_DIM);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				images[i][j] = sprite.getSubImage(i, j);
			}
		}

	}

	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		drawGame(g);
	}

	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {

		Input input = container.getInput();
		int x = input.getMouseX() / CELL_DIM;
		int y = input.getMouseY() / CELL_DIM;
		List<Integer[]> neighbors = inputController.dispatch(container, input,
				emptyX, emptyY);
		switchCells(x, y, neighbors);

	}

	public int getID() {
		return 0;
	}

	private void drawGame(Graphics g) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				g.drawImage(images[i][j], i * CELL_DIM, j * CELL_DIM);
			}
		}
	}

	private void switchCells(int cx, int cy, List<Integer[]> nbs) {
		Event event = inputController.getEvent();
		boolean isKeyPressed = nbs.size() == 1;
		boolean isSPressed = event != null && event.equals(Event.KEY_S)
				&& nbs.size() == 0;

		for (Integer[] nb : nbs) {
			if (event != null && event.equals(Event.MOUSE_DOWN) && nb[0] == cx
					&& nb[1] == cy) {

				swap(cx, cy);
			}
		}

		if (event != null && !event.equals(Event.KEY_S) && isKeyPressed) {
			int x = nbs.get(0)[0];
			int y = nbs.get(0)[1];
			swap(x, y);

		}

		if (isSPressed) {
			shuffle();
			inputController.setEvent(Event.UNKNOWN);

		}

	}

	private void shuffle() {
		List<Integer> lst = new ArrayList<Integer>();
		for (int i = 0; i < 16; i++) {
			lst.add(i);
		}
		Collections.shuffle(lst);
		for (Integer i : lst) {
			swap((int) i / 4, i % 4);
		}

	}

	private void swap(int cx, int cy) {
		Image tmp = images[cx][cy];
		images[cx][cy] = images[emptyX][emptyY];
		images[emptyX][emptyY] = tmp;
		emptyX = cx;
		emptyY = cy;
	}
}
